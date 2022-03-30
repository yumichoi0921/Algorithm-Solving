// 피로도
package BAEKJOON.y22.m3.w1;

import java.util.Scanner;

public class Main_22864 {
    static int A;
    static int B;
    static int C;
    static int M;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();   // 피로도 증가
        B = sc.nextInt();   // 일 감소
        C = sc.nextInt();   // 피로도 감소
        M = sc.nextInt();   // 최대 피로도

        answer = 0;
        // dfs로 해당 시간에 일을 했을때와/쉬었을때 탐색
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int hour, int nowM, int nowWork) {
        // 피로도가 M을 넘으면 돌아가서 다른 가지 탐색
        if (nowM > M) return;
        // 피로도가 음수면 0으로 초기화
        if (nowM < 0) nowM = 0;

        // 24시간 되었을 때
        if (hour == 24) {
            // 최대로 많이 한 일 저장
            answer = Integer.max(answer, nowWork);
            return;
        }

        // 한시간 일했을 때
        dfs(hour + 1, nowM + A, nowWork + B);
        // 한시간 쉬었을 때
        dfs(hour + 1, nowM - C, nowWork);
    }
}
