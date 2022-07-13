package Programmers.y22.m6.w5;

public class 등굣길 {
    static int[] dr = {-1, 0};
    static int[] dc = {0, -1};
//    static int[] dr = {1, 0};
//    static int[] dc = {0, 1};

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        map[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] < 0) continue;
                int up = 0, left = 0;
                if (i - 1 >= 0 && map[i - 1][j] >= 0) up = map[i - 1][j];
                if (j - 1 >= 0 && map[i][j - 1] >= 0) left = map[i][j - 1];
                map[i][j] = (map[i][j] + up + left) % 1000000007;
            }
        }
        answer = map[n - 1][m - 1];
//        answer = dfs(map, 0, 0, n, m);
        return answer;
    }

    public int dfs(int[][] map, int r, int c, int n, int m) {
        if (r == n - 1 && c == m - 1) {
            return 1;
        }

        if (map[r][c] > 0) {
            return map[r][c];
        }

        for (int d = 0; d < 2; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!(nr >= 0 && nr < n && nc >= 0 && nc < m) || map[nr][nc] < 0) continue;
            map[r][c] += dfs(map, nr, nc, n, m);
        }

        return map[r][c] % 1000000007;
    }


}
