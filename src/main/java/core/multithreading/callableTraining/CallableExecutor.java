package core.multithreading.callableTraining;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutor implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Hello I'm new thread";
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello main thread!!!");

        Callable<String> thread = new CallableExecutor();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(thread);
        System.out.println(future.get());
        executor.shutdown();
    }
}
