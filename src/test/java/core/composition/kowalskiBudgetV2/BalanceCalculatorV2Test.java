package core.composition.kowalskiBudgetV2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

class BalanceCalculatorV2Test {

    @ParameterizedTest
    @MethodSource("getData")
    void testCalculate(BalanceData data, BigDecimal result) {
        //given
        BalanceCalculatorV2 calculator = new BalanceCalculatorV2();

        //when
        BigDecimal balance = calculator.calculate(data);

        //then
        Assertions.assertEquals(result, balance);
    }

    //wpisujemy wartości jako String ponieważ nie możemy tak po prostu utworzyć wartości liczbowej typu BigDecimal
    static Stream<Arguments> getData() {
        return Stream.of(Arguments.of(
                new BalanceData(Arrays.asList(BigDecimal.ZERO), Arrays.asList(BigDecimal.ZERO)), BigDecimal.ZERO
                ),
                Arguments.of(new BalanceData(
                                Arrays.asList(BigDecimal.ONE,
                                        new BigDecimal("120")),
                                Arrays.asList(new BigDecimal("50"))
                        ),
                        new BigDecimal("71")
                ) //Arguments.of(data, result)
        );
    }
}