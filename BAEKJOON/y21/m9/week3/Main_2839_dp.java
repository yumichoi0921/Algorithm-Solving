package BAEKJOON.y21.m9.week3;

import java.util.Arrays;
import java.util.Scanner;

// 설탕배달
// greedy dfs dp
public class Main_2839_dp {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] bag = new int[]{0, 3, 5};

        res = 0;
        greedy(N);
        System.out.println(res);

        res = Integer.MAX_VALUE;
        recursive(N, bag, 0);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);

        res = 0;
        dp(N, bag);
        System.out.println(res);
    }

    private static void dp(int N, int[] bag) {
        int[] memo = new int[N + 1];   // 각 무게당 필요한 봉지 갯수
        Arrays.fill(memo, 10000);    // Integet.MAX_VALUE로 하면 밑에서 +1할 때 음수가 됨
        if (N >= 3) memo[3] = 1;
        if (N >= 5) memo[5] = 1;
        for (int i = 6; i < memo.length; i++) {
            memo[i] = Math.min(memo[i - 3] + 1, memo[i - 5] + 1);
        }

        if (memo[N] >= 10000)
            res = -1;
        else
            res = memo[N];
    }

    private static void recursive(int N, int[] bag, int cnt) {
        if (N == 0) {
            res = Math.min(res, cnt);
            return;
        } else if (N < 0) {
            return;
        }
        for (int i = 1; i < bag.length; i++) {
            recursive(N - bag[i], bag, cnt + 1);
        }
    }

    private static void greedy(int N) {
        while (N % 5 != 0) {
            N -= 3;
            res++;
        }
        if (N < 0) {
            res = -1;
        } else {
            if (N % 5 == 0) {
                res += N / 5;
            }
        }
    }
}
