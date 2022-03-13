package BAEKJOON.y21.m9.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 달이 차오른다, 가자.
// bfs
// 비트마스킹
public class A__Main_1194 {
    static int N, M, result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        char[][] map = new char[N][M];
        int Sr = 0, Sc = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') {
                    Sr = i;
                    Sc = j;
                }
            }
        }

        result = -1;
        // bfs
        boolean[][][] v = new boolean[N][M][64];
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(Sr, Sc, 0, 0));
        v[Sr][Sc][0] = true;

        while (!Q.isEmpty()) {
            Point p = Q.poll();
            if (map[p.r][p.c] == '1') {
                result = p.cnt;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int nk = p.key;
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != '#') {
                    if (!v[nr][nc][nk]) {   // nr, nc 위치에서 nk라는 상태를 가지고는 한번만 지날 수 있음
                        // 문을 만나면
                        if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
                            // 문에 맞는 키가 있는지 검사 -> 있으면 통과
                            if ((nk & (1 << map[nr][nc] - 'A')) == 0) {
                                // 키 없음
                                continue;
                            }
                        }

                        // 키를 만나면
                        if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
                            // 키를 취득
                            nk = nk | (1 << map[nr][nc] - 'a');
                        }
                        v[nr][nc][nk] = true;
                        Q.offer(new Point(nr, nc, p.cnt + 1, nk));
                    }
                }
            }
        }
        System.out.println(result);

    }

    static class Point {
        int r, c, cnt, key;

        Point(int r, int c, int cnt, int key) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.key = key;
        }
    }
}
