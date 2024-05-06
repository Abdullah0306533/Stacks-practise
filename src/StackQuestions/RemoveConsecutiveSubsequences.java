package StackQuestions;

import java.util.Stack;

/**
 * A class to remove consecutive subsequences from an integer array using a stack.
 */
public class RemoveConsecutiveSubsequences {

    /**
     * Removes consecutive subsequences from the input array.
     *
     * @param array The input array from which consecutive subsequences are to be removed.
     * @return An array with consecutive subsequences removed.
     */
    public static int[] remove(int[] array) {
        Stack<Integer> stack = new Stack<>(); // Create a stack to store elements
        for (int i = 0; i < array.length; i++) {
            // If the stack is empty or the current element is different from the top of the stack, push it
            if (stack.isEmpty() || stack.peek() != array[i]) {
                stack.push(array[i]);
            } else if (stack.peek() == array[i]) { // If the current element is same as the top of the stack
                // If it's the last element or the next element is different, pop the top element
                if (i == array.length - 1 || array[i] != array[i + 1]) {
                    stack.pop();
                }
            }
        }
        System.out.println(stack); // Print the elements remaining in the stack
        return array; // Return the original array (no modification)
    }

    /**
     * Main method to test the remove function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] a = {3, 3, 4, 4, 5, 9, 9, 9, 8};
        int[] x = remove(a); // Call the remove function
//        for (int i : x){
//            System.out.print(i+" ");
//        }
    }
}

