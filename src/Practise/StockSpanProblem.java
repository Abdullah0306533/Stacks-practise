package Practise;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpan(int[] arr){
        Stack<Integer> stack=new Stack<>();
        int n= arr.length;
        int[] resultant=new int[n];
        //first iteration
        resultant[0]=1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
           resultant[i]=(stack.isEmpty()) ? (i+1):(i-stack.peek());
            stack.push(i);
        }
        return resultant;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85,1000};
        int[] spans = calculateSpan(prices);
        // Print the spans
        System.out.print("Span of stock prices for each day: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
