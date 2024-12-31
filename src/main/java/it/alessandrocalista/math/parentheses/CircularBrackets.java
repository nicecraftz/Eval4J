package it.alessandrocalista.math.parentheses;

public class CircularBrackets implements Parentheses{
    @Override
    public int order() {
        return 1;
    }

    @Override
    public String pattern() {
        return "\\(([^()]*)\\)";
    }
}
