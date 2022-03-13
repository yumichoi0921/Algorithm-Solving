package JungOl.m8.week3;

import java.util.Scanner;
// 오목
public class _N__Main_1733 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] game = new int[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                game[i][j] = sc.nextInt();
            }
        }

        // 8방탐색 상하좌우 위대각 아래 대각
        int[] dr ={-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc ={0, 0, -1, 1, -1, 1, -1, 1};
        int dol = 0;
        int cnt = 0;
        int resR = 0, resC = 0;
        All: for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (game[i][j] == 1 || game[i][j] == 2) {
                    for (int d = 0; d < dr.length; d++) {
                        cnt = 1;
                        int nr = i+dr[d], nc = j+dc[d];
                        while (nr>=0 && nr<19 && nc>=0 && nc <19) {
                            if (game[nr][nc] == game[i][j]) {
                                cnt++;
                                nr = nr+dr[d];
                                nc = nc+dc[d];
                            } else{
                                break;
                            }
                        }
                        if (cnt == 5) {
                            dol = game[i][j];
                            if (d == 0) {   // 상
                                resR = i+4+1;
                                resC = j+1;
                            } else if (d == 2){ // 좌
                                resR = i+1;
                                resC = j-4+1;
                            } else if (d==4) {  // 위왼
                                resR = i-4+1;
                                resC = j-4+1;
                            } else if (d==6) {  //아왼
                                resR = i+4+1;
                                resC = j-4+1;
                            } else {
                                resR = i+1;
                                resC = j+1;
                            }
                            break All;
                        }
                    }
                }
            }
        }
        if (cnt == 5) {
            System.out.println(dol);
            System.out.println(resR +" " + resC);
        } else {
            System.out.println(dol);
        }
    }
}
