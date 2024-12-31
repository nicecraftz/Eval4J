package it.alessandrocalista.math.operation.impl;

import it.alessandrocalista.math.operation.Operands;
import it.alessandrocalista.math.operation.Operation;

public class MoltiplicationOperation implements Operation {
    @Override
    public int order() {
        return 2;
    }

    @Override
    public char symbol() {
        return '*';
    }

    @Override
    public double result(Operands operands) {
        return operands.a() * operands.b();
    }
}
