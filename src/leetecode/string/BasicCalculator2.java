package leetecode.string;

import java.util.Stack;

public class BasicCalculator2 {

    public static void main(String ...args){
        BasicCalculator2 bc2 = new BasicCalculator2();
        System.out.println(bc2.calculate2("2+3/2"));
        System.out.println(bc2.calculate2("2+3*2/2"));
        System.out.println(bc2.calculate2("1-1+1"));
        System.out.println(bc2.calculate2("0-2147483647"));
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
    }
    public int calculate(String s) {

        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        boolean performOp = false;
        int i=0;
        while (i<s.length()){
            char ch = s.charAt(i);
            if(ch == ' '){
                i++;
                continue;
            }
            if(ch == '+' || ch == '-') {
                operatorStack.push(ch);
                i++;
            }
            else if(ch == '*' || ch == '/') {
                operatorStack.push(ch);
                performOp = true;
                i++;
            }else{
                int n = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    n = n*10+s.charAt(i)-'0';
                    i++;
                }
                if(performOp){
                    int n1 = operandStack.pop();
                    char ch1 = operatorStack.pop();
                    if(ch1 == '/')
                        operandStack.push(n1/n);
                    else if(ch1 == '*')
                        operandStack.push(n1*n);
                    performOp = false;
                }else {
                    operandStack.push(n);
                }
            }

        }

        while (!operatorStack.isEmpty()) {
            int n1 = operandStack.pop();
            int n2 = operandStack.pop();
            char ch = operatorStack.pop();
            if(ch == '+')
                operandStack.push(n1+n2);
            else if(ch == '-')
                operandStack.push(n1-n2);
            else if(ch == '/')
                operandStack.push(n1/n2);
            else if(ch == '*')
                operandStack.push(n1*n2);
        }
        return operandStack.isEmpty() ? 0 : operandStack.pop();
    }

    //improved
    public int calculate2(String s){

        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i)) || i==s.length()-1){
                if(sign == '+')
                    stack.push(num);
                if(sign == '-')
                    stack.push(-num);
                if(sign == '*')
                    stack.push(stack.pop()*num);
                if(sign == '/')
                    stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for(int i : stack)
            res+=res+i;
        return res;
    }
}
