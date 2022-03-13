package SWEA.m10.week5;

import javax.swing.*;
import java.util.Scanner;
// 2048 게임
public class Solution_6109 {
    static int N;
    static String type;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            type = sc.next();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            if (type.equals("up")) {
                moveUP();
            } else if (type.equals("down")) {
                moveDown();
            } else if (type.equals("left")) {
                moveLeft();
            } else if (type.equals("right")) {
                moveRight();
            }

            System.out.println("#"+tc);
            print();
        }
    }

    private static void moveLeft() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    for (int k = j+1; k < N; k++) {
                        if (map[i][k] != 0) {
                            map[i][j] = map[i][k];
                            map[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
//        print();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    for (int k = j; k < N-1; k++) {
                        map[i][k] = map[i][k+1];
                    }
                    map[i][N-1] = 0;
                }
                if (j+1 < N && map[i][j] == map[i][j+1]) {
                    map[i][j] *= 2;
                    map[i][j+1] = 0;
                }

            }
        }
    }

    private static void moveRight() {
        for (int i = 0; i < N; i++) {
            for (int j = N-1; j >= 0; j--) {
                if (map[i][j] == 0) {
                    for (int k = j-1; k >= 0; k--) {
                        if (map[i][k] != 0) {
                            map[i][j] = map[i][k];
                            map[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
//        print();

        for (int i = 0; i < N; i++) {
            for (int j = N-1; j >= 0; j--) {
                if (map[i][j] == 0) {
                    for (int k = j; k > 0; k--) {
                        map[i][k] = map[i][k-1];
                    }
                    map[i][0] = 0;
                }
                if (j-1 >= 0 && map[i][j] == map[i][j-1]) {
                    map[i][j] *= 2;
                    map[i][j-1] = 0;
                }

            }
        }
    }

    private static void moveDown() {
        for (int i = 0; i < N; i++) {
            for (int j = N-1; j >= 0; j--) {
                if (map[j][i] == 0) {
                    for (int k = j-1; k >= 0; k--) {
                        if (map[k][i] != 0) {
                            map[j][i] = map[k][i];
                            map[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = N-1; j >= 0; j--) {
                if (map[j][i] == 0) {
                    for (int k = j; k > 0; k--) {
                        map[k][i] = map[k-1][i];
                    }
                    map[0][i] = 0;
                }
                if (j-1 >= 0 && map[j][i] == map[j-1][i]) {
                    map[j][i] *= 2;
                    map[j-1][i] = 0;
                }

            }
        }
    }

    private static void moveUP() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[j][i] == 0) {
                    for (int k = j+1; k < N; k++) {
                        if (map[k][i] != 0) {
                            map[j][i] = map[k][i];
                            map[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[j][i] == 0) {
                    for (int k = j; k < N-1; k++) {
                        map[k][i] = map[k+1][i];
                    }
                    map[N-1][i] = 0;
                }
                if (j+1 < N && map[j][i] == map[j+1][i]) {
                    map[j][i] *= 2;
                    map[j+1][i] = 0;
                }

            }
        }
    }





    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }
}
