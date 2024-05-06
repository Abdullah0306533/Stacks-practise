package Practise;

import java.util.Stack;

public class BalancedBracketsPractise {

    public static boolean check(String st){
        Stack<Character> stack=new Stack<>();
        int n=st.length();
        for (int i=0;i<n;i++) {
            char curr = st.charAt(i);
            if (curr=='('){
                stack.push(curr);
            }
            else {
                if(stack.isEmpty() && curr==')'){
                    return false;
                }
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(check("(((())))()"));
    }

}
