// 설탕배달
// dp
package BAEKJOON.y22.m3.w2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 10000);
        for (int i = 0; i < N + 1; i++) {
            if (i == 3 || i == 5) dp[i] = 1;
            if (i > 5) dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
//            System.out.println(i + " " + dp[i]);
        }
        System.out.println(dp[N] >= 10000 ? -1 : dp[N]);
    }
}
