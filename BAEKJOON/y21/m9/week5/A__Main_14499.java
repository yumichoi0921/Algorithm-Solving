package BAEKJOON.y21.m9.week5;

import java.util.Scanner;

// 주사위 굴리기
// 시뮬레이션
public class A__Main_14499 {
    static int[] dr = {0, 0, 0, -1, 1}; // 동 서 북 남
    static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int K = sc.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[] command = new int[K];
        for (int i = 0; i < K; i++) {// 동 서 북 남
            command[i] = sc.nextInt();
        }

        //동서로 굴릴 때 -> 0, 1, 3, 6, 4
        //남북으로 굴릴 때 -> 0, 1, 2, 6, 5

        int[] dice = new int[]{0, 0, 0, 0, 0, 0, 0};
        int down = 6;
        int up = 1;
        for (int i = 0; i < command.length; i++) {
            int nr = x + dr[command[i]];
            int nc = y + dc[command[i]];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                int temp = dice[down];
                if (command[i] == 1) {
                    dice[6] = dice[3];
                    dice[3] = dice[1];
                    dice[1] = dice[4];
                    dice[4] = temp;
                } else if (command[i] == 2) {
                    dice[6] = dice[4];
                    dice[4] = dice[1];
                    dice[1] = dice[3];
                    dice[3] = temp;
                } else if (command[i] == 3) {
                    dice[6] = dice[2];
                    dice[2] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = temp;
                } else if (command[i] == 4) {
                    dice[6] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = dice[2];
                    dice[2] = temp;
                }

                if (map[nr][nc] != 0) {
                    dice[down] = map[nr][nc];
                    map[nr][nc] = 0;
                    System.out.println(dice[up]);
                } else {
                    map[nr][nc] = dice[down];
                    System.out.println(dice[up]);
                }
                x = nr;
                y = nc;
            }
        }


    }
}
