package BAEKJOON.y21.m8.week4;

import java.util.Scanner;

public class Main_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 수학여행에 참가하는 학생 수
        int K = sc.nextInt();   // 한 방에 배정할 수 있는 최대 인원 수

        int[][] student = new int[6][2];    // 학년, (여, 남)
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();   // 성별 0:여 1: 남
            int Y = sc.nextInt();   // 학년
            student[Y - 1][S]++;
        }

        int res = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i][0] != 0) {
                res += student[i][0] / K;
                if (student[i][0] % K > 0) res++;
            }
            if (student[i][1] != 0) {
                res += student[i][1] / K;
                if (student[i][1] % K > 0) res++;
            }
        }
        System.out.println(res);

    }
}
