package BAEKJOON.y21.m8.week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> st = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            st.add(i - s, i + 1);
        }
        System.out.println(st.toString());

    }
}
