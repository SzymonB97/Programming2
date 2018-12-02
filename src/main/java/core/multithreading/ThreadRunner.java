package core.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadRunner implements Callable<String> {
    private static final long MAX_VALUE = 100_000_000_000L;
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        execute();
        multiExecute();
    }

    private static void multiExecute() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            list.add(new ThreadRunner());
        }

        List<Future<String>> results = executor.invokeAll(list);
        for (Future<String> result : results) {
            System.out.println(result.get());
        }
        executor.shutdown();
    }

    private static void execute() {
        long startTime = System.nanoTime();
        for (long i = 0; i < MAX_VALUE; i++) ;
        long endTime = System.nanoTime();
        System.out.println(Thread.currentThread().getName() + ": " + (double) (endTime - startTime) / 1_000_000_000);
    }

    @Override
    public String call() throws Exception {
        long startTime = System.nanoTime();
        for (long i = 0; i < MAX_VALUE /NUMBER_OF_THREADS; i++) ;
        long endTime = System.nanoTime();
        return String.format("%s: %s", Thread.currentThread().getName(), String.valueOf((double) (endTime - startTime) / 1_000_000_000));
    }
}
