package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] snail = new int [N][N];

            int num = 1;
            int r = 0, c = -1;
            int d = 1;
            int count = N;
            int iter = N;
            while (count>0) {
                for (int i = 0; i < count; i++) {
                    c = c+d;
                    snail[r][c] = num;
                    num++;
                }
                count--;
                for (int i = 0; i < count; i++) {
                    r = r+d;
                    snail[r][c] = num;
                    num++;
                }
                for (int i = 0; i < count; i++) {
                    c = c-d;
                    snail[r][c] = num;
                    num++;
                }
                count--;
                for (int i = 0; i < count; i++) {
                    r = r-d;
                    snail[r][c] = num;
                    num++;
                }
//                iter -= 2;
            }
            System.out.println("#"+tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d", snail[i][j]);
                }
                System.out.println();
            }
        }
    }
}
