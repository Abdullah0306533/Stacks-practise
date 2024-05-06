package Practise;

import java.util.Stack;

public class NextGreaterElementPractise {
    public static int[] greater(int[] array){
        int n=array.length;
        Stack<Integer> stack=new Stack<>();
        int[] resultant=new int[n];
        for (int i=n-1;i>=0;i--){
            if (stack.isEmpty()){
                stack.push(array[i]);
                resultant[i]=-1;
            }
            else{
                while (!stack.isEmpty() && array[i]>=stack.peek()){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    resultant[i]=-1;
                }
                else {
                    resultant[i]=stack.peek();
                }
                stack.push(array[i]);

            }
        }
        return resultant;
    }

    public static void main(String[] args) {
        int b[] = {1, 5, 3, 2, 1, 6, 3, 4};
        //int b[]={1,2,3,4};
        int[] a=greater(b);
        for (int i:a){
            System.out.println(i);
        }
    }
}
