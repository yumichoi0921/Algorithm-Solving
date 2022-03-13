package BAEKJOON.y21.m9.week3;

import java.util.ArrayList;
import java.util.Scanner;

// 색종이 붙이기
// dfs
// 백트래킹
public class Main_17136 {
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[10][10];
        int[][] paper = new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}};    // 색종이 크기, 갯수
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) points.add(new Point(i, j));
            }
        }

//        long beforeTime = System.currentTimeMillis();
        result = 101;
        dfs(map, paper, points, new boolean[10][10], 0, 0);
        result = result == 101 ? -1 : result;
        System.out.println(result);
//        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
//        System.out.println("시간차이(m) : "+secDiffTime);

//        result = 101;
//        dfs2(map, paper, 0, 0, 0);
//        result = result==101? -1 : result;
//        System.out.println(result);
    }

    private static void dfs2(int[][] map, int[][] paper, int r, int c, int cnt) {
        if (r == 9 && c == 10) {
            result = Math.min(result, cnt);
            return;
        }
        if (cnt > result) { // 백트래킹
            return;
        }
        if (c == 10) {
            r += 1;
            c = 0;
        }
        if (map[r][c] == 1) {
            for (int p = 0; p < paper.length; p++) {
                if (paper[p][1] >= 5) continue;
                boolean flag = false;
                check:
                for (int i = r; i < r + paper[p][0]; i++) {
                    for (int j = c; j < c + paper[p][0]; j++) {
                        if (i >= 0 && i < 10 && j >= 0 && j < 10 && map[i][j] == 1) {
                            flag = true;
                            continue;
                        } else {
                            flag = false;
                            break check;
                        }
                    }
                }
                if (flag) {
                    for (int i = r; i < r + paper[p][0]; i++) {
                        for (int j = c; j < c + paper[p][0]; j++) {
                            map[i][j] = 0;
                        }
                    }
                    paper[p][1]++;
                    dfs2(map, paper, r, c + 1, cnt + 1);
                    for (int i = r; i < r + paper[p][0]; i++) {
                        for (int j = c; j < c + paper[p][0]; j++) {
                            map[i][j] = 1;
                        }
                    }
                    paper[p][1]--;
                }
            }
        } else {
            dfs2(map, paper, r, c + 1, cnt);
        }
    }

    // 왜 모든 좌표 1일 때 더 시간 오래걸리는지?
    private static void dfs(int[][] map, int[][] paper, ArrayList<Point> points, boolean[][] v, int idx, int cnt) {
        if (cnt > result) { // 백트래킹
            return;
        }

        if (idx == points.size()) {
            result = Math.min(result, cnt);
            return;
        }

        int r = points.get(idx).r;
        int c = points.get(idx).c;
        if (!v[r][c]) {
            for (int p = 0; p < paper.length; p++) {
                if (paper[p][1] >= 5) continue;
                boolean flag = false;
                check:
                for (int i = r; i < r + paper[p][0]; i++) {
                    for (int j = c; j < c + paper[p][0]; j++) {
                        if (i >= 0 && i < 10 && j >= 0 && j < 10 && map[i][j] == 1 && !v[i][j]) {
                            flag = true;
                            continue;
                        } else {
                            flag = false;
                            break check;
                        }
                    }
                }
                if (flag) {
                    for (int i = r; i < r + paper[p][0]; i++) {
                        for (int j = c; j < c + paper[p][0]; j++) {
                            map[i][j] = 0;
                            v[i][j] = true;
                        }
                    }
                    paper[p][1]++;
                    dfs(map, paper, points, v, idx + 1, cnt + 1);
                    for (int i = r; i < r + paper[p][0]; i++) {
                        for (int j = c; j < c + paper[p][0]; j++) {
                            map[i][j] = 1;
                            v[i][j] = false;
                        }
                    }
                    paper[p][1]--;
                }
            }
        } else {
            dfs(map, paper, points, v, idx + 1, cnt);
        }
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}
