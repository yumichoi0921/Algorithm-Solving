package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_3040 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        combination(arr, new int[7], 0, 0);
    }

    private static void combination(int[] arr, int[] res, int start, int idx) {
        if (idx == res.length) {
            int sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum += res[i];
            }
            if (sum == 100) {
                res = res.clone();
                for (int i = 0; i < res.length; i++) {
                    System.out.println(res[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            res[idx] = arr[i];
            combination(arr, res, i + 1, idx + 1);
        }
    }
}
