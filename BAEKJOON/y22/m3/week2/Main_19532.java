// 수학은 비대면강의입니다
// 완전탐색
package BAEKJOON.y22.m3.week2;

import java.util.Scanner;

public class Main_19532 {
    static int a, b, c, d, e, f;
    static int x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        f = sc.nextInt();

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (a * i + b * j == c && d * i + e * j == f) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
