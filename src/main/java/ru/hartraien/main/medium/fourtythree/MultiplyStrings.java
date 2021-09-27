package ru.hartraien.main.medium.fourtythree;

public class MultiplyStrings {
    public static String multiplyStrings(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int num1Length = num1.length();
        int num2Length = num2.length();

        int[] multResult = new int[num1Length + num2Length];

        for (int i = num1Length - 1; i >= 0; i--) {
            for (int j = num2Length - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int sum = mul + multResult[pos2];

                multResult[pos1] += sum / 10;
                multResult[pos2] = sum % 10;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (var number : multResult) {
            if (!(builder.length() == 0 && number == 0)) {
                builder.append(number);
            }
        }

        return builder.toString();
    }
}
