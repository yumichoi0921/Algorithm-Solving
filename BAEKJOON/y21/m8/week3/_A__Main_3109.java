package BAEKJOON.y21.m8.week3;

import java.util.Scanner;

public class _A__Main_3109 {
    static int cnt;
    static int[] dr;
    static int[] dc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] area = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                area[i][j] = str.charAt(j);
            }
        }
        // 오른쪽 위, 오른쪽, 오른쪽 아래
        dr = new int[]{-1, 0, 1};
        dc = new int[]{1, 1, 1};
        for (int i = 0; i < R; i++) {
            dfs(area, R, C, i, 0);
        }
        System.out.println(cnt);
    }

    private static boolean dfs(char[][] area, int R, int C, int r, int c) {
        if (c == C - 1) {
            cnt++;
            return true;
        }
        for (int d = 0; d < dc.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if (area[nr][nc] == '.') {
                    area[nr][nc] = '-';
                    if (dfs(area, R, C, nr, nc)) return true;
//                    return dfs(area, R, C, nr, nc);
                }
            }
        }
        return false;
    }
}
