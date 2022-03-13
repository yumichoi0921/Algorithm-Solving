// 분해합
// 중복조합
package BAEKJOON.y22.m3.week2;

import java.util.Scanner;

public class Main_2231 {
    static int N;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int size = 1;
        int n = N;
        while (n / 10 > 0) {
            size++;
            n = n / 10;
        }

        answer = Integer.MAX_VALUE;
        combi(size, 0, new int[size]);
        combi(size - 1, 0, new int[size]);
        answer = answer == Integer.MAX_VALUE ? 0 : answer;
        System.out.println(answer);

    }

    private static void combi(int size, int idx, int[] selected) {
        if (idx == size) {
            int tempN = 0;
            for (int i = 0; i < selected.length; i++) {
                tempN += selected[i] * Math.pow(10, size - i - 1);
                tempN += selected[i];
            }
            if (tempN == N) {
                int newN = 0;
                for (int i = 0; i < selected.length; i++) {
                    newN += selected[i] * Math.pow(10, size - i - 1);
                }
                answer = Integer.min(answer, newN);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            selected[idx] = i;
            combi(size, idx + 1, selected);
        }
    }


}
