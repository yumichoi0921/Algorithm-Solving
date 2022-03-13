package BAEKJOON.y21.m9.week5;

import java.util.ArrayList;
import java.util.Scanner;

// 시뮬레이션
public class ㅜ__Main_17143 {
    static int[] dr = {0, -1, 1, 0, 0}; // 상 하 우 좌
    static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();   // 상어 수
//        int[][][] map = new int[R][C][3];   // 해당위치의 속력, 방향 크기
        int[][] map = new int[R][C];   // 해당위치의 속력, 방향 크기
//        int[][][][] map = new int[R][C][][3];   // 해당위치의 속력, 방향 크기
        ArrayList<Shark> sharks = new ArrayList<>();
        boolean[][] shark = new boolean[R][C];
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            shark[r][c] = true;

            sharks.add(new Shark(r, c, s, d, z));
            map[r][c] = z;
//            map[r][c][0] = s;
//            map[r][c][1] = d;
//            map[r][c][2] = z;
        }


        int c = 0;
        int result = 0;
        while (c < C) {
            // 상어 잡기
            int r;
            for (r = 0; r < R; r++) {
                if (shark[r][c]) {                 // 가장 가까운 상어 발견
                    shark[r][c] = false;           // 상어 사라짐

//                    result += map[r][c][2];     // 상어잡기: 상어 크기 더하기
//                    map[r][c][0] = map[r][c][1] = map[r][c][2] = 0; // 맵 초기화
                    result += map[r][c];     // 상어잡기: 상어 크기 더하기
                    map[r][c] = 0; // 맵 초기화
                    for (int i = 0; i < sharks.size(); i++) {
                        if (sharks.get(i).r == r && sharks.get(i).c == c) {
                            sharks.remove(i);
                            break;
                        }
                    }
                    break;
                }
            }
            // 상어 이동
            for (int i = 0; i < sharks.size(); i++) {
                int Sr = sharks.get(i).r;
                int Sc = sharks.get(i).c;
                int s = sharks.get(i).s;
                int d = sharks.get(i).d;
                shark[Sr][Sc] = false;
//                map[Sr][Sc][0] = map[Sr][Sc][1] = map[Sr][Sc][2] = 0;
                map[Sr][Sc] = 0;
                for (int ns = 0; ns < s; ns++) {
                    int nr = Sr + dr[d];
                    int nc = Sc + dc[d];
                    if (!(nr >= 0 && nr < R && nc >= 0 && nc < C)) {
                        if (d == 1) d = 2;
                        else if (d == 2) d = 1;
                        else if (d == 3) d = 4;
                        else if (d == 4) d = 3;
                        nr = Sr + dr[d];
                        nc = Sc + dc[d];
                    }
                    Sr = nr;
                    Sc = nc;
                }
                sharks.get(i).r = Sr;
                sharks.get(i).c = Sc;
                sharks.get(i).d = d;
            }
            // 위치가 같은 상어
            for (int i = 0; i < sharks.size(); i++) {
                for (int j = i + 1; j < sharks.size(); j++) {
                    if (sharks.get(i).r == sharks.get(j).r && sharks.get(i).c == sharks.get(j).c) {
                        if (sharks.get(i).z < sharks.get(j).z) {
                            sharks.get(i).s = sharks.get(j).s;
                            sharks.get(i).d = sharks.get(j).d;
                            sharks.get(i).z = sharks.get(j).z;
                        }
                        sharks.remove(j);
                        j--;
                    }
                }
            }
            // map에 상어 놓기
            for (int i = 0; i < sharks.size(); i++) {
                int Sr = sharks.get(i).r;
                int Sc = sharks.get(i).c;
                int s = sharks.get(i).s;
                int d = sharks.get(i).d;
                int z = sharks.get(i).z;
                shark[Sr][Sc] = true;
//                map[Sr][Sc][0] = s;
//                map[Sr][Sc][1] = d;
//                map[Sr][Sc][2] = z;
                map[Sr][Sc] = z;
            }
            c++;
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    System.out.print(map[i][j][2]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }
        System.out.println(result);
    }

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s; // 속력
            this.d = d; // 방향
            this.z = z; // 크기
        }
    }
}
