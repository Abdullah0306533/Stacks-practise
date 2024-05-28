package StackQuestions;

import java.util.Stack;

public class InfixToPrefix {

    // Function to check if character is an operator
    static boolean isOperator(char c) {
        return (!Character.isLetterOrDigit(c));
    }

    // Function to check the precedence of operators
    static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to reverse the characters in a string
    static String reverse(String expression) {
        char[] chars = expression.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            // Swap the characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // Function to replace parentheses in a string
    static String replaceParentheses(String expression) {
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }
        return new String(chars);
    }

    // Function to convert infix to postfix
    static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operand, add it to the result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and output from the stack until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            // If an operator is found
            else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Function to convert infix to prefix
    static String infixToPrefix(String expression) {
        // Step 1: Reverse the infix expression
        String reversedExpression = reverse(expression);

        // Step 2: Replace '(' with ')' and vice versa
        reversedExpression = replaceParentheses(reversedExpression);

        // Step 3: Get the postfix expression
        String postfixExpression = infixToPostfix(reversedExpression);

        // Step 4: Reverse the postfix expression to get the prefix expression
        return reverse(postfixExpression);
    }

    public static void main(String[] args) {
        String infix = "a+b*c";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Prefix Expression: " + infixToPrefix(infix));
    }
}
