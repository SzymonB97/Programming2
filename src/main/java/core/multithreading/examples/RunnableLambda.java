package core.multithreading.examples;

public class RunnableLambda {
    public static void main(String[] args) {
        System.out.println("Main thread");

        Runnable runnable = () -> {
            System.out.println("Second thread");
            Thread secondThread = Thread.currentThread();
            System.out.println("Second thread: " + secondThread.getName());
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread mainThread = Thread.currentThread();
        System.out.println("Main thread: " + mainThread.getName());
    }
}
