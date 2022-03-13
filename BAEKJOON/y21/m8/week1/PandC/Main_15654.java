package BAEKJOON.y21.m8.week1.PandC;

import java.util.Arrays;
import java.util.Scanner;

// 수열
// n개중 중복 없이 r개 뽑기
// r개는 순서 O
// 오름차순 정렬
public class Main_15654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[k];
        boolean[] isVisited;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        sequence(arr, ans, new boolean[n], 0);

    }

    private static void sequence(int[] arr, int[] ans, boolean[] isVisited, int k) {
        if (k == ans.length) {
            for (int i = 0; i < k; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (isVisited[i] == false) {
                ans[k] = arr[i];
                isVisited[i] = true;
                sequence(arr, ans, isVisited, k + 1);
                isVisited[i] = false;
            }
        }
    }
}
