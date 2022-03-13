package SWEA.m8.week2;

import java.util.Scanner;

public class Solution_6730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int[] block = new int[N];
            for (int i = 0; i < N; i++) {
                block[i] = sc.nextInt();
            }

            int maxUP = 0;
            int maxDown = 0;

            for (int i = 0; i < N; i++) {
                if (i == 0) continue;
                if (block[i-1] < block[i]) {
                    maxUP = Math.max(maxUP, block[i]-block[i-1]);
                } else if(block[i-1] > block[i]) {
                    maxDown = Math.max(maxDown, block[i-1]-block[i]);
                }
            }
            System.out.printf("#%d %d %d\n", tc, maxUP, maxDown);
        }
    }
}
