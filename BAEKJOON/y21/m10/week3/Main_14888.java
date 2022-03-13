package BAEKJOON.y21.m10.week3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// 연산자 끼워넣기
// 순열
public class Main_14888 {
    static int N, min, max;
    static ArrayList<String> num;
    static ArrayList<String> opertators;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new ArrayList<>();
        opertators = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            num.add(sc.next());
        }

        for (int i = 0; i < 4; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                if (i == 0) opertators.add("+");
                else if (i == 1) opertators.add("-");
                else if (i == 2) opertators.add("*");
                else if (i == 3) opertators.add("/");
            }
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        permu(new boolean[opertators.size()], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void permu(boolean[] v, int idx) {
        if (idx == num.size()) {
            cal(num);
            return;
        }

        for (int i = 0; i < opertators.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                num.add(idx, opertators.get(i));
                permu(v, idx + 2);
                num.remove(idx);
                v[i] = false;
            }
        }
    }

    private static void cal(ArrayList<String> num) {
        Stack<Integer> operand = new Stack<>();
        Stack<String> operator = new Stack<>();

        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).equals("+")) {
                operator.push(num.get(i));
            } else if (num.get(i).equals("-")) {
                operator.push(num.get(i));
            } else if (num.get(i).equals("*")) {
                operator.push(num.get(i));
            } else if (num.get(i).equals("/")) {
                operator.push(num.get(i));
            } else {
                operand.push(Integer.parseInt(num.get(i)));
            }

            if (operand.size() == 2) {
                int n2 = operand.pop();
                int n1 = operand.pop();
                String op = operator.pop();

                if (op.equals("+")) {
                    operand.push(n1 + n2);
                } else if (op.equals("-")) {
                    operand.push(n1 - n2);
                } else if (op.equals("*")) {
                    operand.push(n1 * n2);
                } else if (op.equals("/")) {
                    if (n1 < 0) {
                        n1 = -n1;
                        operand.push(-(n1 / n2));
                    } else {
                        operand.push(n1 / n2);
                    }
                }
            }
        }

        max = Math.max(max, operand.peek());
        min = Math.min(min, operand.peek());
    }
}
