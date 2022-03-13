package BAEKJOON.y21.m8.week4;

import java.util.Scanner;

public class _N__Main_14503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] dr = {-1, 0, 1, 0};   // 북동남서 -> 상우하좌
        int[] dc = {0, 1, 0, -1};

        int[][] arr = new int[N][M];    // 빈칸 0 벽 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        while (true) {
            if (arr[r][c] == 0) {
                arr[r][c] = -1;
                cnt++;
            }

            boolean clean = false;
            for (int i = 0; i < 4; i++) {
                d--;
                if (d < 0) d = 3;
                int nr = r + dr[d], nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    clean = true;
                    break;
                }
            }
            if (!clean) {
                r = r - dr[d];
                c = c - dc[d];
                if (r < 0 || r >= N || c < 0 || c >= M || arr[r][c] == 1)
                    break;
            }
        }
        System.out.println(cnt);
    }
}
