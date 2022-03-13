package SWEA.m8.week1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            HashMap<Character, Character> brace = new HashMap<>();
            brace.put(')', '(');
            brace.put(']', '[');
            brace.put('}', '{');
            brace.put('>', '<');
            int res = 1;
            Stack<Character> openBrace = new Stack<>();

            int N = sc.nextInt();
            String S = sc.next();
            for (int i = 0; i < N; i++) {
                if (brace.containsValue(S.charAt(i))) {
                    openBrace.push(S.charAt(i));
                } else {
                    if (openBrace.pop() == brace.get(S.charAt(i))) {
                        continue;
                    } else {
                        res = 0;
                        break;
                    }
                }
            }
            if (!openBrace.isEmpty()) res = 0;
            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
