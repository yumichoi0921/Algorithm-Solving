package BAEKJOON.y21.m8.week1;

import java.util.Scanner;

public class Main_8320 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;
        int squqre = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i * j <= n) {
                    if (i == j) {
                        squqre++;
                    } else {
                        result++;
                    }
                }
            }
        }

        result = (result / 2) + squqre;
        System.out.println(result);

    }
}
