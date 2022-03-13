package BAEKJOON.y21.m9.week3;

import java.util.Arrays;
import java.util.Scanner;

// 플로이드 워샬
public class Main_11404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] bus = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(bus[i], 1000000 * n);
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt() - 1, d = sc.nextInt() - 1, e = sc.nextInt();
            bus[s][d] = Math.min(bus[s][d], e);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == k || j == k || i == j) continue;
                    bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bus[i][j] == 1000000 * n) bus[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(bus[i][j] + " ");
            }
            System.out.println();
        }
    }
}
