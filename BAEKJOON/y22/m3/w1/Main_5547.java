// 일루미네이션
//  bfs
package BAEKJOON.y22.m3.w1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_5547 {
    static int W;
    static int H;
    static int[][] map;
    static int[][] dx = {{-1, 0, -1, 1, 0, -1}, {0, 1, -1, 1, 1, 0}};
    static int[] dy = {-1, 1, 0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                int n = sc.nextInt();
                if ((y == 0 || y == H - 1 || x == 0 || x == W - 1) && n == 0) { // 외곽의 0(건물이 없는 부분)을 -1로 처리
                    map[y][x] = -1;
                } else {
                    map[y][x] = n;
                }
            }
        }
        answer = 0;

        // 외곽의 -1인 부분과 인접한 0을 모두 -1로 처리
        boolean[][] visited = new boolean[H][W];
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (map[y][x] == -1 && !visited[y][x]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{y, x});
                    visited[y][x] = true;
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        map[pos[0]][pos[1]] = -1;
                        int num = ((pos[0] + 1) % 2 == 0) ? 0 : 1;
                        for (int d = 0; d < 6; d++) {
                            int nx = pos[1] + dx[num][d];
                            int ny = pos[0] + dy[d];
                            if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
                                if (map[ny][nx] == 0 && !visited[ny][nx]) {
                                    q.add(new int[]{ny, nx});
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }

                }
            }
        }
        // H, W 를 벗어나거나 -1에 인접한 건물 벽면 찾기
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (map[y][x] == 1) {
                    int num = ((y + 1) % 2 == 0) ? 0 : 1;
                    for (int d = 0; d < 6; d++) {
                        int nx = x + dx[num][d];
                        int ny = y + dy[d];
                        if (!(nx >= 0 && nx < W && ny >= 0 && ny < H) || map[ny][nx] == -1) {
                            answer++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

}
