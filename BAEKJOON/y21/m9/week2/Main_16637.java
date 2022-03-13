package BAEKJOON.y21.m9.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main_16637 {
    static int val;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Character> formula = new ArrayList<>();
        String str = sc.next();
        for (int i = 0; i < N; i++) {
            formula.add(str.charAt(i));
        }

        val = Integer.MIN_VALUE;
        subset(formula, new boolean[N / 2], 0);
        System.out.println(val);

    }

    private static void subset(List formula, boolean[] isSelected, int idx) {
        if (idx >= isSelected.length) {
            List<Character> res = new ArrayList<>();
            for (int i = 0; i < formula.size(); i++) {
                res.add((Character) formula.get(i));
            }
            int s = -1;
            for (int i = 0; i < res.size(); i++) {
                if ("+-*".contains(res.get(i).toString())) {
                    s++;
                    if (isSelected[s]) {
                        res.add(i + 2, ')');
                        res.add(i - 1, '(');
                        i += 2;
                    }
                }
            }
            val = Math.max(val, calculate(res));
            return;
        }

        isSelected[idx] = true;
        subset(formula, isSelected, idx + 2);
        isSelected[idx] = false;
        subset(formula, isSelected, idx + 1);
    }

    private static int calculate(List tmp) {
        Stack<Integer> operand = new Stack<>();
        Stack<String> operator = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < tmp.size(); i++) {
            if ((Character) tmp.get(i) == '(') {
                flag = true;
            } else if ((Character) tmp.get(i) == ')') {
                int b = operand.pop();
                int a = operand.pop();
                String op = operator.pop();
                if (op.equals("+")) {
                    operand.push(a + b);
                } else if (op.equals("-")) {
                    operand.push(a - b);
                } else if (op.equals("*")) {
                    operand.push(a * b);
                }
                flag = false;
            } else if ("+-*".contains(tmp.get(i).toString())) {
                operator.push(tmp.get(i).toString());
            } else {
                operand.push(Integer.parseInt(tmp.get(i).toString()));
            }
            if (!flag) {
                if (operand.size() == 2) {
                    int b = operand.pop();
                    int a = operand.pop();
                    String op = operator.pop();
                    if (op.equals("+")) {
                        operand.push(a + b);
                    } else if (op.equals("-")) {
                        operand.push(a - b);
                    } else if (op.equals("*")) {
                        operand.push(a * b);
                    }
                }
            }
        }
        return operand.pop();
    }
}
