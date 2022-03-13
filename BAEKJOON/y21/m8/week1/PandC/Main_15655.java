package BAEKJOON.y21.m8.week1.PandC;

import java.util.Arrays;
import java.util.Scanner;

// 수열
// n개중 중복 없이 r개 뽑기
// r개는 순서 X
// 오름차순 정렬
public class Main_15655 {
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
        sequence(arr, ans, 0, 0);

    }

    private static void sequence(int[] arr, int[] ans, int k, int idx) {
        if (k == ans.length) {
            for (int i = 0; i < k; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            ans[k] = arr[i];
            sequence(arr, ans, k + 1, i + 1);
        }
    }
}
