package it.alessandrocalista.math.operation.impl;

import it.alessandrocalista.math.operation.Operands;
import it.alessandrocalista.math.operation.Operation;

public class AdditionOperation implements Operation {
    @Override
    public int order() {
        return 4;
    }

    @Override
    public char symbol() {
        return '+';
    }

    @Override
    public double result(Operands operands) {
        return operands.a() + operands.b();
    }
}
