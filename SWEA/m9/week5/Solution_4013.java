package SWEA.m9.week5;

import java.util.Scanner;
// 특이한 자석
// 시뮬레이션
// 회전
public class Solution_4013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int K = sc.nextInt();
            int[][] magnet = new int[4][8];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = sc.nextInt();
                }
            }

            // idx 2와 6이 맞닿음
            for (int k = 0; k < K; k++) {
                int m =sc.nextInt()-1;          // m번 마그넷
                int[] rotation = new int[4];    // 자석마다 회전방향
                rotation[m] = sc.nextInt();
                int d;
                int left = magnet[m][6];        // 기준 자석 왼쪽 회전 여부
                d = rotation[m];
                for (int j = m-1; j >= 0; j--) {
                    int tmpR = magnet[j][2];
                    if (left != tmpR) {
                        d = -d;
                        rotation[j] = d;
                        left = magnet[j][6];
                    } else {
                        break;
                    }
                }
                int right = magnet[m][2];       // 기준 자석 오른쪽 회전 여부
                d = rotation[m];
                for (int j = m+1; j < 4; j++) {
                    int tmpL = magnet[j][6];
                    if (right != tmpL) {
                        d = -d;
                        rotation[j] = d;
                        right = magnet[j][2];
                    } else {
                        break;
                    }
                }
                // 회전
                for (int i = 0; i < 4; i++) {
                    if (rotation[i] == 1) {     // 시계방향
                        int tmp = magnet[i][7];
                        for (int j = 7; j > 0; j--) {
                            magnet[i][j] = magnet[i][j-1];
                        }
                        magnet[i][0] = tmp;
                    } else if (rotation[i] == -1) { // 반시계방향
                        int tmp = magnet[i][0];
                        for (int j = 0; j < 7; j++) {
                            magnet[i][j] = magnet[i][j+1];
                        }
                        magnet[i][7] = tmp;
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < 4; i++) {
                if (magnet[i][0] == 1) {
                    result+=Math.pow(2, i);
                }
            }

            System.out.printf("#%d %d\n",tc, result);


        }

    }
}
