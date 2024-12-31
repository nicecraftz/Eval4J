package it.alessandrocalista.math.operation;

public interface Operation {
    int order();

    char symbol();

    double result(Operands operands);
}
