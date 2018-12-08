package core.sms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SmsConverterTest {

    @ParameterizedTest
    @MethodSource("messagesToCheck")
    void shouldChangeMessage(String message, String expected) {
        SmsConverter converter = new SmsConverter();
        StringBuilder result = converter.convert(message);
        Assertions.assertEquals(expected, result.toString());
    }

    private static Stream<Arguments> messagesToCheck() {
        return Stream.of(
                arguments("Ala, ola ela","Ala,OlaEla" ),
                arguments("Będę później, przepraszam", "BędęPóźniej,Przepraszam"),
                arguments("Zrób zakupy jak będziesz wracał", "ZróbZakupyJakBędzieszWracał")
        );
    }

    @ParameterizedTest
    @MethodSource("getConvertMessages")
    void shouldGiveAmountOfSms(StringBuilder message, int smsSum) {
        SmsConverter smsCalculator = new SmsConverter();
        int result = smsCalculator.howMuchSms(message);
        Assertions.assertEquals(smsSum, result);
    }

    private static Stream<Arguments> getConvertMessages() {
        return Stream.of(
                arguments("Ala,OlaEla", 1),
                arguments("BędęPóźniej,Przepraszam", 1),
                arguments("ZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWrac", 1),
                arguments("ZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracałZróbZakupyJakBędzieszWracsafafasfs", 2)
        );
    }
}