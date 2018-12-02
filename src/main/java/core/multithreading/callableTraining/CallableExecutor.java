package core.multithreading.callableTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallableExecutor implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello main thread!!!");

        //runSingleThread();
        runMultiThreads();
    }

    private static void runMultiThreads() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        List<Callable<String>> list = new ArrayList<>();

        IntStream.range(0, 8).forEach(i -> list.add(new CallableExecutor()));
        executor.invokeAll(list);
        Thread.sleep(1000);

        List<Future<String>> threadResults = executor.invokeAll(list);
        for (Future<String> threadResult : threadResults) {
            System.out.println(threadResult.get());
        }
        executor.shutdown();
    }

    private static void runSingleThread() throws InterruptedException, ExecutionException {
        Callable<String> thread = new CallableExecutor();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(thread);
        System.out.println(future.get());
        executor.shutdown();
    }
}
