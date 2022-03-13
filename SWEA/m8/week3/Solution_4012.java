package SWEA.m8.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_4012 {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] S = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    S[i][j] = sc.nextInt();
                }
            }
            res = Integer.MAX_VALUE;
            combination(S, new int[N/2], 0, 0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    private static void combination(int[][] s, int[] selIdx, int idx, int start) {
        if (idx == selIdx.length) {
            res = Math.min(res, calc(s, selIdx));
            return;
        }

        for (int i = start; i < s.length; i++) {
            selIdx[idx] = i;
            combination(s, selIdx, idx+1, i+1);
        }
    }

    private static int calc(int[][] s, int[] selIdx) {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        for (int i = 0; i < selIdx.length; i++) {
            s1.add(selIdx[i]);
        }
        for (int i = 0; i < s.length; i++) {
            if (!s1.contains(i)) s2.add(i);
        }

        int tmpS1 = 0, tmpS2 = 0;
        for (int i = 0; i < s.length/2; i++) {
            for (int j = 0; j < s.length/2; j++) {
                tmpS1 += s[s1.get(i)][s1.get(j)];
                tmpS2 += s[s2.get(i)][s2.get(j)];
            }
        }

        int flavor = Math.abs(tmpS1-tmpS2);
        s1.clear(); s2.clear();
        return flavor;
    }
}
