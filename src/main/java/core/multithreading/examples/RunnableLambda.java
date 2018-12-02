package core.multithreading.examples;

public class RunnableLambda {
    public static void main(String[] args) {
        System.out.println("Main thread");

        Runnable runnable = () -> {
            System.out.println("Second thread");
        };
        runnable.run();

        //second way to start
        /*Thread thread = new Thread(runnable);
        thread.start();*/
    }
}
