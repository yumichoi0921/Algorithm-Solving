package BAEKJOON.y21.m9.week3;

import java.util.Arrays;
import java.util.Scanner;

// 일로만들기
// dp
public class A__Main_1463 {
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

//        result = Integer.MAX_VALUE;
//        dfs(N, 0);
//        System.out.println(result);
//
//
//        result = Integer.MAX_VALUE;
//        dp(N);
//        System.out.println(result);


        int[] memo = new int[N + 1];
        Arrays.fill(memo, 100000);
        memo[1] = 0;
        result = dfs_return(N, memo);
        System.out.println(result);

    }

    private static int dfs_return(int N, int[] memo) {
        if (N <= 1) return memo[N];

        // 모르겠다.

        return memo[N];
    }

    private static void dp(int N) {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, 100000);
        memo[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            int tmp = memo[i - 1] + 1;
            if (i % 3 == 0) {
                tmp = Math.min(tmp, memo[i / 3] + 1);
            }
            if (i % 2 == 0) {
                tmp = Math.min(tmp, memo[i / 2] + 1);
            }
            memo[i] = tmp;
        }
        result = memo[N];

    }


    private static void dfs(int N, int cnt) {
        if (N < 1) return;
        if (N == 1) {
            result = Math.min(result, cnt);
            return;
        }
        if (N % 3 == 0) {
            dfs(N / 3, cnt + 1);
        }
        if (N % 2 == 0) {
            dfs(N / 2, cnt + 1);
        }
        dfs(N - 1, cnt + 1);
    }

}
