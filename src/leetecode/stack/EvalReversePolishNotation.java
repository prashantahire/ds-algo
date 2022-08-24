package leetecode.stack;

import java.util.Stack;

public class EvalReversePolishNotation {

    public static void main(String ...args){
        String s[]={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalReversePolishNotation().evalRPN(s));
    }
    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int len = tokens.length;
        while (i < len){
            if(tokens[i].equals("+") || tokens[i].equals("-")
                    ||tokens[i].equals("*") || tokens[i].equals("/")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (tokens[i]) {
                    case "+": stack.push((n2+n1)); break;
                    case "-": stack.push(n2-n1); break;
                    case "*": stack.push(n2*n1); break;
                    case "/": stack.push(n2/n1); break;
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.pop();
    }
}
