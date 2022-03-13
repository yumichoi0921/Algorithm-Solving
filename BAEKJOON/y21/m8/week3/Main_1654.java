package BAEKJOON.y21.m8.week3;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();   // 가진 랜선 갯수
        int N = sc.nextInt();   // 만들어야 하는 랜선 갯수
        int[] line = new int[K];    // 가진 랜선 길이
        for (int i = 0; i < K; i++) {
            line[i] = sc.nextInt();
        }
        Arrays.sort(line);

        long maxLen = 0;
        long left = 1;
        long right = line[line.length - 1];
        long mid;
        while (left <= right) {
            int cnt = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < line.length; i++) {
                cnt += line[i] / mid;
            }

            if (cnt < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
                maxLen = Math.max(maxLen, mid);
            }
        }
        System.out.println(maxLen);

    }
}

