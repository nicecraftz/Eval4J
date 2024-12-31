package it.alessandrocalista.math.extractor;

import it.alessandrocalista.math.parentheses.Parentheses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParenthesesExtractor {
    private ParenthesesExtractor() {
    }

    public static String extractInnerExpression(String expression, Parentheses parentheses) {
        Pattern pattern = Pattern.compile(parentheses.pattern());
        Matcher matcher = pattern.matcher(expression);
        if (!matcher.find()) {
            return expression;
        }
        return matcher.group();
    }
}
