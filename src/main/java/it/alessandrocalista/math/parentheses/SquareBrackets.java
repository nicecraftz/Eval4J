package it.alessandrocalista.math.parentheses;

public class SquareBrackets implements Parentheses {
    @Override
    public int order() {
        return 2;
    }

    @Override
    public String pattern() {
        return "\\[([^\\[\\]]*)\\]";
    }
}
