// 드래곤커브
// 시뮬레이션
package BAEKJOON.y22.m3.w5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_15685 {
    static int N;
    static ArrayList<DragonCurve> dcs;
    static int[] dc = {0, -1, 0, 1};    // 우 상 하 좌
    static int[] dr = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dcs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            dcs.add(new DragonCurve(x, y, d, g));
        }

        boolean[][] map = new boolean[101][101];
        for (int cur = 0; cur < dcs.size(); cur++) {
            DragonCurve curve = dcs.get(cur);
            ArrayList<Integer> ds = new ArrayList<>();
            for (int j = 0; j <= curve.g; j++) {    // 규칙
                if (j == 0) {
                    ds.add(curve.d);
                } else {
                    int size = ds.size() - 1;   // 기존 방향에 이제까지 방향을 역순서로+1해서 추가
                    while (size >= 0) {
                        ds.add((ds.get(size) + 1) % 4);
                        size--;
                    }
                }
            }
            int r = curve.x;
            int c = curve.y;
            map[r][c] = true;
            for (int j = 0; j < ds.size(); j++) {
                int nr = r + dr[ds.get(j)];
                int nc = c + dc[ds.get(j)];
                map[nr][nc] = true;
                r = nr;
                c = nc;
            }
        }
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static class DragonCurve {
        int x, y, d, g;

        public DragonCurve(int x, int y, int d, int g) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }
}

// 우상좌하
//0
//1
//21
//2321
//23032321