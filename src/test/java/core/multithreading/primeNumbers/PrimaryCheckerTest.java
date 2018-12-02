package core.multithreading.primeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

class PrimaryCheckerTest {

    @ParameterizedTest
    @MethodSource("getNumbers")
    void testIsPrime(long number, boolean expectedResult) {
        PrimaryChecker primaryChecker = new PrimaryChecker();
        boolean result = primaryChecker.isPrime(number);
        Assertions.assertEquals(result, expectedResult);
    }

    static Stream<Arguments> getNumbers() {
        return Stream.of(
                arguments(0, false),
                arguments(1, false),
                arguments(2, true),
                arguments(7, true),
                arguments(10, false),
                arguments(11, true),
                arguments(100, false),
                arguments(23728141, false)
        );
    }
}