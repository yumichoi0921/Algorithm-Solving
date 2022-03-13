// 봄버맨
package BAEKJOON.y22.m3.week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16918 {
    static int R, C, N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.next();
            for (int j = 0; j < C; j++) {
                char n = input.charAt(j);
                if (n == 'O') map[i][j] = 3;    // 폭탄이 있는 부분은 터지기까지 남은 숫자
                else map[i][j] = -1;            // 폭탄이 없으면 -1
            }
        }

        int time = 0;
        while (time < N) {
            if (time % 2 == 0) {
                countingBomb();
                checkBomb();
            } else {
                countingBomb();
                checkBomb();
                makeBomb();
            }
            time++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) System.out.print("."); // 폭탄이 없을 때
                else System.out.print("O");                 // 폭탄이 있을 때
            }
            System.out.println();
        }


    }

    // 폭탄 없는 곳에 폭탄 심기
    private static void makeBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) map[i][j] = 3;
            }
        }
    }

    // 폭탄이 있는 곳 0이라면 지금 터져야 함
    private static void checkBomb() {
        boolean[][] visited = new boolean[R][C];    // 폭탄 영향 받는 좌표 중복제거
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0 && !visited[i][j]) { // 폭탄이 터지는 곳이고 아직 체크 안했다면
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 0) {   // 범위내에 있고 그 자리에 당장 터져야 하는 폭탄이 있는게 아니라면
                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        for (int[] pos : q
        ) {
            map[pos[0]][pos[1]] = -1;
        }

    }

    // 폭탄이 있는 곳은 터지기 전까지 남은 시간 1 감소시키기
    private static void countingBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) map[i][j] -= 1;
            }
        }
    }
}
