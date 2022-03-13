package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_5215_combination {
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
            combination(ingredient, new int[N], L, 0, 0, 0);
//            combination(ingredient, new int[N], L, 0, 0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

//    private static void combination(int[][] ingredient, int[] sel, int limitCal, int sumCal, int idx) {
//
//        // 더 고를게 없을 때
////        if (idx==ingredient.length) {
////            return;
////        }
//        if (sumCal > limitCal) {
//            return;
//        }
//
//        if (idx == ingredient.length) {
//            int sumFlavor = 0;
//            for (int i = 0; i < idx; i++) {
//                sumFlavor += sel[i];
//            }
//            res = Math.max(res, sumFlavor);
//            return;
//        }
//
//        // 선택한 경우
//        sel[idx] = idx;
//        combination(ingredient, sel, limitCal, sumCal+ingredient[idx][1], idx+1);
//        // 안선택한 경우
//        combination(ingredient, sel, limitCal, sumCal, idx+1);
//
//    }

    private static void combination(int[][] ingredient, int[] sel, int limitCal, int sumCal, int k, int idx) {

        if (sumCal > limitCal) {
            int sumFlavor = 0;
            for (int i = 0; i < k-1; i++) {
                sumFlavor += sel[i];
            }
            res = Math.max(res, sumFlavor);
            return;
        }

        if (idx == ingredient.length) {
            int sumFlavor = 0;
            for (int i = 0; i < k; i++) {
                sumFlavor += sel[i];
            }
            res = Math.max(res, sumFlavor);
            return;
        }

        for (int i = idx; i < ingredient.length; i++) {
            sel[k] = ingredient[i][0];
            combination(ingredient, sel, limitCal, sumCal+ingredient[i][1], k+1, i+1);
//            if (sumCal+ingredient[i][0] < limitCal) {
//                sel[k] = ingredient[i][0];
//                combination(ingredient, sel, limitCal, sumCal+ingredient[i][1], k+1, i+1);
//            }
        }
    }
}
