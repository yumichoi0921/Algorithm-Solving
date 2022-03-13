package SWEA.m8.week4;

import java.util.Scanner;

public class Solution_7236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            char[][] area = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    area[i][j] = sc.next().charAt(0);
                }
            }
            int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

            int resDepth = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] == 'W') {
                        int depth = 0;
                        int r = i, c = j;
                        for (int d = 0; d < 8; d++) {
                            int nr = r+dr[d], nc = c+dc[d];
                            if (nr>=0 && nr<N && nc>=0 && nc<N && area[nr][nc] == 'W') {
                                depth++;
                            }
                        }
                        if (depth == 0) depth = 1;
                        resDepth = Math.max(resDepth, depth);
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, resDepth);
        }
    }
}
