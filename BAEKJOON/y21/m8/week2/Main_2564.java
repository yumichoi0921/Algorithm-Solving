package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_2564 {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int R = sc.nextInt();
        int N = sc.nextInt();
        int[][] position = new int[N + 1][3];

        for (int i = 0; i <= N; i++) {
            int dir = sc.nextInt();
            int dis = sc.nextInt();
            position[i][0] = dir;
            if (dir == 1) { // 북
                position[i][1] = 0;
                position[i][2] = dis;
            } else if (dir == 2) {   //남
                position[i][1] = R;
                position[i][2] = dis;
            } else if (dir == 3) {   //서
                position[i][1] = dis;
                position[i][2] = 0;
            } else if (dir == 4) {   // 동
                position[i][1] = dis;
                position[i][2] = C;
            }
        }
        int Xdir = position[N][0];
        int xR = position[N][1];
        int xC = position[N][2];

        res = 0;
        for (int i = 0; i < N; i++) {
            int Sdir = position[i][0];
            int sR = position[i][1];
            int sC = position[i][2];
            if (Math.abs(sR - xR) == R || Math.abs(sC - xC) == C) { // 서로 반대 방향
                if (Xdir == 1 || Xdir == 2) {
                    res += Math.min(xC + R + sC, C - xC + R + C - sC);
                } else {
                    res += Math.min(xR + C + sR, R - xR + C + R - sR);
                }
            } else if (Sdir == Xdir) {    // 서로 같은 방향
                if (Xdir == 1 || Xdir == 2) {
                    res += Math.abs(xC - sC);
                } else {
                    res += Math.abs(xR - sR);
                }
            } else {    // 서로 인접한 방향
                if (Xdir == 1) {
                    if (Sdir == 3) res += xC + sR;
                    else if (Sdir == 4) res += (C - xC) + sR;
                } else if (Xdir == 2) {
                    if (Sdir == 3) res += xC + (R - sR);
                    else if (Sdir == 4) res += (C - xC) + (R - sR);
                } else if (Xdir == 3) {
                    if (Sdir == 1) res += xR + sC;
                    else if (Sdir == 2) res += (R - xR) + sC;
                } else if (Xdir == 4) {
                    if (Sdir == 1) res += xR + (C - sC);
                    else if (Sdir == 2) res += (R - xR) + (C - sC);
                }
            }
        }
        System.out.println(res);
    }


}
