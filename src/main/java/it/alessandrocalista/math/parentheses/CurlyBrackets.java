package it.alessandrocalista.math.parentheses;

public class CurlyBrackets implements Parentheses {
    @Override
    public int order() {
        return 3;
    }

    @Override
    public String pattern() {
        return "\\{([^{}]*)\\}";
    }
}
