package Stacks;


    public class StacksImplimentationWithArrays {
        private int[] stackArray;
        private int top; // Index of the top element

        // Constructor to initialize the stack
        public StacksImplimentationWithArrays(int capacity) {
            stackArray = new int[capacity];
            top = -1; // Stack is initially empty
        }

        // Method to push an element onto the stack
        public void push(int element) {
            // Check if the stack is full
            if (isFull()) {
                throw new IllegalStateException("Stack overflow");
            }
            top++;
            stackArray[top] = element;
        }

        // Method to pop an element from the stack
        public int pop() {
            // Check if the stack is empty
            if (isEmpty()) {
                throw new IllegalStateException("Stack underflow");
            }
            int poppedElement = stackArray[top];
            top--;
            return poppedElement;
        }

        // Method to peek the top element of the stack without removing it
        public int peek() {
            // Check if the stack is empty
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stackArray[top];
        }

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return top == -1;
        }

        // Method to check if the stack is full
        public boolean isFull() {
            return top == stackArray.length - 1;
        }

        // Method to get the size of the stack
        public int size() {
            return top + 1;
        }

        // Method to print the elements of the stack
        public void printStack() {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            StacksImplimentationWithArrays stack = new  StacksImplimentationWithArrays(5);

            stack.push(1);
            stack.push(2);
            stack.push(3);

            stack.printStack(); // Output: Stack: 1 2 3

            System.out.println("Peek: " + stack.peek()); // Output: Peek: 3

            stack.pop();
            stack.printStack(); // Output: Stack: 1 2

            System.out.println("Stack size: " + stack.size()); // Output: Stack size: 2
        }
    }


