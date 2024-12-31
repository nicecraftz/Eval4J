package it.alessandrocalista.math.operation.impl;

import it.alessandrocalista.math.operation.Operands;
import it.alessandrocalista.math.operation.Operation;

public class PowerOperation implements Operation {

    @Override
    public int order() {
        return 1;
    }

    @Override
    public char symbol() {
        return '^';
    }

    @Override
    public double result(Operands operands) {
        return Math.pow(operands.a(), operands.b());
    }
}
