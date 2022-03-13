package BAEKJOON.y21.m11.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_23289 {
    static class Heater {
        int r, c, d;

        public Heater(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int R, C, K, chocolate;
    static int[][] map;
    static int[] dr = {0, 0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0, 1, 1, -1, -1};
    static ArrayList<Heater> heaters;
    static ArrayList<int[]> checkpoint;
    static int[][] walls;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        map = new int[R][C];
        heaters = new ArrayList<>();
        checkpoint = new ArrayList<>();
        walls = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int n = sc.nextInt();
                if (n==0) {
                    map[i][j] = n;
                } else if (n==5) {
                    checkpoint.add(new int[] {i, j});
                } else {
                    heaters.add(new Heater(i, j, n));
                }
            }
        }
        for (int i = 0; i < sc.nextInt(); i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int t = sc.nextInt();
            if (t==0) {
                walls[x][y] = 3;
            } else {
                walls[x][y] = 1;;
            }
        }

        chocolate = 0;
        while (chocolate < 100) {
            // 집에 있는 모든 온풍기에서 바람이 한 번 나옴
            heating();
            // 온도가 조절됨
            // 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
            // 초콜릿을 하나 먹는다.
            chocolate++;
            // 조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K이상이면 테스트를 중단하고, 아니면 1부터 다시 시작한다.

        }


    }

    private static void heating() {
        int[][] diffusion = new int[5][2];
        diffusion[1] = new int[]{5, 1, 6};
        diffusion[2] = new int[]{7, 2, 8};
        diffusion[3] = new int[]{7, 3, 5};
        diffusion[4] = new int[]{8, 4, 6};
        for (int h = 0; h < heaters.size(); h++) {
            int r = heaters.get(h).r;
            int c = heaters.get(h).c;
            int dir = heaters.get(h).d;
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[R][C];
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            if (nr>=0 && nr<R && nc>=0 && nc<C && walls[nr][nc] != dir) {
                q.add(new int[] {nr, nc});
            }




            if (dir == 1) { // 오른쪽

            } else if (dir == 2) {  // 왼쪽

            } else if (dir == 3) {  // 위쪽

            } else if (dir == 4) {  // 아래쪽

            }
        }
    }
}
