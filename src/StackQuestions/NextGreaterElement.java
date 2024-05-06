package stackquestions;

import java.util.Stack;

public class NextGreaterElement {

    /**
     * Finds the next greater element for each element in the input array.
     * If there is no greater element, assigns -1.
     *
     * @param array The input array
     * @return An array containing the next greater element for each element in the input array
     */
    public static int[] findNextGreaterElements(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int n = array.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.push(array[i]);
            } else {
                while (!stack.isEmpty() && array[i] >= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
                stack.push(array[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 5, 3, 2, 1, 6, 3, 4};
        int[] nextGreaterElements = findNextGreaterElements(inputArray);

        // Print the result
        for (int element : nextGreaterElements) {
            System.out.print(element + " ");
        }
    }
}
