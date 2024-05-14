package StackQuestions;

import java.util.Stack;

/**
 * Class containing a method to calculate the span of stock prices for all n days.
 */
public class StockSpanProblem {

    /**
     * Calculates the span of stock prices for all n days.
     *
     * @param price An array containing the prices of the stock for n days.
     * @param The number of days.
     * @return An array containing the span of stock prices for each day.
     */
    public static int[] calculateSpan(int price[]) {
        // Length of the price array
        int length = price.length;
        // Stack to store indices of days with prices less than or equal to the current day
        Stack<Integer> stack = new Stack<>();
        // Array to store the resultant spans
        int[] resultant = new int[length];

        // Push index 0 to stack as the first element
        stack.push(0);
        // Span of the first day is always 1
        resultant[0] = 1;

        // Iterate through the remaining days
        for (int i = 1; i < length; i++) {
            // Pop indices from stack while stack is not empty and price of current day is greater than price of top of stack
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            // Calculate span for the current day
            // If stack is empty, the current day's price is greater than all previous days, so span is current index + 1
            // Otherwise, span is the difference between current index and index of the previous day with price greater than current day
            resultant[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            // Push current index to stack
            stack.push(i);
        }

        // Return the resultant array containing spans
        return resultant;
    }

    public static void main(String[] args) {
        System.out.println("link of the problem solved : https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1");
        // Example usage
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        // Print the spans
        System.out.print("Span of stock prices for each day: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
