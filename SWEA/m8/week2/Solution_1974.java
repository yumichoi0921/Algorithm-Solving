package SWEA.m8.week2;

import java.util.HashSet;
import java.util.Scanner;

public class Solution_1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            HashSet<Integer> R = new HashSet<>();
            HashSet<Integer> C = new HashSet<>();
            HashSet<Integer> S = new HashSet<>();

            int res = 1;
            int [][] game = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    game[i][j] = sc.nextInt();
                }
            }


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    C.add(game[i][j]);
                }
                if (C.size() != 9) res = 0;
                C.clear();
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    R.add(game[j][i]);
                }
                if (R.size() != 9) res = 0;
                R.clear();
            }

            int rs = 0, re;
            int cs = 0, ce;
            for (int k = 0; k < 9; k++) {
                re = rs+3;
                ce = cs+3;
                for (int i = rs; i < re; i++) {
                    for (int j = cs; j < ce; j++) {
                        S.add(game[i][j]);
                    }
                }
                if (S.size() != 9) res = 0;
                cs += 3;
                if (cs >= 9) {
                    cs = 0; rs += 3;
                }
                S.clear();
            }


            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
