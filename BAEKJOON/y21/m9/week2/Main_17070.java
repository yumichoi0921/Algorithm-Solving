package BAEKJOON.y21.m9.week2;

import java.util.Scanner;

public class Main_17070 {
    static int N;
    static int[] dr;
    static int[] dc;
    static int[][] dir;
    static int[][] check;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[][] area = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = sc.nextInt();
            }
        }
        dr = new int[]{0, 1, 1};
        dc = new int[]{1, 0, 1};
        dir = new int[][]{{0, 2}, {1, 2}, {0, 1, 2}};    // 현재 방향에서 갈 수 있는 방향 0:가로/1:세로/2:대각선
        check = new int[][]{{0}, {1}, {0, 1, 2}};   // 각 방향에서 체크해야 하는 dr dc 인덱스

        int r = 0, c = 1;  // 현재 끝 위치
        int d = 0; // 현재 방향

        res = 0;
        dfs(area, r, c, d);
        System.out.println(res);
    }

    private static void dfs(int[][] area, int r, int c, int d) {
        if (r == N - 1 && c == N - 1) {
            res++;
            return;
        }
        for (int i = 0; i < dir[d].length; i++) {
            int nd = dir[d][i];
            int nr = 0, nc = 0;
            boolean flag = true;
            for (int j = 0; j < check[nd].length; j++) {
                nr = r + dr[check[nd][j]];
                nc = c + dc[check[nd][j]];
                if (!(nr >= 0 && nr < N && nc >= 0 && nc < N && area[nr][nc] == 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                dfs(area, nr, nc, nd);
            }
        }
    }
}
