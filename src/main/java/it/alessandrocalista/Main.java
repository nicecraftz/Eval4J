package it.alessandrocalista;

import it.alessandrocalista.math.operation.Calculator;

// Per questo progetto non posso usare chatgpt
public class Main {
    public static void main(String[] args) {
        String expression = "4%5";
        Calculator calculator = new Calculator();
        calculator.operate(expression);
    }
}