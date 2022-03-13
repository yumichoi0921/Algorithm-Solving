package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_4615 {
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N+1][N+1];
            map[N/2][N/2] = 2; map[N/2][N/2+1] = 1;
            map[N/2+1][N/2] = 1; map[N/2+1][N/2+1] = 2;


            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int c = sc.nextInt();
                int r = sc.nextInt();
                int color = sc.nextInt();
                game(map, N, r, c, color);
            }

            int Bcnt = 0, Wcnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N ; j++) {
                    if (map[i][j] == 1) {
                        Bcnt++;
                    } else if(map[i][j] == 2) {
                        Wcnt++;
                    }
                }
            }
            System.out.printf("#%d %d %d", tc, Bcnt, Wcnt);
            System.out.println();
        }
    }

    private static void game(int[][] map, int N, int r, int c, int color) {
        map[r][c] = color;
        for (int d = 0; d < 8; d++) {
            int tmpr = r, tmpc = c;
            int step = 1;
            while (true) {
                tmpr = tmpr + dr[d];
                tmpc = tmpc + dc[d];
                if (tmpr < 1 || tmpr > N || tmpc < 1 || tmpc > N || map[tmpr][tmpc] == 0) {
                    break;
                }
                if (map[tmpr][tmpc] == color) {
                    for (int s = 1; s <= step; s++) {
                        map[r + dr[d] * s][c + dc[d] * s] = color;
                    }
                    break;
                }
                step++;
            }
        }
    }

}
