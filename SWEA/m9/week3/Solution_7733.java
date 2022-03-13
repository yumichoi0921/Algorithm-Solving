package SWEA.september.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 치즈도둑
// bfs
public class Solution_7733 {
    static int N;
    static int result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            int[][] cheese = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }

            result = 0;
            for (int d = 1; d <= 100; d++) {
                int cnt = 0;
                boolean[][] v = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (cheese[i][j] > d && !v[i][j]) {
                            cnt++;
                            bfs(cheese, i, j, d, v);
                        }
                    }
                }
                result = Math.max(result, cnt);
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }

    private static void bfs(int[][] cheese, int r, int c, int day, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        v[r][c] = true;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = pos[0]+dr[d];
                int nc = pos[1]+dc[d];
                if (nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc] && cheese[nr][nc]>day) {
                    v[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

    }


}
