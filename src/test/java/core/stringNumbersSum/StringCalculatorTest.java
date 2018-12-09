package core.stringNumbersSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringCalculatorTest {

    @ParameterizedTest
    @MethodSource("getWords")
    void shouldReturnSumOfNumbers (String word, int expected) {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.sumFromString(word);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> getWords() {
        return Stream.of(
                arguments("abc-123xyz", -123),
                arguments("aa11b33", 44),
                arguments("7 13", 20)
        );
    }
}