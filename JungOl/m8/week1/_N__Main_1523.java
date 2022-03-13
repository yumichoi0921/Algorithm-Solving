package JungOl.m8.week1;

import java.util.Scanner;

public class _N__Main_1523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (!(n >= 1 && n <= 100) ) {
            System.out.println("INPUT ERROR!");
        } else if (!(m >= 1 && m <= 3)){
            System.out.println("INPUT ERROR!");
        } else{
            if (m == 1) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else if(m == 2) {
                for (int i = n; i >= 1; i--) {
                    for (int j = n; j >= i; j--) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else if (m == 3) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n-i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= 2*i-1; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
    }
}
