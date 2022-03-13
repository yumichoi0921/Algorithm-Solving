package BAEKJOON.y21.m8.week3;

import java.util.Scanner;

public class Main_10163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 색종이 장수
        int[][] plane = new int[1001][1001]; // 바탕
        int[][] paper = new int[N + 1][4];  // 색종이
        int[] area = new int[N + 1];    // 색종이 넓이
        for (int i = 1; i <= N; i++) {
            paper[i][0] = sc.nextInt(); // 왼쪽 아래 위치 min x
            paper[i][1] = sc.nextInt(); // 왼쪽 아래 위치 min y
            paper[i][2] = sc.nextInt(); // 너비
            paper[i][3] = sc.nextInt(); // 높이
        }

        for (int i = 1; i <= N; i++) {
            for (int j = paper[i][0]; j < paper[i][0] + paper[i][2]; j++) {
                for (int k = paper[i][1]; k < paper[i][1] + paper[i][3]; k++) {
                    plane[j][k] = i;
                }
            }
        }

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                area[plane[i][j]]++;
            }
        }

        for (int i = 1; i < area.length; i++) {
            System.out.println(area[i]);
        }

    }
}
