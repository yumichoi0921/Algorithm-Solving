package JungOl.m8.week1;

import java.util.Scanner;

public class Main_1329 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N < 1 || N > 100 || N%2 == 0) {
            System.out.println("INPUT ERROR!");
        } else {
            for (int i = 0; i < N; i++) {
                if (i <= N/2) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j <2*i+1 ; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                } else {
                    for (int j = 0; j < N-1-i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j <2*(N-1-i)+1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
    }
}
