package SWEA.m10.week1;

import java.util.*;

// 벽돌 깨기
// 중복순열 - 구슬 떨어트릴 열과 순서 정하기
// bfs/dfs -  벽돌 깨기
public class Solution_5656 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, W, H, res;
    static int[][] map;

    static class Point {
        int r, c, range;

        public Point(int r, int c, int range) {
            this.r = r;
            this.c = c;
            this.range = range;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            res = Integer.MAX_VALUE;
            int[] sel = new int[N];
            permu(sel, 0);
            System.out.println("#" + tc + " " + res);
        }
    }

    private static void permu(int[] sel, int cnt) {
        if (cnt == N) {
            res = Math.min(res, check(sel));
            return;
        }
        for (int i = 0; i < W; i++) {
            sel[cnt] = i;
            permu(sel, cnt + 1);
        }
    }

    private static int check(int[] sel) {
        // map 복사
        int[][] tmap = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                tmap[i][j] = map[i][j];
            }
        }

        // N번 벽돌 깨기
        for (int w = 0; w < sel.length; w++) {
            int c = sel[w];
            // 열에서 가장 가까운 벽 찾기
            for (int r = 0; r < H; r++) {
                if (tmap[r][c] > 0) {
                    // 벽돌 깨기
                    boom_bfs(tmap, r, c);
//                    boom_dfs(tmap, r, c, tmap[r][c]);
                    break;
                }
            }
            // 벽돌 내리기
            down(tmap);
        }
        // 남은 벽돌 세기
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (tmap[i][j] > 0) cnt++;
            }
        }
        return cnt;
    }

    private static void down(int[][] tmap) {
        // 방법 1
//        for (int j = 0; j < W; j++) {
//            int i = H - 1;
//            while (i > 0) {
//                if (tmap[i][j] == 0) {    // 빈칸이면 벽돌내리기
//                    int ni = i - 1;       // 자신 직전 행부터 탐색
//                    while (ni > 0 && tmap[ni][j] == 0) ni--;
//                    tmap[i][j] = tmap[ni][j];    // 현재 빈칸에는 자신의 위쪽으로 처음 만나는 벽돌로 내리기
//                    tmap[ni][j] = 0;
//                }
//                i--;
//            }
//        }
        // 방법 2
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < W; j++) {
            // 부서지지 않은 벽돌만 리스트에 담기
            for (int i = H - 1; i >= 0; i--) {
                if (tmap[i][j] > 0) {
                    list.add(tmap[i][j]);
                    tmap[i][j] = 0;
                }
            }
            // 리스트에 있는 벽돌 제일 아래 행부터 채우기
            int i = H - 1;
            for (int k : list) {
                tmap[i][j] = k;
                i--;
            }
            list.clear();
        }
    }

    private static void boom_dfs(int[][] tmap, int r, int c, int range) {
        tmap[r][c] = 0;
        if (range == 1) return;   // 범위가 1이면 연쇄작용 없으므로 리턴

        for (int rg = 0; rg < range; rg++) {    // 범위만큼
            for (int d = 0; d < 4; d++) {       // 방향탐색
                int nr = r + dr[d] * rg;
                int nc = c + dc[d] * rg;
                if (nr >= 0 && nr < H && nc >= 0 && nc < W && tmap[nr][nc] != 0) {
                    boom_dfs(tmap, nr, nc, tmap[nr][nc]);
                }
            }
        }
    }

    private static void boom_bfs(int[][] tmap, int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, tmap[r][c]));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int pr = p.r;
            int pc = p.c;
            int range = p.range;
            for (int rg = 0; rg < range; rg++) {    // 범위만큼
                for (int d = 0; d < 4; d++) {       // 방향탐색
                    int nr = pr + dr[d] * rg;
                    int nc = pc + dc[d] * rg;
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && tmap[nr][nc] != 0) {
                        if (rg != 0) {  // rg==0이면 자기 자신이므로 넣지 않음
                            q.add(new Point(nr, nc, tmap[nr][nc]));
                        }
                        tmap[nr][nc] = 0;
                    }
                }
            }
        }
    }
}
