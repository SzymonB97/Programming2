package core.multithreading.examples;

public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    i++;
                    System.out.println(i);
                }
            }
        });
        t.start();
        Thread.sleep(5000);
        t.stop();
    }
}
