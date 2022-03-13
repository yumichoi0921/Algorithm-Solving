package BAEKJOON.y21.m8.week1.PandC;

import java.util.Scanner;

// 수열
// n개중 중복 없이 r개 뽑기
// 수열
public class Main_15649 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[k];
        boolean[] visited;
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permutation(arr, ans, new boolean[n], 0);
    }

    private static void permutation(int[] arr, int[] ans, boolean[] visited, int k) {
        // base part
        if (k == ans.length) {
            for (int i = 0; i < k; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false) {
                ans[k] = arr[i];
                visited[i] = true;
                permutation(arr, ans, visited, k + 1);
                visited[i] = false;
            }
        }
    }
}
