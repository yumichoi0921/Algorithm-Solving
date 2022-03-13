package BAEKJOON.y21.m8.week1;

import java.util.Scanner;

public class Main_1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 사람 수
        int M = sc.nextInt();   // 한 사람이 공을 받을 수 있는 갯수
        int L = sc.nextInt();   // 이동 칸

        int[] person = new int[N];
        int turn = 0;
        person[turn]++;
        int cnt = 0;
        while (true) {
            if (person[turn] == M) break;

            if (person[turn] % 2 == 1) {
                if (turn + L >= N) turn = (turn + L + N) % N;
                else turn = turn + L;
            } else if (person[turn] % 2 == 0) {
                if (turn - L < 0) turn = (turn - L + N) % N;
                else turn = turn - L;
            }
            person[turn]++;
            cnt++;
        }

        System.out.println(cnt);
    }
}
