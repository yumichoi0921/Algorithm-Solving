package BAEKJOON.y21.m9.week3;

import java.util.Scanner;

// 내리막길
// dp, dfs
public class A__Main_1520 {
    static int M, N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();   // 세로 크기
        N = sc.nextInt();   // 가로 크기
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
//        res = 0;
//        dfs(map, 0, 0);
//        System.out.println(res);
        res = 0;
        int[][] memo = new int[M][N];
        res = dfs_dp(map, memo, 0, 0);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(memo[i][j]);
            }
            System.out.println();
        }
        System.out.println(res);


    }


    private static int dfs_dp(int[][] map, int[][] memo, int r, int c) {
        // 되돌아오면서 왔던 길에 1을 찍음
        if (r == M - 1 && c == N - 1) {
            return 1;
        }
        // 갔던 길이었으면
        if (memo[r][c] != 0) return memo[r][c];

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
                memo[r][c] += dfs_dp(map, memo, nr, nc);
            }
        }
        return memo[r][c];
    }

    private static void dfs(int[][] map, int r, int c) {
        if (r == M - 1 && c == N - 1) {
            res++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
                dfs(map, nr, nc);
            }
        }
    }
}
