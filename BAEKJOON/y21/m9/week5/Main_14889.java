package BAEKJOON.y21.m9.week5;

import java.util.ArrayList;
import java.util.Scanner;

// 스타트와 링크
// 조합
public class Main_14889 {
    static int N, result;
    static int[][] arr;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        result = Integer.MAX_VALUE;
        c = 0;
        combination(new boolean[N], 0, 0);
        System.out.println(result);
        System.out.println(c);
    }

    private static void combination(boolean[] sel, int start, int cnt) {
        if (cnt == N / 2) {
            c++;
            result = Math.min(result, check(sel));
            return;
        }

        for (int i = start; i < N; i++) {
            sel[i] = true;
            combination(sel, i + 1, cnt + 1);
            sel[i] = false;
        }
    }

    private static int check(boolean[] sel) {
        ArrayList<Integer> g1 = new ArrayList<>();
        ArrayList<Integer> g2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (sel[i]) g1.add(i);
            else g2.add(i);
        }

        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int a = g1.get(i);
                int b = g1.get(j);
                s1 += arr[a][b] + arr[b][a];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int a = g2.get(i);
                int b = g2.get(j);
                s2 += arr[a][b] + arr[b][a];
            }
        }
        return Math.abs(s1 - s2);
    }
}

