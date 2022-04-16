package BAEKJOON.y22.m4.w3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_16235 {
    static int N, M, K;
    static int[][] map;
    static LinkedList<int[]> tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            tree.add(new int[]{sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()});
        }


    }
}
