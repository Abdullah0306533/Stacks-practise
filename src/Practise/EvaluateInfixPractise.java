package Practise;

import java.util.Stack;

public class EvaluateInfixPractise extends Thread{
    public static int precedence(char operator){
        switch (operator){
            case '+':
            case '-':
                return 1;
            case '/':
            case'*':
                return 2;
            default:return 0;
        }
    }
    public static int operations(char operator,int v1,int v2){
        switch (operator){
            case '+':
                return (v1 + v2);
            case '-':
                return (v1 - v2);
            case '/':
                if (v2 == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return v1 / v2;
            case'*':
                return (v1 * v2);

            default:return 0;
        }
    }
    public static int evaluate(String eq){
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();

        for (int i = 0; i <eq.length() ; i++) {
            char curr=eq.charAt(i);
            if (Character.isDigit(curr))operand.push(curr-'0');
            else if (curr=='+' || curr=='-' || curr=='*' || curr=='/' ) {
                while (!operator.isEmpty() && precedence(curr)<=precedence(operator.peek())){
                    int v2=operand.pop();
                    int v1=operand.pop();
                    operand.push(operations(operator.pop(),v1,v2));
                }
                operator.push(curr);
            }
        }
        while (!operator.isEmpty()) {
            int v2 = operand.pop();
            int v1 = operand.pop();
            operand.push(operations(operator.pop(), v1, v2));
        }
        return operand.pop();
    }

    public static void main(String[] args) {
        String equation = "9-5+*4/6";
        System.out.println("Result: " + evaluate(equation));
    }
}
