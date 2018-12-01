package core.multithreading;

public class StopThread3 {
    //poprzez użycie volatile zabezpieczamy się przed złym odczytem wartości zmiennej przez wątki
    private static volatile boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Uruchomiono nowy wątek");
                int i = 0;
                while (!stopRequested) {
                    i++;
                    System.out.println(i);
                }
                System.out.println("Zakończono drugi wątek");
            }
        });

        System.out.println("Uruchomiono główny wątek");
        t.start();
        Thread.sleep(1000);
        stopRequested = true;
        System.out.println("Zakończono główny wątek");
    }
}