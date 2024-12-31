package it.alessandrocalista.math.operation;

import it.alessandrocalista.math.extractor.OperandsExtractor;
import it.alessandrocalista.math.operation.impl.*;
import it.alessandrocalista.math.parentheses.Parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final Map<Character, Operation> operations = new HashMap<>();
    private final ArrayList<Parentheses> parentheses = new ArrayList<>();

    public Calculator() {
        register(new AdditionOperation());
        register(new DivisionOperation());
        register(new ModuloOperation());
        register(new MoltiplicationOperation());
        register(new PowerOperation());
        register(new SubtractionOperation());
    }

    private void register(Operation operation) {
        operations.put(operation.symbol(), operation);
    }

    public boolean isRegisteredOperation(char c) {
        return operations.containsKey(c);
    }

    public Operation getOperationByPriority(String expression) {
        Operation highestOperation = null;
        for (char c : expression.toCharArray()) {
            if (!isRegisteredOperation(c)) {
                continue;
            }
            Operation operation = operations.get(c);
            if (highestOperation == null || highestOperation.order() > operation.order()) {
                highestOperation = operation;
            }
        }
        return highestOperation;
    }

    public boolean containsParentheses(String expression) {
        for (Parentheses p : parentheses) {
            Pattern pattern = Pattern.compile(p.pattern());
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public int getOperationCount(String expression) {
        int count = 0;
        for (char c : expression.toCharArray()) {
            if (!isRegisteredOperation(c)) {
                continue;
            }
            count++;
        }
        return count;
    }

    public int operate(String expression) {
        Operation operation;
        int maxOperations = getOperationCount(expression);
        int operationCount = 0;

        do {
            operation = getOperationByPriority(expression);
            if (operation == null) {
                return Integer.parseInt(expression);
            }

            Operands operands = OperandsExtractor.extractOperands(expression, operation.symbol());
            int result = (int) operation.result(operands);
            String replacement = String.valueOf(operands.a()) + operation.symbol() + operands.b();

            int indexOf = expression.indexOf(replacement);
            int end = indexOf + replacement.length();
            expression = expression.substring(0, indexOf) + result + expression.substring(end);

            operationCount++;
        } while (operationCount < maxOperations);

        return Integer.parseInt(expression);
    }

    public int calculate(String rawExpression) {
        // end coding the parentheses logic.
        return 0;
    }

}
