package SWEA.m8.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _N__Solution_5644 {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int M = sc.nextInt();   // 총이동시간
            int A = sc.nextInt();   // BC의 개수

            // 0: 이동안함/ 1: 상/ 2: 우/ 3: 하/ 4: 좌
            int[] dc = {0, 0, 1, 0, -1};
            int[] dr = {0, -1, 0, 1, 0};
            int[][] a = new int[M+1][2];     // 시간에서 a의 위치 {c, r}
            a[0] = new int[]{1, 1};
            int[][] b = new int[M+1][2];     // 시간에서 b의 위치 {c, r}
            b[0] = new int[]{10, 10};

            for (int i = 1; i <= M; i++) {
                int dir = sc.nextInt();
                a[i][0] = a[i-1][0]+dc[dir];
                a[i][1] = a[i-1][1]+dr[dir];
            }
            for (int i = 1; i <= M; i++) {
                int dir = sc.nextInt();
                b[i][0] = b[i-1][0]+dc[dir];
                b[i][1] = b[i-1][1]+dr[dir];
            }

            //BC -> 0: c/ 1: r/ 2: 충전범위/ 3: 성능
            int[][] BC = new int[A][4];
            for (int i = 0; i < A; i++) {
                BC[i][0] = sc.nextInt();
                BC[i][1] = sc.nextInt();
                BC[i][2] = sc.nextInt();
                BC[i][3] = sc.nextInt();
            }


            for (int i = 1; i <= M; i++) {
                List<Integer> a_BCIdx = new ArrayList<>();
                List<Integer> b_BCIdx = new ArrayList<>();
                int da, db;
                for (int j = 0; j < BC.length; j++) {
                    da = Math.abs(a[i][0]-BC[j][0])+Math.abs(a[i][1]-BC[j][1]);
                    if (da <=BC[j][2]) {
                        a_BCIdx.add(j);
                    }
                    db = Math.abs(b[i][0]-BC[j][0])+Math.abs(b[i][1]-BC[j][1]);
                    if (db <=BC[j][2]) {
                        b_BCIdx.add(j);
                    }
                }
                calc(BC, a_BCIdx, b_BCIdx);


            }
        }
    }

    // a: 0 1
    // b: 1 3
    private static void calc(int[][] BC, List<Integer> a_BCIdx, List<Integer> b_BCIdx) {
        if (a_BCIdx.size() == 0 && b_BCIdx.size() == 0) {
            return;
        }
        if (a_BCIdx.size() == 0 ){

        }
    }
}
