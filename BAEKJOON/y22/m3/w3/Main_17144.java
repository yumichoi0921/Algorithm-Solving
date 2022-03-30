// 미세먼지 안녕!
// 시뮬레이션
// 사방탐색
package BAEKJOON.y22.m3.w3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17144 {
    static int R, C, T;
    static int[][] map;
    static Queue<int[]> dusts;
    static ArrayList<int[]> airCleaner;
    static int[][] dr = {{-1, 0, 1, 0}, {1, 0, -1, 0}};
    static int[] dc = {0, 1, 0, -1};        // 위-> 상우하좌 // 아래-> 하우상좌

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];
        dusts = new LinkedList<>();
        airCleaner = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] < 0) airCleaner.add(new int[]{i, j});
            }
        }

        while (T > 0) {
            T--;
            // 먼지 찾기
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {    // 먼지가 있으면 dusts에 넣어주고 0으로 초기화
                        dusts.add(new int[]{i, j, map[i][j]});
                        map[i][j] = 0;
                    }
                }
            }
            // 먼지 확산
            Queue<int[]> q = new LinkedList<>();    // 확산할 자리와 원래 자리
            while (!dusts.isEmpty()) {
                int[] dust = dusts.poll();
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = dust[0] + dr[0][d];
                    int nc = dust[1] + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {  // 사방탐색했을 때 범위 내고 청정기 자리가 아니면
                        cnt++;  // 확산 방향 개수 증가
                        q.add(new int[]{nr, nc, dust[2] / 5});  // 확산할 자리, 확산량 저장
                    }
                }
                q.add(new int[]{dust[0], dust[1], (dust[2] - (dust[2] / 5) * cnt)});    // 원래 자리, 남은 양 저장
            }

            while (!q.isEmpty()) {
                int[] pos = q.poll();
                map[pos[0]][pos[1]] += pos[2];  // 기존에 있던 먼지량(or 0)에 새로 더하기
            }
            // 공기청정기
            for (int a = 0; a < airCleaner.size(); a++) {
                int r = airCleaner.get(a)[0];
                int c = airCleaner.get(a)[1];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[a][d];
                    int nc = c + dc[d];
                    while (nr >= 0 && nr < R && nc >= 0 && nc < C) {    // 범위 내에 있다면
                        if (a == 0 && nr > airCleaner.get(a)[0]) break; // 위쪽 공기청정기 r 범위 밖이면 방향전환;
                        if (a == 1 && nr < airCleaner.get(a)[0]) break; // 아래쪽 공기청정기 r 범위 밖이면 방향전환;
                        if (map[r][c] == -1) map[r][c] = -1;    // 공기청정기로 들어가면 -1   => 이거때문에 한참걸림ㅜ
                        else if (map[nr][nc] == -1) map[r][c] = 0;  // 공기청정기에서 나오면 0
                        else map[r][c] = map[nr][nc];   // 미세먼지 이동
                        r = nr;
                        c = nc;
                        nr = r + dr[a][d];
                        nc = c + dc[d];
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
}
