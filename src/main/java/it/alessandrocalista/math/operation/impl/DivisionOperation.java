package it.alessandrocalista.math.operation.impl;

import it.alessandrocalista.math.operation.Operands;
import it.alessandrocalista.math.operation.Operation;

public class DivisionOperation implements Operation {
    @Override
    public int order() {
        return 3;
    }

    @Override
    public char symbol() {
        return '/';
    }

    @Override
    public double result(Operands operands) {
        return (double) operands.a() / operands.b();
    }
}
