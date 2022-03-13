package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_16935 {
    static int[][] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int r = 0; r < R; r++) {
            N = arr.length - 1;
            M = arr[0].length - 1;
            res = new int[N + 1][M + 1];
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    for (int i = 1; i <= N; i++) {
                        res[N + 1 - i] = arr[i];
                    }
                    break;
                case 2:
                    for (int i = 1; i <= N; i++) {
                        for (int j = 1; j <= M; j++) {
                            res[i][j] = arr[i][M + 1 - j];
                        }
                    }
                    break;
                case 3:
                    res = new int[M + 1][N + 1];
                    for (int i = 1; i <= M; i++) {
                        for (int j = 1; j <= N; j++) {
                            res[i][j] = arr[N + 1 - j][i];
                        }
                    }
                    break;
                case 4:
                    res = new int[M + 1][N + 1];
                    for (int i = 1; i <= M; i++) {
                        for (int j = 1; j <= N; j++) {
                            res[i][j] = arr[j][M + 1 - i];
                        }
                    }
                    break;
                case 5:
                    for (int i = 1; i <= N; i++) {
                        for (int j = 1; j <= M; j++) {
                            if (i >= 1 && i <= N / 2 && j >= 1 && j <= M / 2) { // 4->1
                                res[i][j] = arr[i + N / 2][j];
                            } else if (i >= 1 && i <= N / 2 && j >= (M / 2) + 1 && j <= M) {  // 1->2
                                res[i][j] = arr[i][j - M / 2];
                            } else if (i >= (N / 2) + 1 && i <= N && j >= (M / 2) + 1 && j <= M) {  // 2->3
                                res[i][j] = arr[i - N / 2][j];
                            } else if (i >= (N / 2) + 1 && i <= N && j >= 1 && j <= M / 2) {  // 3->4
                                res[i][j] = arr[i][j + M / 2];
                            }
                        }
                    }
                    break;
                case 6:
                    for (int i = 1; i <= N; i++) {
                        for (int j = 1; j <= M; j++) {
                            if (i >= 1 && i <= N / 2 && j >= 1 && j <= M / 2) { //2->1
                                res[i][j] = arr[i][j + M / 2];
                            } else if (i >= 1 && i <= N / 2 && j >= (M / 2) + 1 && j <= M) {    // 3->2
                                res[i][j] = arr[i + N / 2][j];
                            } else if (i >= (N / 2) + 1 && i <= N && j >= (M / 2) + 1 && j <= M) {  // 4->3
                                res[i][j] = arr[i][j - M / 2];
                            } else if (i >= (N / 2) + 1 && i <= N && j >= 1 && j <= M / 2) {    // 1->4
                                res[i][j] = arr[i - N / 2][j];
                            }
                        }
                    }
                    break;
            }
            arr = res;
        }

        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}
