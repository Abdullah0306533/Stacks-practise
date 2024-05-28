package StackQuestions;

import java.util.Stack;

public class EvaluateInfix {

    // Function to apply an operator 'op' on operands 'a' and 'b'
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    // Function to evaluate the precedence of operators
    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static int evaluate(String eq) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < eq.length(); i++) {
            char curr = eq.charAt(i);

            // If the current character is a digit, push it to the operand stack
            if (Character.isDigit(curr)) {
                operand.push(curr - '0');
            }
            // If the current character is an operator
            else if (curr == '+' || curr == '-' || curr == '*' || curr == '/') {
                // While the precedence of the current operator is less than or equal
                // to the precedence of the operator on the stack top, apply the operator
                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(curr)) {
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    operand.push(applyOp(operator.pop(), v2, v1));
                }
                operator.push(curr);
            }
        }

        // Apply remaining operators to the remaining operands
        while (!operator.isEmpty()) {
            int v2 = operand.pop();
            int v1 = operand.pop();
            operand.push(applyOp(operator.pop(), v2, v1));
        }

        // The final result is the remaining value on the operand stack
        return operand.pop();
    }

    public static void main(String[] args) {
        String equation = "9+2/8-5*4";
        System.out.println("Result: " + evaluate(equation));

    }
}
