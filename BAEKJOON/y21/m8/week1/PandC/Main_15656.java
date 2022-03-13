package BAEKJOON.y21.m8.week1.PandC;

import java.util.Arrays;
import java.util.Scanner;

// 수열
// n개중 중복 있이 r개 뽑기
// r개는 순서 O

public class Main_15656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[k];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sequence(arr, ans, 0, 0, sb);
        System.out.println(sb);

    }

    private static void sequence(int[] arr, int[] ans, int k, int idx, StringBuilder sb) {
        if (k == ans.length) {
            for (int i = 0; i < k; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            ans[k] = arr[i];
            sequence(arr, ans, k + 1, i, sb);

        }
    }
}
