package Practise;

import java.util.Stack;

public class RemoveConsecutiveSubsequencesPractise {
    public static int[] remove(int[] array){
        int n=array.length;
        Stack<Integer> stack=new Stack<>();
        int[] resultant;
        for (int i=0;i<n;i++){
            if (stack.isEmpty() ||stack.peek()!=array[i]){
                stack.push(array[i]);
            }
            else {
                while (i<n && array[i]==stack.peek()){
                    i++;
                }
                i--;
                stack.pop();
            }
        }
        resultant=new int[stack.size()];
        for (int i=resultant.length-1;i>=0;i--){
          resultant [i]= stack.pop();
        }
        return resultant;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 4, 4, 5, 9, 9, 9, 8,10,11,12,13};
        int[] x = remove(a); // Call the remove function
        System.out.print("Array with consecutive subsequences removed: ");
        for (int i : x) {
            System.out.print(i + " ");
        }
    }


}
