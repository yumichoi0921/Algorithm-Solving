package BAEKJOON.y21.m8.week3;

import java.util.Scanner;

public class Main_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sum = 0;
        int res = 0;

        if (N % 5 == 0) {
            res = N / 5;
        } else {
            int a = (N / 5) + 1;
            int b = 0;
            res = a + b;
            while (a >= 0) {
                sum = 5 * a + 3 * b;

                if (sum == N) {
                    res = a + b;
                    break;
                }
                if (a == 0) {
                    res = -1;
                    break;
                }
                res = a + b;
                a--;
                if ((N - 5 * a) % 3 == 0) {
                    b = (N - 5 * a) / 3;
                } else {
                    b = (N - 5 * a) / 3 + 1;
                }
            }
        }
        System.out.println(res);

    }
}
