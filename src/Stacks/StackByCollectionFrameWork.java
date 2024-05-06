package Stacks;
import java.util.*;
public class StackByCollectionFrameWork {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Printing the stack size
        System.out.println("Stack size: " + stack.size());

        // Peeking the top element of the stack
        System.out.println("Top element: " + stack.peek());

        // Popping elements from the stack
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }
}


