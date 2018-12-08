package core.sms;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SmsConverter {

    private static final int ONE_SMS_LENGTH = 160;

    public static void main(String[] args) {
        StringBuilder convertMessage = convert("Ala ola ela");
        int smsResult = howMuchSms(convertMessage);

        System.out.println(convertMessage);
        System.out.println("Ilość sms-ów: " + smsResult);
    }

    public static int howMuchSms(StringBuilder convertMessage) {
        int smsLength = convertMessage.length();
        int smsAmount = 0;
        double modulo = (double) smsLength % ONE_SMS_LENGTH;

        if (modulo == 0) {
            smsAmount = smsLength / ONE_SMS_LENGTH;
        } else
            smsAmount = smsLength / ONE_SMS_LENGTH + 1;

        return smsAmount;
    }

    public static StringBuilder convert(String message) {
        List<String> stringList = Pattern.compile(" ")
                .splitAsStream(message)
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        for (String word : stringList) {
            String s = word.substring(0, 1).toUpperCase();

            if (word.length() > 0) {
                s += word.substring(1);
            }

            result.append(s);
        }

        return result;
    }
}
