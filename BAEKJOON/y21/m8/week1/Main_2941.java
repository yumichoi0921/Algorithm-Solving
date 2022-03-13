package BAEKJOON.y21.m8.week1;

import java.util.Scanner;

public class Main_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        S = S.replace("c=", "0");
        S = S.replace("c-", "0");
        S = S.replace("dz=", "0");
        S = S.replace("d-", "0");
        S = S.replace("lj", "0");
        S = S.replace("nj", "0");
        S = S.replace("s=", "0");
        S = S.replace("z=", "0");
        System.out.println(S.length());
    }
}
