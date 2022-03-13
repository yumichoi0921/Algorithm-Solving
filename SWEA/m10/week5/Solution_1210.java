package SWEA.m10.week5;

import java.util.Scanner;
// Ladder1
public class Solution_1210 {
    static int[] dr={0, 0, -1};
    static int[] dc={-1, 1, 0};
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            map = new int[100][100];
            int r = 0, c = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 2) {
                        r = i;
                        c = j;
                    }
                }
            }

            boolean[][] v = new boolean[100][100];
            v[r][c] = true;
            while (true) {
                if (r == 0) {
                    break;
                }
                for (int d = 0; d < 3; d++) {
                    int nr = r+dr[d];
                    int nc = c+dc[d];
                    if (nr>=0 && nr<100 && nc>=0 && nc<100 && map[nr][nc]==1 && !v[nr][nc]) {
                        v[nr][nc] = true;
                        r = nr;
                        c = nc;
                        break;
                    }
                }

            }
            System.out.println("#"+tc+" "+c);
        }
    }
}
