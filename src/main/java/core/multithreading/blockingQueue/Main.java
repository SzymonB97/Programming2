package core.multithreading.blockingQueue;

public class Main  {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new BlockingQueue<>(2);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put("Napis1");
                    queue.put("Napis2");
                    queue.put("Napis3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String element = queue.take();
                    System.out.println("Taken " + element);
                    queue.put("Napis4");
                    queue.put("Napis5");
                    queue.put("Napis6");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String element = queue.take();
                    System.out.println("Taken " + element);
                    queue.put("Napis7");
                    queue.put("Napis8");
                    queue.put("Napis9");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Start");
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2000);
        queue.take();
        Thread.sleep(2000);
        queue.take();
        Thread.sleep(2000);
        queue.take();
        Thread.sleep(2000);
        queue.take();
        Thread.sleep(2000);
        queue.take();
    }
}
