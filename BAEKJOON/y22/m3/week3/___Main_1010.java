// 다리놓기
// nCn = nC0 = 1
// nCr = n-1Cr-1 + n-1Cr
// 1~n에서 r개 뽑을 때 = k가 포함된 부분집합의 갯수 + k가 포함되지 않은 부분집합의 개수
// k가 포함된 부분집합의 개수 = n-1Cr-1
// -> k가 이미 뽑혔기 때문에 n개에서 하나를 빼고 남은 n-1개 중에서 r-1개를 뽑는다. (뽑아야하는 r개에서 k가 하나 뽑혔으므로 r-1개를 뽑아야 함)
// k가 포함되지 않은 부분집합의 개수 = n-1Cr
// -> k가 포함되지 않음을 알기 때문에 n개에서 하나를 뺀 n-1개 중에서 r개를 뽑는다.(뽑아야 하는 r에서 아무것도 안뽑혔으므로 r개를 뽑아야 함)
package BAEKJOON.y22.m3.week3;

import java.util.Scanner;

public class ___Main_1010 {
    static long answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            answer = 0;
            int[][] dp = new int[M + 1][N + 1];
            for (int n = 1; n < M + 1; n++) {
                for (int r = 0; r < N + 1; r++) {
                    if (r == 0) dp[n][r] = 1;
                    else if (n < r) dp[n][r] = 0;
                    else if (n == r) dp[n][r] = 1;
                    else dp[n][r] = dp[n - 1][r - 1] + dp[n - 1][r];
                }
            }
            System.out.println(dp[M][N]);

//            combi(N, M, 0, 0);
//            System.out.println(answer);
        }
    }

    private static void combi(int n, int m, int idx, int cnt) {
        if (m - idx < n - cnt) {    // /뽑을수 있는 남은 다리 m-idx < 놓아야 하는 다리가 n-cnt개
            return;
        }
        if (cnt == n) {
            answer++;
            return;
        }

        for (int i = idx; i < m; i++) {
            combi(n, m, i + 1, cnt + 1);
        }
    }
}
