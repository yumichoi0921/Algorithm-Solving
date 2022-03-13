package SWEA.m8.week3;

import java.util.Scanner;
// 최적경로-순열
public class Solution_1247 {
    static int res;
    static  int[] company;
    static  int[] house;
    static  int[][] customer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 고객의 수
            company = new int[]{sc.nextInt(), sc.nextInt()};   // 회사 좌표
            house = new int[]{sc.nextInt(), sc.nextInt()}; // 집 좌표
            customer = new int[N][2];   // 고객 좌표
            for (int i = 0; i < N; i++) {
                customer[i][0] = sc.nextInt();
                customer[i][1] = sc.nextInt();
            }

            res = Integer.MAX_VALUE;
            permutation(new boolean[N], new int[N], N, 0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    private static void permutation(boolean[] isSelected, int[] customerIdx, int N, int idx) {
        if (idx == N) {
            int distance = 0;
            distance += Math.abs(company[0] - customer[customerIdx[0]][0])+Math.abs(company[1] - customer[customerIdx[0]][1]);
            for (int i = 0; i < customerIdx.length; i++) {
                int cusIdx = customerIdx[i];
                if (i == customerIdx.length-1) {
                    distance += Math.abs(customer[cusIdx][0]- house[0]) + Math.abs(customer[cusIdx][1]- house[1]);
                } else {
                    int nextCusIdx = customerIdx[i+1];
                    distance += Math.abs(customer[cusIdx][0]- customer[nextCusIdx][0]) + Math.abs(customer[cusIdx][1]- customer[nextCusIdx][1]);
                }
            }
            res = Math.min(res, distance);
            return;
        }

        for (int i = 0; i < customer.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                customerIdx[idx] = i;
                permutation(isSelected, customerIdx, N, idx+1);
                isSelected[i] = false;
            }
        }
    }
}
