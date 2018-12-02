package core.multithreading.primeNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimaryChecker {
    private static final String FILE_PATH1 = "D:\\Projekty Java\\Programming2\\src\\main\\java\\core\\multithreading\\primeNumbers\\numbers.txt";
    private static final String FILE_PATH2 = "D:\\Projekty Java\\Programming2\\src\\main\\java\\core\\multithreading\\primeNumbers\\primes-to-1000k.txt";

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("Ilośc liczb pierwszych w pliku: " + getAndCheckNumbers());
        long endTime = System.nanoTime();
        System.out.println("Czas wykonania: " + ((endTime - startTime)/1_000_000 + " ms"));
    }

    private static int getAndCheckNumbers() {
        int primeCounter = 0;
        try (Scanner scanner = new Scanner(new File(FILE_PATH1))){
            while (scanner.hasNextLong()) {
                if (isPrime(scanner.nextInt())) primeCounter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return primeCounter;
    }

    public static boolean isPrime(long number) {
        if (number < 2) return false;
        if (number == 2) return true;

        for (long i = 2; i <= Math.sqrt(number); i++) {
            //wystarczy tylko takie sprawdzenie ponieważ zaczynamy od 2, więc mamy od razu sprawdzoną 2 i 1
            //wystarczy jeden dzielnik więcej aby stwierdzić, że liczba nie jest pierwsza
            if (number % (i) == 0) return false;
        }

        return true;
    }
}
