package BAEKJOON.y21.m8.week1.PandC;

import java.util.Scanner;

// n개중 중복 있이 r개 뽑기
// 비내림차순 정렬
public class Main_15652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[k];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        sequence(arr, ans, 0, 0);

    }

    private static void sequence(int[] arr, int[] ans, int idx, int k) {
        if (k == ans.length) {
            for (int i = 0; i < k; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            ans[k] = arr[i];
            sequence(arr, ans, i, k + 1);
        }


    }
}
