// 블랙잭
// 완전탐색 - 조합
package BAEKJOON.y22.m3.w1;

import java.util.Scanner;

public class Main_2798 {
    static int N;
    static int M;
    static int[] card;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        card = new int[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }

        combi(0, 0, 0); // 조합으로 N개중에 3개 고르기
        System.out.println(answer);
    }

    private static void combi(int idx, int cnt, int sum) {
        if (sum > M) return;
        if (cnt == 3) {
            answer = Integer.max(answer, sum);
            return;
        }
        // 여기에 있어야 하는 반례
//        if (idx == N) return;
//        3 10
//        1 2 3
//        combi(idx + 1, cnt + 1, sum + card[idx]);
//        combi(idx + 1, cnt, sum);
        for (int i = idx; i < N; i++) {
            combi(i + 1, cnt + 1, sum + card[i]);
        }
    }
}
