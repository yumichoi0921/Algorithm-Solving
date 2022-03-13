package SWEA.m8.week2;

import java.util.Scanner;

public class Solution__9229 {
    static int maxWeight;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();   // 과자봉지 개수
            int M = sc.nextInt();   // 무게 합 제한

            int [] weight = new int[N];
            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
            }

            maxWeight = 0;
            pick(weight, new int[2], M, 0, 0);

            if (maxWeight == 0) maxWeight = -1;
            System.out.printf("#%d %d\n", tc, maxWeight);
        }
    }

    private static void pick(int[] weight, int[] sel, int limit, int idx, int k) {
        if (k == 2) {
            int tempWeight = sel[0]+sel[1];
            if (tempWeight <= limit) {
                maxWeight = Math.max(maxWeight, sel[0]+sel[1]);
            }
            return;
        }

        for (int i = idx; i < weight.length; i++) {
            sel[k] = weight[i];
            pick(weight, sel, limit, i+1,k+1);
        }
    }
}
