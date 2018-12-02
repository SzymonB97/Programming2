package core.multithreading.examples;

public class HelloWithImplements implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new HelloWithImplements());
        t.start();
        Thread.sleep(1);
        System.out.println("Hello World");
    }

    @Override
    public void run() {
        System.out.println("Hello I'm thread");
    }
}
