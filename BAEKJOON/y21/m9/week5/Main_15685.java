package BAEKJOON.y21.m9.week5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_15685 {
    static int[] dy = {0, -1, 0, 1};    // 우 상 좌 하
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[101][101];
        ArrayList<Dcurve> dcs = new ArrayList<>();  // 드래곤커브 리스트
        for (int i = 0; i < N; i++) {
            dcs.add(new Dcurve(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < dcs.size(); i++) {
            Dcurve dc = dcs.get(i);
            int nx = dc.x, ny = dc.y, nd = dc.d;                // 시작점, 시작방향
            ArrayList<Integer>[] dirs = new ArrayList[dc.g + 1];  // 각 세대에서 이동할 방향을 저장한 배열 (세대마다 이동하는 방향 횟수가 다름 -> 리스트)
            map[ny][nx] = 1;                                    // 시작점 방문
            for (int g = 0; g <= dc.g; g++) {                   // 각 세대별 드래곤커브
                dirs[g] = new ArrayList<>();
                if (g == 0) {                                   // 0세대는 시작방향으로 이동
                    dirs[g].add(nd);
                } else {                                        // 나머지 세대
                    for (int j = g - 1; j >= 0; j--) {            // 바로 이전 세대로 거슬러 감
                        for (int k = dirs[j].size() - 1; k >= 0; k--) {   // 이전 세대의 마지막 이동 방향부터 시작
                            dirs[g].add((dirs[j].get(k) + 1) % 4);          // 시계방향 회전해서 현 세대에 저장
                        }
                    }
                }

                for (int d = 0; d < dirs[g].size(); d++) {      // 각 세대에서 방문한 점 찍기
                    nx += dx[dirs[g].get(d)];
                    ny += dy[dirs[g].get(d)];
                    map[ny][nx] = 1;
                }

            }
        }
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int flag = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1]; // 방문 점이 4개이면 정사각형
                if (flag == 4) result++;
            }
        }
        System.out.println(result);
    }

    static class Dcurve {
        int x, y, d, g;

        public Dcurve(int x, int y, int d, int g) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }
}
//0
//1
//2 1
//2 3 2 1
//2 3 0 3 2 3 2 1
//2 3 0 3 0 1 0 3 2 3 0 3 2 3 2 1