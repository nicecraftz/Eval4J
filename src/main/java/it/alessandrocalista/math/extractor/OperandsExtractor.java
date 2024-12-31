package it.alessandrocalista.math.extractor;

import it.alessandrocalista.math.operation.Operands;

public class OperandsExtractor {
    private OperandsExtractor() {
    }

    public static Operands extractOperands(String expression, char symbol) {
        return new Operands(extractBefore(expression, symbol), extractAfter(expression, symbol));
    }

    private static Integer extractBefore(String expression, char symbol) {
        String beforeSubstring = expression.substring(0, expression.indexOf(symbol));
        char[] chars = beforeSubstring.toCharArray();
        StringBuilder computedNumber = new StringBuilder();
        for (int length = chars.length - 1; length >= 0; length--) {
            char c = chars[length];
            if (Character.isDigit(c)) {
                computedNumber.insert(0, c + "");
            } else {
                break;
            }
        }

        return Integer.parseInt(computedNumber.toString());
    }

    private static Integer extractAfter(String expression, char symbol) {
        String afterSubstring = expression.substring(expression.indexOf(symbol) + 1);
        String computedNumber = "";

        for (char c : afterSubstring.toCharArray()) {
            if (Character.isDigit(c)) {
                computedNumber += c;
            } else {
                break;
            }
        }
        return Integer.parseInt(computedNumber);

    }
}
