package com.github.happut.learndemospringboot.leecode.problem3;

import java.util.Stack;

public class Problem3 {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= '0' && curr <= '9') {
                if(i!=0&&s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9'){
                    numStack.push(numStack.pop()*10+Integer.valueOf("" + curr));
                }else {
                    numStack.push(Integer.valueOf("" + curr));
                }
            } else if (curr == '+' || curr == '-' || curr == '*' || curr == '/') {
                if (operatorStack.empty()) {
                    operatorStack.push(curr);
                } else {
                    if ((operatorStack.peek() == '+' || operatorStack.peek() == '-') && (curr == '*' || curr == '/')) {
                        operatorStack.push(curr);
                    } else {
                        while (!operatorStack.empty()) {
                            int num2 = numStack.pop();
                            int num1 = numStack.pop();
                            char oper = operatorStack.pop();

                            int result = 0;

                            switch (oper) {
                                case '+':
                                    result = num1 + num2;
                                    break;
                                case '-':
                                    result = num1 - num2;
                                    break;
                                case '*':
                                    result = num1 * num2;
                                    break;
                                case '/':
                                    result = num1 / num2;
                                    break;
                            }
                            numStack.push(result);


                            if (operatorStack.empty()||(operatorStack.peek() == '+' || operatorStack.peek() == '-') && (curr == '*' || curr == '/')){
                                break;
                            }
                        }
                        operatorStack.push(curr);
                    }
                }
            }
        }
        while (!operatorStack.empty()) {


            int num2 = numStack.pop();
            int num1 = numStack.pop();
            char oper = operatorStack.pop();

            int result = 0;

            switch (oper) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            numStack.push(result);
        }
        System.out.println(numStack.pop());

    }
}
