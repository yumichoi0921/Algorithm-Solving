package SWEA.m8.week1;

import java.util.Scanner;
import java.util.Stack;

public class __Solution_5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int res = 0;
            String S = sc.next();
            S = S.replace("()", "$");
            System.out.println(S);
            char[] crr = S.toCharArray();

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < crr.length; i++) {
                switch (crr[i]) {
                    case '(' :  // 쇠막대기 시작
                        stack.push('(');
                        break;
                    case '$' :
                        res += stack.size();
                        break;
                    case ')' :  // 쇠막대기 끝
                        res++;
                        stack.pop();
                        break;

                }
            }
            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
