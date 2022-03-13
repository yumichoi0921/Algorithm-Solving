package SWEA.m12.week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 광이삼의_암벽_등반 {
    static int M, N, L, result;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            M = sc.nextInt();
            N = sc.nextInt();
            L = sc.nextInt();
            map = new int[M][N];
            int[] start = new int[2];
            int[] destination = new int[2];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 2) {
                        start[0] = i;
                        start[1] = j;
                    } else if (map[i][j] == 3) {
                        destination[0] = i;
                        destination[1] = j;
                    }
                }
            }

            result = Integer.MAX_VALUE;
//            Queue<Point> q = new LinkedList<>();
//            boolean[][][] visited = new boolean[M][N][10];
//            q.add(new Point(start[0], start[1], L, 0));
//            visited[start[0]][start[1]][0] = true;
//            while (!q.isEmpty()) {
//                Point p = q.poll();
////                System.out.println("[" + p.r + " " + p.c + "]" + p.cnt + " " + p.l);
//                if (p.r == destination[0] && p.c == destination[1]) {
//                    if (p.l >= 0) {
//                        result = Math.min(result, p.cnt);
//                    }
//                }
//
//                for (int d = 0; d < 4; d++) {
//                    int nr = p.r + dr[d];
//                    int nc = p.c + dc[d];
//                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc][p.cnt]) {
//                        if (map[nr][nc] == 1) {
//                            q.add(new Point(nr, nc, p.l - 1, p.cnt));
//                            q.add(new Point(nr, nc, L, p.cnt + 1));
//                            visited[nr][nc][p.cnt] = true;
//                        } else {
//                            q.add(new Point(nr, nc, p.l - 1, p.cnt));
//                            visited[nr][nc][p.cnt] = true;
//                        }
//                    }
//                }
//            }
//            dfs();
            System.out.println(result);

        }
    }

    static class Point {
        int r, c, l, cnt;

        public Point(int r, int c, int l, int cnt) {
            this.r = r;
            this.c = c;
            this.l = l;
            this.cnt = cnt;
        }
    }
}
