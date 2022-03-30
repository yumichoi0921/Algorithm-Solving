// 1, 2, 3 더하기
package BAEKJOON.y22.m3.w5;

import java.util.Scanner;

public class Main_9095 {
    static int T, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            n = sc.nextInt();
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 3;
            for (int i = 4; i < n + 1; i++) {
                dp[i] = dp[i - 3] + 3 + dp[i - 2] + 1 + dp[i - 1] + 1;
            }
        }

    }
}

