package StackQuestions;

import java.util.Stack;

/**
 * A class to remove all consecutive subsequences from an integer array using a stack.
 */
public class RemoveAllConsecutiveSubsequences {

    /**
     * Removes all consecutive subsequences from the input array.
     *
     * @param array The input array from which consecutive subsequences are to be removed.
     * @return An array with all consecutive subsequences removed.
     */
    public static int[] remove(int[] array) {
        Stack<Integer> stack = new Stack<>(); // Create a stack to store elements
        for (int i = 0; i < array.length; i++) {
            // If the stack is empty or the current element is different from the top of the stack, push it
            if (stack.isEmpty() || stack.peek() != array[i]) {
                stack.push(array[i]);
            } else { // If the current element is same as the top of the stack
                // Keep removing elements from stack as long as they are consecutive to the current element
                while (i < array.length && stack.peek() == array[i]) {
                    i++;
                }
                // Decrement i to process the current element again
                i--;
                stack.pop(); // Remove the last element from the stack as it's part of a consecutive subsequence
            }
        }

        // Convert the stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result; // Return the array with all consecutive subsequences removed
    }

    /**
     * Main method to test the remove function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] a = {3, 3, 4, 4, 5, 9, 9, 9, 8};
        int[] x = remove(a); // Call the remove function
        System.out.print("Array with consecutive subsequences removed: ");
        for (int i : x) {
            System.out.print(i + " ");
        }
    }
}
