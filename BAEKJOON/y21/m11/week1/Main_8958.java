package BAEKJOON.y21.m11.week1;

import java.util.Scanner;
// OX퀴즈
public class Main_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            int[] score = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'X') {
                    score[i] = 0;
                } else {
                    if (i==0) score[i] = 1;
                    else score[i] = score[i-1]+1;
                }
            }

            int result = 0;
            for (int i = 0; i < score.length; i++) {
                result += score[i];
            }
            System.out.println(result);
        }

    }
}
