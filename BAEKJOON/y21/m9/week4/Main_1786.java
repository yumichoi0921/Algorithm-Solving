package BAEKJOON.y21.m9.week4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1786 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] text = sc.nextLine().toCharArray();
        char[] pattern = sc.nextLine().toCharArray();
        int[] pi = new int[pattern.length];
        for (int i = 1, j = 0; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        ArrayList<Integer> patterns = new ArrayList<>();
        for (int i = 0, j = 0; i < text.length; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (text[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    patterns.add(i + 2 - pattern.length);
                    j = pi[j];
                } else {
                    j++;
                }
            }
            // j == 0이면 j고정 i만 이동
        }
        System.out.println(patterns.size());
        for (int i = 0; i < patterns.size(); i++) {
            System.out.print(patterns.get(i) + " ");
        }


    }
}
