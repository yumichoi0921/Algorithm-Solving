package SWEA.m8.week3;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder formula = new StringBuilder();
            Stack<Character> operator = new Stack<>();
            Stack<Integer> operand = new Stack<>();

            int N = sc.nextInt();
            String str = sc.next();
            for (int i = 0; i < N; i++) {
                if (str.charAt(i) == '+') {
                    if (operator.isEmpty()) operator.push(str.charAt(i));
                    else {
                        while (!operator.isEmpty()) {
                            formula.append(operator.pop());
                        }
                        operator.push(str.charAt(i));
                    }
                } else if (str.charAt(i) == '*') {
                    if (operator.isEmpty()) operator.push(str.charAt(i));
                    else {
                        if (operator.peek() == '+') operator.push(str.charAt(i));
                        else {
                            while (!operator.isEmpty() && operator.peek() != '+') {
                                formula.append(operator.pop());
                            }
                            operator.push(str.charAt(i));
                        }
                    }
                } else {
                    formula.append(str.charAt(i)-'0');
                }
            }
            while (!operator.isEmpty()) formula.append(operator.pop());
            // 후위계산식 계산
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '+') {
                    operand.push(operand.pop() + operand.pop());
                } else if (formula.charAt(i) == '*'){
                    operand.push(operand.pop() * operand.pop());
                } else {
                    operand.push(formula.charAt(i)-'0');
                }
            }
            int value = operand.peek();
            System.out.printf("#%d %d\n", tc, value);
        }
    }
}
