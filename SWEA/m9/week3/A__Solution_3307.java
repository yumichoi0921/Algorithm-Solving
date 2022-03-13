package SWEA.m9.week3;

import java.util.Scanner;
// 최장 증가 수열
public class A__Solution_3307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 수열 길이
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int[] lis = new int[N];
            int result = 1;
            for (int i = 0; i < N; i++) {
                lis[i] = 1;
                for (int j = 0; j <= i-1; j++) {
                    if (arr[j] < arr[i] && lis[i] < lis[j]+1) {
                        lis[i] = lis[j]+1;
                        result = Math.max(result, lis[i]);
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
