package core.multithreading.runnableTraining;

public class StopThread4 {
    private static boolean stopRequested = false;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isStopRequested()) {
                    i++;
                    System.out.println(i);
                }
            }
        });

        t.start();
        Thread.sleep(1000);
        requestStop();
    }
}
