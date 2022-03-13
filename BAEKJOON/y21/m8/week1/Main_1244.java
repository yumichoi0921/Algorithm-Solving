package BAEKJOON.y21.m8.week1;

import java.util.Scanner;

public class Main_1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sw = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sw[i] = sc.nextInt();
        }

        int student = sc.nextInt();
        for (int i = 1; i <= student; i++) {
            int gen = sc.nextInt();
            int num = sc.nextInt();

            if (gen == 1) {
                for (int j = num; j <= N; j += num) {
                    sw[j] = sw[j] == 0 ? 1 : 0;
                }
            } else if (gen == 2) {
                int l = num - 1, r = num + 1;
                while (true) {
                    if (l < 1 || r > N) break;
                    if (sw[l] != sw[r]) break;
                    l--;
                    r++;
                }
                for (int j = l + 1; j <= r - 1; j++) {
                    if (sw[j] == 0) {
                        sw[j] = 1;
                    } else if (sw[j] == 1) {
                        sw[j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(sw[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
