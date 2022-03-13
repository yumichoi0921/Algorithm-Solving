package SWEA.m9.week3;

import java.util.Scanner;
// 플로이드 워샬
public class Solution_1263 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 사람 수
            int[][] C = new int[N+1][N+1];

            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {
                    int dist = sc.nextInt();
                    if (dist == 0) C[i][j] = 10000;
                    else C[i][j] = dist;
                }
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (i==k || j==k || i==j) continue;
                        C[i][j] = Math.min(C[i][j], C[i][k]+C[k][j]);
                    }
                }
            }

            int minDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                int tmpDist = 0;
                for (int j = 1; j <= N; j++) {
                    if (C[i][j] == 10000) C[i][j] = 0;
                    tmpDist += C[i][j];
                }
                if (tmpDist < minDist) {
                    minDist = tmpDist;
                }
            }

            System.out.printf("#%d %d\n", tc, minDist);
        }
    }
}
