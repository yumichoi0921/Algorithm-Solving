package BAEKJOON.y21.m8.week1.PandC;

import java.util.Scanner;

// 수열 -> n개중 r개 뽑기
// 중복 가능
// 순열
public class Main_15651 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[k];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        sequence(arr, ans, 0, sb);
        System.out.println(sb);
    }

    private static void sequence(int[] arr, int[] ans, int k, StringBuilder sb) {
        if (k == ans.length) {
            for (int i = 0; i < k; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            ans[k] = arr[i];
            sequence(arr, ans, k + 1, sb);
        }


    }
}
