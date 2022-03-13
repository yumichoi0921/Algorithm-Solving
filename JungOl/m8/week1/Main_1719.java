package JungOl.m8.week1;

import java.util.Scanner;

public class Main_1719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] star = new char[n][n];

        if (!(n>=1 && n<=100) || !(n%2==1)) {
            System.out.println("INPUT ERROR!");
        } else if (!(m>=1 && m<=4)) {
            System.out.println("INPUT ERROR!");
        } else if (m == 1) {
            for (int i = 1; i <= n; i++) {
                if (i <= n/2) {
                    for (int j = 1; j <= i ; j++) {
                        System.out.print("*");
                    }
                } else {
                    for (int j = 1; j <= n-i+1; j++) {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
        } else if (m == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n/2; j++) {
                    if (i<=n/2){
                        if (j>=n/2-i) System.out.print("*");
                        else System.out.print(" ");
                    } else {
                        if (j>=i-n/2) System.out.print("*");
                        else System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else if (m == 3) {
            for (int i = 0; i < n; i++) {
                if (i <= n / 2) {
                    for (int j = 0; j < n-i; j++) {
                        if (j >= i) System.out.print("*");
                        else System.out.print(" ");
                    }
                } else {
                    for (int j = 0; j <= i; j++) {
                        if (j < n-i-1) System.out.print(" ");
                        else System.out.print("*");
                    }
                }
                System.out.println();
            }
        } else if (m == 4) {
            for (int i = 0; i < n; i++) {
                if (i<=n/2) {
                    for (int j = 0; j <= n/2; j++) {
                        if (j < i) System.out.print(" ");
                        else System.out.print("*");
                    }
                } else {
                    for (int j = 0; j <= i; j++) {
                        if (j < n/2) System.out.print(" ");
                        else System.out.print("*");
                    }
                }
                System.out.println();

            }
        }
    }
}
