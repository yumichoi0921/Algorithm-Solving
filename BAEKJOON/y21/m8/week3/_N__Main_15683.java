package BAEKJOON.y21.m8.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _N__Main_15683 {
    static int N, M;
    static int[][] dir = {{}, {1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3}};
    static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌 -> (12시 3시 6시 9시)
    static int[] dc = {0, 1, 0, -1};
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] office = new int[N][M];
        List<int[]> cctv = new ArrayList<>(); // 0:방향 1:r 2:c
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                office[i][j] = sc.nextInt();
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctv.add(new int[]{office[i][j], i, j});
                }
            }
        }

        res = Integer.MAX_VALUE;
        solve(office, cctv, 0);
        System.out.println(res);
    }

    private static void solve(int[][] office, List<int[]> cctv, int idx) {
        // 모든 카메라의 탐색이 끝나면 종료
        if (idx == cctv.size()) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(office[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("---------------------");
            // 사각지대 숫자 세기
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (office[i][j] == 0)
                        cnt++;
                }
            }
            res = Math.min(res, cnt);
            return;
        }

        // 카메라마다 사방탐색
        for (int d = 0; d < dr.length; d++) {
            int[][] tMap = mapCopy(office);
            // 카메라가 감시하는 방향에 대해서 체크
            int cIdx = cctv.get(idx)[0];   // cctv 종류
            for (int i = 0; i < dir[cIdx].length; i++) {
                int nr = cctv.get(idx)[1];
                int nc = cctv.get(idx)[2];
                int nd = (dir[cIdx][i] + d) % 4;    // 2번 카메라/ nd =
                while (true) {
                    nr += dr[nd];
                    nc += dc[nd];
                    if (!(nr >= 0 && nr < N && nc >= 0 && nc < M) || tMap[nr][nc] == 6) {
                        break;
                    }
                    tMap[nr][nc] = 9;
                }
            }
            solve(tMap, cctv, idx + 1);
        }
    }

    private static int[][] mapCopy(int[][] map) {
        int[][] tmap = new int[N][M];
        for (int i = 0; i < tmap.length; i++) {
            for (int j = 0; j < tmap[0].length; j++) {
                tmap[i][j] = map[i][j];
            }
        }
        return tmap;
    }
}
