package core.multithreading.examples;

public class HanselAndGretel {
    private static void doAction(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread hansel = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Jaś przygotowuje i je śniadanie");
                doAction(5000);
                System.out.println("Jaś skończył śniadanie");

                System.out.println("Jaś bierze prysznic");
                doAction(3000);
                System.out.println("Jaś skończył prysznic");

                System.out.println("Jaś ubiera się");
                doAction(1000);
                System.out.println("Jaś skończył się ubierać");

                System.out.println("Jaś idzie na zakupy");
                doAction(15000);
                System.out.println("Jaś wrócił z zakupów");

                System.out.println("Jaś zaczyna grać na konsoli");
                doAction(5000);
                System.out.println("Jaś skończył grać na konsoli");

                System.out.println("Jaś skończył swój dzień");
            }
        });

        Thread gretel = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Małgosia idzie pobiegać");
                doAction(6000);
                System.out.println("Małgosia skończyła biegać");

                System.out.println("Małgosia bierze prysznic");
                doAction(2000);
                System.out.println("Małgosia skończyła prysznic");

                System.out.println("Małgosia je śniadanie");
                doAction(1000);
                System.out.println("Małgosia skończyła śniadanie");

                System.out.println("Małgosia ubiera się");
                doAction(1000);
                System.out.println("Małgosia skończyła się ubierać");

                System.out.println("Małgosia idzie na spotkanie z koleżanką");
                doAction(25000);
                System.out.println("Małgosia wraca z spotkania");

                System.out.println("Małgosia skończyła swój dzień");
            }
        });

        hansel.start();
        gretel.start();
        //join powoduje że wątek główny czeka aż zakończą sie dwa na których użyliśmy tej metody
        //i dopiero potem wykonuje dlaszy kod
        hansel.join();
        gretel.join();
        System.out.println("Koniec dnia!!!");
    }
}
