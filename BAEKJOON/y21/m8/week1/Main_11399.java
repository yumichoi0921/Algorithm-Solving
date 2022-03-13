package BAEKJOON.y21.m8.week1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }

        Arrays.sort(time);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            sum += time[i];
            res += sum;
        }
        System.out.println(res);
    }
}
