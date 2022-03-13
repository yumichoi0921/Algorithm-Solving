package BAEKJOON.y21.m9.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A__Main_1600 {
    static int K, W, H, result;
    // 말과 원숭이처럼 뛸수 있는 총 방향 8+4개
    static int[] dr = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        result = -1;
        // bfs
        // 어떤 위치를 말처럼 가야 도착지까지 빨리 도착할까, 원숭이처럼 가야 도착지까지 빨리 도착할까?
        // 말처럼 갈 수 있는 횟수가 K번이므로 한 위치를 가는 방법이 K=0 ~ K=K일 때 K+1번이 있음
        // 방문 배열은 [r][c][k]: [r][c]까지 왔을 때 [k]번만큼 말처럼 뛰어서 온 적이 있는지

        Queue<Monkey> Q = new LinkedList<>();
        boolean[][][] v = new boolean[H][W][K + 1];   // [r][c][k]: [r][c]까지 왔을 때 말처럼 뛴 횟수가 [k]라면 true
        Q.offer(new Monkey(0, 0, 0, 0));
        v[0][0][0] = true;
        while (!Q.isEmpty()) {
            Monkey monkey = Q.poll();
            if (monkey.r == H - 1 && monkey.c == W - 1) {
                result = monkey.cnt;
                break;
            }

            for (int d = 0; d < (monkey.k == K ? 4 : 12); d++) {
                int nr = monkey.r + dr[d];
                int nc = monkey.c + dc[d];
                int nk = (d < 4 ? monkey.k : monkey.k + 1);
                if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 1 && !v[nr][nc][nk]) {
                    v[nr][nc][nk] = true;
                    Q.offer(new Monkey(nr, nc, nk, monkey.cnt + 1));
                }
            }
        }
        System.out.println(result);

    }

    static class Monkey {
        int r, c, k, cnt;

        Monkey(int r, int c, int k, int cnt) {
            this.r = r;
            this.c = c;
            this.k = k;         // 말처럼 뛴 횟수
            this.cnt = cnt;     // 총 이동 횟수
        }
    }
}
