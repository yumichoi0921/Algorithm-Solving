package BAEKJOON.y21.m8.week1;

import java.util.Scanner;

public class Main_2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.next();
        int N = message.length();
        int R = 0, C = 0;
        for (int c = 1; c <= N; c++) {
            for (int r = 1; r <= N; r++) {
                if (r * c == N && c >= r) {
                    if (r > R) {
                        R = r;
                        C = c;
                    }
                }
            }
        }

//        System.out.print(R +" " + C);
        int idx = 0;
        char[][] m = new char[R][C];
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                m[i][j] = message.charAt(idx);
                idx++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(m[i][j]);
            }
        }
    }
}
