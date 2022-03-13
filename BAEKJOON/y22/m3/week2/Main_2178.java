// 미로탐색
// bfs
package BAEKJOON.y22.m3.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        answer = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Position p = q.poll();
            if (p.r == N - 1 && p.c == M - 1) {
                answer = p.cnt;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !visited[nr][nc]) {
                    q.add(new Position(nr, nc, p.cnt + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        System.out.println(answer);
    }

    static class Position {
        int r, c, cnt;

        public Position(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
