package StackQuestions;

import java.util.Stack;

public class NextGreaterElement {
    public static int[] greater(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int n = array.length;
        int[] array1 = new int[n];
        for (int i = n - 1; i >= 0; i--) { // Corrected loop condition
            if (stack.isEmpty()){
                array1[i]=-1;
                stack.push(array[i]);
            }
            else {
                while (!stack.isEmpty() && array[i] >= stack.peek()){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    array1[i]=-1;
                }
                else {
                    array1[i]=stack.peek();
                }
                stack.push(array[i]);
            }
        }
        return array1;
    }

    public static void main(String[] args) {
        int[]c={1,2,3,4};
        int b[] = {1, 5, 3, 2, 1, 6, 3, 4};
        int a[] = greater(b);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
