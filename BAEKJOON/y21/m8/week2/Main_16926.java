package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_16926 {

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

        int[] dr = {};
        int[] dc = {};
        for (int r = 0; r < R; r++) {
            int tN = N, tM = M;
            int st = 1;
            while (st < tN && st < tM) {
                int tmp = arr[st][st];
                for (int i = st; i < tM; i++) {
                    arr[st][i] = arr[st][i + 1];
                }
                for (int i = st; i < tN; i++) {
                    arr[i][tM] = arr[i + 1][tM];
                }
                for (int i = tM; i > st; i--) {
                    arr[tN][i] = arr[tN][i - 1];
                }
                for (int i = tN; i > st; i--) {
                    arr[i][st] = arr[i - 1][st];
                }
                arr[st + 1][st] = tmp;

                st++;
                tN--;
                tM--;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
