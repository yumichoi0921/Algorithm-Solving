package BAEKJOON.y21.m8.week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _N__Main_1038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = 11;
        int cnt = 10;
        if (N <= 10) {
            System.out.println(N);
        } else if (N > 1022) {
            System.out.println(-1);
        } else {
            while (true) {
                int tmp = num;
                if (check3(tmp)) {
                    cnt++;
                    if (cnt == N) {
//                System.out.println(cnt+"번째 감소하는 수 " +num);
                        System.out.println(num);
                        break;
                    }
                    num++;
                } else {
                    num = num + 10 - (num % 10);
                }
            }
        }
    }

    private static boolean check3(int tmp) {
        Queue<Integer> Q = new LinkedList<>();
        while (tmp > 0) {
            Q.add(tmp % 10);
            tmp = tmp / 10;
        }
        while (Q.size() > 1) {
            int n1 = Q.poll();
            int n2 = Q.peek();
            if (n1 >= n2) {
                return false;
            }
        }
        return true;
    }

//    private static boolean check(int n2, int n1) {
//        if (n2 < 10) {
//            if (n2 > n1) return true;
//        } else {
//            if (n2%10 > n1) {
//                check(n2/10, n2%10);
//            } else return false;
//        }
//        return false;
//    }

}
