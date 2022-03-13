package BAEKJOON.y21.m8.week1;

import java.util.Scanner;
import java.util.Stack;

public class __N_Main_2493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> tops = new Stack<>();
        int[] topIdx = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tops.push(sc.nextInt());
        }

        Stack<Integer> raser = new Stack<>();
        Stack<Integer> tmp = new Stack<>();

        int nowTop = tops.pop();
        while (true) {
            if (tops.isEmpty()) {
                raser.push(0);
                if (!tmp.isEmpty()) {
                    tops.push(tmp.pop());
                } else {
                    break;
                }
            }
            if (nowTop < tops.peek()) {
                raser.push(tops.indexOf(tops.peek()) + 1);
                while (!tmp.isEmpty()) {
                    tops.push(tmp.pop());
                }
                nowTop = tops.pop();
            } else {
                tmp.push(tops.pop());
            }

        }

        while (!raser.isEmpty()) {
            System.out.print(raser.pop() + " ");
        }


//        int[] tops = new int[N];
//        for (int i = 0; i < N; i++) {
//            tops[i] = sc.nextInt();
//        }

//        int[] raser = new int[N];

//        for (int i = N-1; i >=0; i--) {
//            if (i>0) {
//                for (int j = i-1; j >=0 ; j--) {
//                    if (tops[j] > tops[i]) {
//                        raser[i] = j+1;
//                        break;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            System.out.printf("%d ",raser[i]);
//        }
//        System.out.println();
    }
}
