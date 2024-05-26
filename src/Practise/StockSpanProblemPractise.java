package Practise;

import java.util.Stack;

public class StockSpanProblemPractise {

    public static int[] calculateSpan(int[] array){
        int n=array.length;
        Stack<Integer> stack=new Stack<>();
        int[] resultant=new int[n];
        resultant[0]=1;
        stack.push(0);
        for (int i=1;i<n;i++){
            while (!stack.isEmpty() && array[stack.peek()]<array[i]){
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
