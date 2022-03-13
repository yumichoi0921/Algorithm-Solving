package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] wPaper = new int[100][100];
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int l = sc.nextInt();
            int b = sc.nextInt();
            for (int j = 100 - b; j > 100 - b - 10; j--) {
                for (int k = l; k < l + 10; k++) {
                    wPaper[j][k] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (wPaper[i][j] == 1) res++;
            }
        }
        System.out.println(res);
    }
}
