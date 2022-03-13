package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_5215_subset {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int L = sc.nextInt();

            int[][] ingredient = new int[N][2]; // 0: 맛, 1: 칼로리
            for (int i = 0; i < N; i++) {
                ingredient[i][0] = sc.nextInt();
                ingredient[i][1] = sc.nextInt();
            }
            res = 0;
            powerSet(ingredient, new boolean[N], L, 0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

//    private static void powerSet(int[][] ingredient, boolean[] sel, int limitCal, int sumCal, int idx) {
//        if (idx == ingredient.length) {
//            if (sumCal <= limitCal) {
//                int sumFlavor = 0;
//                for (int i = 0; i < sel.length; i++) {
//                    if (sel[i]) sumFlavor += ingredient[i][0];
//                }
//                res = Math.max(res, sumFlavor);
//            }
//            return;
//        }
//        sel[idx] = true;
//        powerSet(ingredient, sel, limitCal, sumCal + ingredient[idx][1], idx + 1);
//
//        sel[idx] = false;
//        powerSet(ingredient, sel, limitCal, sumCal, idx + 1);
//    }

    private static void powerSet(int[][] ingredient, boolean[] sel, int limitCal, int idx) {
        if (idx == ingredient.length) {
            int sumCal = 0;
            int sumFlavor=0;
            for (int i = 0; i < sel.length; i++) {
                if (sel[i] == true) {
                    sumFlavor += ingredient[i][0];
                    sumCal += ingredient[i][1];
                }
            }
            if (sumCal <= limitCal) {
                res = Math.max(res, sumFlavor);
            }
            return;
        }
        sel[idx] = true;
        powerSet(ingredient, sel, limitCal, idx + 1);

        sel[idx] = false;
        powerSet(ingredient, sel, limitCal, idx + 1);
    }

}
