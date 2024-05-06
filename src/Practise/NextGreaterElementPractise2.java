package Practise;

import java.util.SplittableRandom;
import java.util.Stack;

public class NextGreaterElementPractise2 {


    public static int[] greater(int[] array){
        Stack<Integer> stack=new Stack<>();
        int n=array.length;
        int[] greater=new int[n];
        for (int i=n-1;i>=0;i--) {
            if (stack.isEmpty()){
                greater[i]=-1;
                stack.push(array[i]);
            }
            else {
                while (!stack.isEmpty() && array[i]>=stack.peek()){
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    greater[i]=-1;
                }
                else {
                    greater[i]=stack.peek();
                }
                stack.push(array[i]);

            }
        }
        return greater;
    }

    public static void main(String[] args) {
        int b[] = {1, 5, 3, 2, 1, 6, 3, 4};
        int a[] = greater(b);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
