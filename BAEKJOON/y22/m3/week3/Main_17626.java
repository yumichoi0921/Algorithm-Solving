package BAEKJOON.y22.m3.week3;

import java.util.Scanner;

public class Main_17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            if (dp[i] == 0) {
                long idx = i;
                while (idx < N + 1) {
                    dp[(int) idx] = idx == i ? 0 : 1;
                    idx = idx * idx;

                }
            }
        }
        System.out.println(dp[11025]);
        int answer = 0;
        while (N > 0) {
            for (int i = N; i > 0; i--) {
                if (dp[i] != 0 && N - i >= 0) {
                    answer += dp[i];
                    N = N - i;
                    System.out.println(i + " " + N);
                }
            }

        }
        System.out.println(answer);

    }
}
