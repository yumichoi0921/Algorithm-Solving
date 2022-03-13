package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_2961 {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] ingredients = new int[N][2];
        for (int i = 0; i < N; i++) {
            ingredients[i][0] = sc.nextInt();   // 신맛
            ingredients[i][1] = sc.nextInt();   // 쓴맛
        }

        res = Integer.MAX_VALUE;
        subset(ingredients, new boolean[N], 0, 0);
        System.out.println(res);
    }

    private static void subset(int[][] ingredients, boolean[] isSelected, int idx, int cnt) {
        if (idx == ingredients.length) {
            if (cnt == 0) return;
            res = Math.min(res, cal(ingredients, isSelected));
            return;
        }

        isSelected[idx] = true;
        subset(ingredients, isSelected, idx + 1, cnt + 1);
        isSelected[idx] = false;
        subset(ingredients, isSelected, idx + 1, cnt);
    }

    private static int cal(int[][] ingredients, boolean[] isSelected) {
        int S = 1, B = 0;
        for (int i = 0; i < ingredients.length; i++) {
            if (isSelected[i]) {
                S *= ingredients[i][0];
                B += ingredients[i][1];
            }
        }
        return Math.abs(S - B);
    }
}
