// 2 x n 타일링
// 점화식
package BAEKJOON.y22.m3.w5;

import java.util.Scanner;

public class __Main_11726 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n < 3) {
            System.out.println(n % 10007);
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
            System.out.println(dp[n]);
        }
    }
}
