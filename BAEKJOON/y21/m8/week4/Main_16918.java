package BAEKJOON.y21.m8.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_16918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();

        char[][] arr = new char[R][C];
        int time = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'O') {
                    arr[i][j] = '3';
                } else {
                    arr[i][j] = '.';
                }
            }
        }

        List<int[]> bomb = new ArrayList<>();
        while (true) {
            time++;
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (arr[i][j] == '.') {
                            arr[i][j] = '3';
                        } else {
                            int v = arr[i][j];
                            arr[i][j] = (char) (v - 1);
                            if (arr[i][j] == '0') {
                                bomb.add(new int[]{i, j});
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (arr[i][j] != '.') {
                            int v = arr[i][j];
                            arr[i][j] = (char) (v - 1);
                            if (arr[i][j] == '0') {
                                bomb.add(new int[]{i, j});
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < bomb.size(); i++) {
                int r = bomb.get(i)[0];
                int c = bomb.get(i)[1];
                arr[r][c] = '.';
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] != '0') {
                        arr[nr][nc] = '.';
                    }
                }
            }

            bomb.clear();
            if (time == N) {
                break;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '.') {
                    System.out.print("O");
                } else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }
}

