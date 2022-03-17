//피보나치 수5
// dp
package BAEKJOON.y22.m3.week2;

import java.util.Scanner;

public class Main_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] map = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            if (i >= 2) map[i] = map[i - 1] + map[i - 2];
            else map[i] = i;
        }
        System.out.println(map[N]);

    }
}
