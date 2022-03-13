package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] game = new int[5][5];
        int[] call = new int[25];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                game[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 25; i++) {
            call[i] = sc.nextInt();
        }

        int idx = 0;
        while (idx < 25) {
            if (check(game, call[idx])) {
                System.out.println(idx + 1);
                break;
            }
            idx++;
        }
    }

    private static boolean check(int[][] game, int call) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (game[i][j] == call) game[i][j] = 0;
            }
        }

        int Rzero = 0, Czero = 0, Drzero = 0, Dlzero = 0, cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (game[i][j] == 0) Czero++;
                if (game[j][i] == 0) Rzero++;
            }
            if (Czero == 5) cnt++;
            if (Rzero == 5) cnt++;
            if (game[i][i] == 0) Drzero++;
            if (game[i][4 - i] == 0) Dlzero++;
            Czero = 0;
            Rzero = 0;
        }
        if (Drzero == 5) cnt++;
        if (Dlzero == 5) cnt++;

        if (cnt >= 3) return true;
        else return false;
    }
}
