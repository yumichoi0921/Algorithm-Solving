//package BAEKJOON.september.week5;
//
//import java.util.Scanner;
//
//public class Main_11050 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int K = sc.nextInt();
//
//        long result = nCk(N, K);
//    }
//
//    private static long nCk(int n, int k) {
//        if (k==0) return 1;
//        long[] fac = new long[n+1];
//        fac[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            fac[i] = fac[i-1]*i;
//        }
//
//    }
//}
