package BAEKJOON.y21.m8.week3;

import java.util.Scanner;

public class _N__Main_1074 {
    static boolean find = false;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = (int) Math.pow(2, sc.nextInt());
        int R = sc.nextInt();
        int C = sc.nextInt();
        cnt = 0;
        recursive(R, C, 0, 0, N);
        System.out.println(cnt);
    }

    private static void recursive(int R, int C, int r, int c, int n) {
        if (n == 2) {
            isFind(R, C, r, c, n);
            return;
        }
        int max = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (find) return;
                recursive(R, C, r + max * i, c + max * j, max);
            }
        }
    }

    private static void isFind(int R, int C, int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (i == R && j == C) {
                    find = true;
                    return;
                }
                cnt++;
            }
        }
    }
}
