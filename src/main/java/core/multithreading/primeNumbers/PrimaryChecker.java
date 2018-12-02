package core.multithreading.primeNumbers;

public class PrimaryChecker {
    public static void main(String[] args) {
        System.out.println(isPrime(10));
    }

    public static boolean isPrime(long number) {
        if (number < 2) return false;

        int counter = 0;
        for (int i = 2; i < number; i++) {
            if (counter > 2) return false;
            if (number % (i - 1) == 0) {
                counter++;
            }
        }

        return true;
    }
}
