package BAEKJOON.y21.m9.week3;

import java.util.Scanner;

// 플로이드 워샬
public class A__Main_9205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[][] pos = new int[n + 2][2];
            pos[0] = new int[]{sc.nextInt(), sc.nextInt()};
            for (int i = 1; i <= n; i++) {
                pos[i] = new int[]{sc.nextInt(), sc.nextInt()};
            }
            pos[n + 1] = new int[]{sc.nextInt(), sc.nextInt()};

            boolean[][] dist = new boolean[n + 2][n + 2];
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist[i].length; j++) {
                    if (Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]) <= 1000) {
                        dist[i][j] = true;
                    }
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        if (i == k || j == k || i == j) continue;
                        if (dist[i][k] && dist[k][j]) dist[i][j] = true;
                    }
                }
            }
            String result;
            if (dist[0][n + 1]) result = "happy";
            else result = "sad";

            System.out.println(result);

        }
    }
}
