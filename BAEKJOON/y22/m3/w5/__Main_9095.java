// 1, 2, 3 더하기
// 시뮬레이션
// 점화식찾기
package BAEKJOON.y22.m3.w5;

import java.util.Scanner;

public class __Main_9095 {
    static int T, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            n = sc.nextInt();
            if (n == 1) System.out.println(1);
            else if (n == 2) System.out.println(2);
            else if (n == 3) System.out.println(4);
            else {
                int[] dp = new int[n + 1];
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for (int i = 4; i < n + 1; i++) {
                    dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
                }
                System.out.println(dp[n]);
            }
        }
    }
}

