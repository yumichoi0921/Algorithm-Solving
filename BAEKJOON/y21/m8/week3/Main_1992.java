package BAEKJOON.y21.m8.week3;

import java.util.Scanner;

public class Main_1992 {
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();
        search(arr, N, 0, 0);
        System.out.println(sb);
    }

    private static void search(int[][] arr, int N, int sr, int sc) {
        int b = 0, w = 0;
        for (int i = sr; i < sr + N; i++) {
            for (int j = sc; j < sc + N; j++) {
                if (arr[i][j] == 0) b++;
                else w++;
            }
        }
        if (b == N * N || w == N * N) { //  // 같은 색이라면
            sb.append(arr[sr][sc]);
            return;
        } else {    // 색이 섞여있다면
            sb.append("(");
            search(arr, N / 2, sr, sc);
            search(arr, N / 2, sr, sc + N / 2);
            search(arr, N / 2, sr + N / 2, sc);
            search(arr, N / 2, sr + N / 2, sc + N / 2);
            sb.append(")");
        }
    }
}
