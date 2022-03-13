package BAEKJOON.y21.m11.week3;

import java.util.Arrays;
import java.util.Scanner;
// 파티
// 플로이드 워샬
public class Main_1238 {
    static int N, M, X;
    static int[][] adjMatrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt()-1;
        adjMatrix = new int[N][N];

        for (int i = 0; i < M; i++) {
          adjMatrix[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i==k || j==k || i==j) continue;
                    if (adjMatrix[i][k] != 0 && adjMatrix[k][j] !=0) {
                        if (adjMatrix[i][j] == 0) adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
                        else adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (i==X) continue;
            max = Math.max(max, adjMatrix[i][X]+adjMatrix[X][i]);
        }
        System.out.println(max);
    }

}
