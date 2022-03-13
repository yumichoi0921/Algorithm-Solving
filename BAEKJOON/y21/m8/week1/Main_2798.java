package BAEKJOON.y21.m8.week1;

import java.util.Scanner;

public class Main_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }

        int diff = Integer.MAX_VALUE;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if ((i != j) && (j != k) && (j != k)) {
                        sum = card[i] + card[j] + card[k];
                        if (sum <= M && M - sum < diff) {
                            result = sum;
                            diff = M - sum;
                        }
                    }
                }
            }
        }
        System.out.println(result);


    }

}
