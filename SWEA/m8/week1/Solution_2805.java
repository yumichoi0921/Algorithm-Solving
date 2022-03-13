package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String n = sc.next();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = n.charAt(j)-'0';
                }
            }

            int totalValue = 0;
            int s = N/2, e = N/2;
            for (int i = 0; i < N; i++) {
                for (int j = s; j <= e; j++) {
                    totalValue += farm[i][j];
                }
                if (i < N/2) {
                    s--; e++;
                } else {
                    s++; e--;
                }

            }

            System.out.printf("#%d %d\n", tc, totalValue);

        }
    }

}
