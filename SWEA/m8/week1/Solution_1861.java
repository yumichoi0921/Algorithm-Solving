package SWEA.m8.week1;

import java.util.Scanner;

public class Solution_1861 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int res;
    static int roomNum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] room = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    room[i][j] = sc.nextInt();
                }
            }

            res = 1;
            roomNum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    search(room, i, j, N, 1, room[i][j]);
                }
            }
        System.out.printf("#%d %d %d\n", tc, roomNum, res);
        }

    }

    private static void search(int[][] room, int baseI, int baseJ, int N, int cnt, int roomIdx){

//        if (cnt == res) {
//            roomNum = Math.min(roomNum, roomIdx);
////            System.out.println(baseI+" "+ baseJ+" "+roomNum + " " + res);
//        }
//        if (cnt > res) {
//            roomNum = roomIdx;
//            res = cnt;
////            System.out.println(baseI+" "+ baseJ+" "+roomNum + " " + res);
//        }

        for (int d = 0; d < 4; d++) {
            int tmpR = baseI+dr[d];
            int tmpC = baseJ+dc[d];
            if (tmpR<0||tmpR>N || tmpC<0||tmpC>N) continue;
            if (room[tmpR][tmpC] == room[baseI][baseJ]+1){
                cnt++;
                if (cnt == res) roomNum = Math.min(roomNum, roomIdx);
                if (cnt > res)  roomNum = roomIdx; res = cnt;
                search(room, tmpR, tmpC, N, cnt, roomIdx);
            }
        }
    }
}
