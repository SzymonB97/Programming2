package core.stringNumbersSum;

public class StringCalculator {

    public static void main(String[] args) {
        int result = sumFromString("aaa-123aa6abb78c853m-214");
        System.out.println(result);
    }

    public static int sumFromString(String word) {
        String[] numbers = word.replaceAll("[^0-9\\-]", " ").split(" ");

        int sum = 0;

        for (String number : numbers) {
            if (!number.equals(" ") && !number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

}
