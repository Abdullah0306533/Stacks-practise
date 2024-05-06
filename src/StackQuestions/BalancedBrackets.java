package StackQuestions;

import java.util.*;

public class BalancedBrackets {
    // Using Stack to keep track of open brackets
    public static Stack<Character> stack = new Stack<>();

    // Method to check if the brackets are balanced
    public static boolean isBalance(String data) {
        int size = data.length();
        for (int i = 0; i < size; i++) {
            char current = data.charAt(i);
            if (current == '(') {
                stack.push(current); // Push to stack if it's an open bracket
            } else if (stack.isEmpty() && current == ')') {
                return false; // If encountering a closing bracket when stack is empty, it's unbalanced
            } else if (current == ')') {
                stack.pop(); // Pop from stack if it's a closing bracket and matches with the top of the stack
            }
        }
        if (stack.isEmpty()) {
            return true; // If stack is empty after processing, brackets are balanced
        } else {
            System.out.println(stack.size() + " :minimum brackets to remove to balance");
            return false; // If stack is not empty, there are unpaired open brackets
        }
    }

    public static void main(String[] args) {
        System.out.println(isBalance("(())((")); // Test the method with unbalanced brackets
    }
}
