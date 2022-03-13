package SWEA.m11.week2;

import java.util.*;
// 동철이의 일 분배
// 순열
public class Solution_1865 {
    static int N;
    static double res;
    static double[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = (double)sc.nextInt()/100;
                }
            }

            res = 0.0;
            permu(new boolean[N], new double[N], 0, 1.0);
            System.out.printf("#%d %.6f \n", tc, res*100);
        }
    }

    private static void permu(boolean[] sel, double[] work, int idx, double percent) {
        if (percent < res) return;
        if (idx == N) {
            res = Math.max(res, percent);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!sel[i]) {
                if (map[idx][i] != 0.0) {
                    sel[i] = true;
                    work[idx] = map[idx][i];
                    permu(sel, work, idx+1, percent*map[idx][i]);
                    sel[i] = false;
                }
            }
        }
    }
}
