package SWEA.m9.week5;

import java.util.Scanner;

public class N__Solution_8458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] pos = new int[N][2];
            for (int i = 0; i < N; i++) {
                pos[i][0] = sc.nextInt();
                pos[i][1] = sc.nextInt();
            }

            int result = 0;
            int[] distance = new int[N];
            int maxD = Integer.MAX_VALUE;
            int check = 0;
            for (int i = 0; i < pos.length; i++) {
                int tmpD = Math.abs(pos[0][0]-0)+Math.abs(pos[0][1]-0);
                distance[i] = tmpD;
                if (i == 0) {
                    check = tmpD%2;
                    continue;
                }
                if (check == tmpD%2) {
                    maxD = Math.max(tmpD, tmpD);
                } else {
                    result = -1;
                    break;
                }
            }

            if (result != -1) {
                for (int i = 1; i <= maxD; i++) {
                    boolean flag = true;
                    for (int d = 0; d < distance.length; d++) {
                        if (distance[d] != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) break;
                    result++;
                    for (int d = 0; d < distance.length; d++) {
                        int cnt = 0;
                        while (cnt < i) {
                            distance[i]--;
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, result);



        }

    }
}

