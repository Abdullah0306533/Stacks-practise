package StackQuestions;

import java.util.Stack;

public class RemoveConsecutiveSubsequences {
    public static int[] remove(int[] array){
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<array.length;i++) {
            if(stack.size()==0 || stack.peek()!=array[i]){
                stack.push(array[i]);
            }

                else if (stack.peek()==array[i]) {
                    if (i==array.length-1  || array[i] != array[i + 1])
                        stack.pop();
                }
        }
        System.out.println(stack);

        return array;
    }

    public static void main(String[] args) {
        int[] a={3,3,4,4,5,9,9,9,8};
        int[] x=remove(a);
//        for (int i:x){
//            System.out.print(i+" ");
//        }
    }
}
