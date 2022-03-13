package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_2001 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] region = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    region[i][j] = sc.nextInt();
                }
            }

            int deadFly = 0;
            for (int i = 0; i < N-M+1; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    int tmpDeadFly = 0;
                    for (int k = i; k < i+M; k++) {
                        for (int l = j; l < j+M; l++) {
                            tmpDeadFly += region[k][l];
                            deadFly = Math.max(tmpDeadFly, deadFly);
                        }
                    }
                }
            }
            System.out.printf("#%d %d \n", testCase, deadFly);
        }
    }
}
