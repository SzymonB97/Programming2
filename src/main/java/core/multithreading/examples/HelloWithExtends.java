package core.multithreading.examples;

public class HelloWithExtends extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread();
        t.start();
        Thread.sleep(1);
        System.out.println("Hello World");
    }

    @Override
    public void run() {
        System.out.println("Hello I'm thread");
    }
}
