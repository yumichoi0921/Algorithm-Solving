package BAEKJOON.y21.m10.week1;

import java.util.Scanner;

// 퇴사
// dp
public class Main_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] T = new int[N]; // 시간
        int[] P = new int[N]; // 이익
        for (int i = 0; i < N; i++) {
            T[i]= sc.nextInt();
            P[i] = sc.nextInt();
        }

        int[] memo = new int[N+1];
        for (int day = N-1; day >= 0; day--) {
            if (day+T[day] > N) {
                memo[day] = memo[day+1];
            } else {
                memo[day] = Math.max(memo[day+1], P[day]+memo[day+T[day]]);
            }
        }
        System.out.println(memo[0]);
    }
}
// 1 2 3 4 5 6 7 8 9 10
// 1 1 1 1 1 1 1 1 1 1
// 1 2 3 4 5 6 7 8 9 10