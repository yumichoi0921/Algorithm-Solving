// 1로 만들기
// dp
package BAEKJOON.y22.m3.w4;

import java.util.Scanner;

public class Main_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 1;  // 우선 이전 최소값에 +1
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 이전 최소값에 +1과 3으로 나눴을 때 최솟값 +1 비교
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 이전 최소값 +1과 2로 나눴을 때 최솟값 값 +1 비교
            // 2로도 3으로도 나눠진다면 이전 최소값에 +1, 3으로 나눴을 때 최솟값 +1, 2로 나눴을 때 최솟값 값 +1 비교
        }
        System.out.println(dp[N]);
    }
}
