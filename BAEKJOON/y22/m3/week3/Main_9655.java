// 돌게임
// dp
package BAEKJOON.y22.m3.week3;

import java.util.Scanner;

public class Main_9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] dp = new String[N + 1];    // 돌이 idx개 남았을 때 가져간 사람
        int idx = N;    // N부터 시작
        String[] turn = {"SK", "CY"};   // 순서
        int t = 0;      // 상근부터 시작
        while (idx > 0) {
            if (idx - 3 >= 0) { // 3개를 가져갈 수 있을 때까지 3개를 가져감
                dp[idx - 3] = turn[t];  // idx-3개 남았고 그때 가져간 사람 저장
                idx = idx - 3;          // 남은 돌의 갯수
            } else if (idx - 1 >= 0) {  // 3을 가져갈 수 없다면 즉 남은 돌이 3개보다 적다면 1개를 가져감
                dp[idx - 1] = turn[t];
                idx = idx - 1;
            }
            t = (t + 1) % 2;    // 한명 가져갈 때마다 순서 바꾸기
        }
        System.out.println(dp[0]);
    }
}
