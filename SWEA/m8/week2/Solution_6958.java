package SWEA.m8.week2;

import java.util.Scanner;

public class Solution_6958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] solving = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    solving[i][j] = sc.nextInt();
                }
            }

            int tempSolving;
            int maxSolving = 0;
            int person = 0;
            for (int i = 0; i < N; i++) {
                tempSolving = 0;
                for (int j = 0; j < M; j++) {
                    if (solving[i][j] == 1) tempSolving++;
                }
                if (tempSolving > maxSolving ) {
                    maxSolving = tempSolving;
                    person = 1;
                } else if (tempSolving == maxSolving) {
                    person++;
                }
            }

            System.out.printf("#%d %d %d\n", tc, person, maxSolving);
        }
    }
}
