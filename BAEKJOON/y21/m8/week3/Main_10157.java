package BAEKJOON.y21.m8.week3;

import java.util.Scanner;

public class Main_10157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int R = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[R][C];

        int[] dc = {-1, 0, 1, 0};    // 상 우 하 좌
        int[] dr = {0, 1, 0, -1};
        if (K > R * C) {
            System.out.println("0");
            return;
        } else {
            int resX, resY;
            int num = 1;
            int x = R - 1, y = 0;
            int d = 0;
            while (true) {
                arr[x][y] = num;
                if (num == K) {
                    resX = y + 1;
                    resY = R - x;
                    break;
                }
                int tmpX = x + dc[d];
                int tmpY = y + dr[d];
                if (tmpX < 0 || tmpX >= C || tmpY < 0 || tmpY >= R || arr[tmpX][tmpY] != 0) {
                    d++;
                    if (d == 4) d = 0;
                    tmpX = x + dc[d];
                    tmpY = y + dr[d];
                }
                x = tmpX;
                y = tmpY;
                num++;
            }
            System.out.println(resX + " " + resY);
            // 어디가 잘못됐을까요........................................................
        }
    }
}
