package BAEKJOON.y21.m9.week4;

import java.util.ArrayList;
import java.util.Scanner;

// 미세먼지 안녕!
// 시뮬레이션
// 미세먼지 확산-bfs, 델타
// 공기청정기 작동 - 델타
public class Main_17144 {
    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        int T = sc.nextInt();
        int[][] map = new int[R][C];
        ArrayList<Node> airCleaner = new ArrayList<>(); // 공기청정기 좌표
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) {
                    if (map[i][j] == -1) airCleaner.add(new Node(i, j, 0));
                }
            }
        }

        int t = 0;
        while (t < T) {
            t++;
            diffusion(map); // 확산
            cleaning(map, airCleaner);  // 청정
        }

        int dust = 0;
        for (int i = 0; i < R; i++) {   // 남은 미세먼지양
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) dust += map[i][j];
            }
        }
        System.out.println(dust);
    }

    private static void diffusion(int[][] map) {
        ArrayList<Node> dusts = new ArrayList<>();
        // 먼지 찾기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) dusts.add(new Node(i, j, map[i][j]));
            }
        }
        // 확산 전처리
        for (int i = 0; i < dusts.size(); i++) {
            Node dust = dusts.get(i);
            int dirs = 0;                   // 확산 가능한 방향 개수
            for (int d = 0; d < 4; d++) {   // 확산 가능한 곳 찾기
                int nr = dust.r + dr[d];
                int nc = dust.c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                    dirs++;
                }
            }
            dust.val = map[dust.r][dust.c] / 5;   // 확산할 값 저장
            map[dust.r][dust.c] = map[dust.r][dust.c] - (map[dust.r][dust.c] / 5) * dirs; // 자기 확산 후 값
        }
        // 확산하기
        for (int i = 0; i < dusts.size(); i++) {
            Node dust = dusts.get(i);
            for (int d = 0; d < 4; d++) {
                int nr = dust.r + dr[d];
                int nc = dust.c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                    map[nr][nc] += dust.val;   // 자기 확산한 후 값 + 다른 먼지로부터 확산받은 값
                }
            }
        }

    }

    private static void cleaning(int[][] map, ArrayList<Node> airCleaner) {
        int[][] dir = {{0, 3, 1, 2}, {1, 3, 0, 2}};
        // 위쪽-반시계 우상좌하 -> 상우하좌 0312
        // 아래쪽-시계 우하좌상 -> 하우상좌 1302
        for (int i = 0; i < airCleaner.size(); i++) {
            int r = airCleaner.get(i).r;
            int c = airCleaner.get(i).c;
            for (int d = 0; d < dir[i].length; d++) {
                int nd = dir[i][d]; // i번째 청정기의 방향
                while (true) {
                    int nr = r + dr[nd];
                    int nc = c + dc[nd];
                    if (i == 0) {  // 청정기별 경계값 체크
                        if (!(nr >= 0 && nr <= airCleaner.get(i).r && nc >= 0 && nc < C)) break;
                    } else {
                        if (!(nr >= airCleaner.get(i).r && nr < R && nc >= 0 && nc < C)) break;
                    }
                    if (nr == airCleaner.get(i).r && nc == airCleaner.get(i).c) {  // 청정기에 들어간 공기는 청정되어 나옴
                        map[nr][nc] = 0;
                    }
                    map[r][c] = map[nr][nc];
                    r = nr;
                    c = nc;
                }
            }
            map[airCleaner.get(i).r][airCleaner.get(i).c] = -1;
        }
    }

    static class Node {
        int r, c, val;

        Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val; // 좌표에서 확산할 값
        }
    }
}
