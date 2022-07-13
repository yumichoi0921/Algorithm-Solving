package BAEKJOON.y22.m6.w5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_17779 {
    static int N;
    static int[][] map;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        answer = 10000000;

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                List<int[]> borders = new LinkedList<>();
                // 가능한 길이 구하기
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (!(y - d1 >= 1 && y + d2 <= N && x + d1 + d2 <= N)) continue;
                        calculateArea(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(answer);

    }

    private static void calculateArea(int x, int y, int d1, int d2) {
        int[][] area = new int[N + 1][N + 1];
        int[] populations = new int[5];

        // 경계선
        for (int dd = 0; dd <= d1; dd++) {
            area[x + dd][y - dd] = 5;           //왼상
            area[x + d2 + dd][y + d2 - dd] = 5; // 우하
        }
        for (int dd = 0; dd <= d2; dd++) {
            area[x + dd][y + dd] = 5;       //우상
            area[x + d1 + dd][y - d1 + dd] = 5; //왼하
        }

        // 경계선으로 둘러싸인 5 구역
        for (int r = x + 1; r < x + d1 + d2; r++) {
            boolean start = false;
            for (int c = 1; c <= N; c++) {
                if (area[r][c] == 5 && !start) start = true;
                else if (area[r][c] == 5 && start) break;
                else if (start) area[r][c] = 5;


            }
        }
        // 5구역 인구 수
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (area[r][c] == 5) populations[0] += map[r][c];
            }
        }

        // 1구역 인구 수
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                if (area[r][c] == 5) break;
                populations[1] += map[r][c];
                area[r][c] = 1;
            }
        }
        // 2구역 인구 수
        for (int r = 1; r <= x + d2; r++) {
            for (int c = N; c > y; c--) {
                if (area[r][c] == 5) break;
                populations[2] += map[r][c];
                area[r][c] = 2;
            }
        }
        // 3구역 인구 수
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (area[r][c] == 5) break;
                populations[3] += map[r][c];
                area[r][c] = 3;
            }
        }
        // 4구역 인구 수
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = N; c >= y - d1 + d2; c--) {
                if (area[r][c] == 5) break;
                populations[4] += map[r][c];
                area[r][c] = 4;
            }
        }

        int max = 0;
        int min = 100000;
        for (int i = 0; i < populations.length; i++) {
            min = Math.min(min, populations[i]);
            max = Math.max(max, populations[i]);
        }

        answer = Math.min(answer, max - min);
    }
}

