package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_1859 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int[] price = new int[N];
            for (int i = 0; i < N; i++) {
                price[i] = sc.nextInt();
            }

            long totalValue = 0;
            int sellPrice = price[price.length-1];

            for (int i = price.length-1; i >= 0; i--) {
                if (price[i] < sellPrice) {
                    totalValue += sellPrice-price[i];
                } else if (price[i] > sellPrice) {
                    sellPrice = price[i];
                }
            }
            System.out.printf("#%d %d\n", tc, totalValue);
        }
    }
}
