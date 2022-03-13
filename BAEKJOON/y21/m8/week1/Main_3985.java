package BAEKJOON.y21.m8.week1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        char[] cake = new char[L + 1];
        Arrays.fill(cake, 'X');
        int N = sc.nextInt();

        int[][] audi = new int[N][2];
        int tempMax = -1;
        int expectedAudi = 0;
        for (int i = 0; i < N; i++) {
            audi[i][0] = sc.nextInt();
            audi[i][1] = sc.nextInt();
            if (tempMax < audi[i][1] - audi[i][0] + 1) {
                tempMax = audi[i][1] - audi[i][0] + 1;
                expectedAudi = i + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = audi[i][0]; j <= audi[i][1]; j++) {
                if (cake[j] == 'X') {
                    cake[j] = (char) ((i + 1) + '0');
                }
            }
        }

        int[] p = new int[N + 1];
        for (int i = 1; i <= L; i++) {
            if (cake[i] != 'X') {
                int idx = cake[i] - '0';
                p[idx]++;

            }
        }

        tempMax = 0;
        int realAudi = 0;
        for (int i = 1; i < p.length; i++) {
            if (tempMax < p[i]) {
                tempMax = p[i];
                realAudi = i;
            }
        }

        System.out.println(expectedAudi);
        System.out.println(realAudi);
    }
}
