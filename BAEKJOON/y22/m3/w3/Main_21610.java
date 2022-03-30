// 마법사상어와 비바라기
// 시뮬레이션
package BAEKJOON.y22.m3.w3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_21610 {
    static int N, M;
    static int[][] A;       // 바구니 배열
    static int[][] moves;   // 이동 정보 배열
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static ArrayList<int[]> clouds;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N][N];
        moves = new int[M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            moves[i][0] = sc.nextInt();
            moves[i][1] = sc.nextInt();
        }
        clouds = new ArrayList<>();
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});

        for (int m = 0; m < moves.length; m++) {
            // 구름 이동
            int dir = moves[m][0];
            int cnt = moves[m][1];
            for (int i = 0; i < clouds.size(); i++) {   // 구름 이동
                int nr = clouds.get(i)[0] + (dr[dir] * cnt);
                int nc = clouds.get(i)[1] + (dc[dir] * cnt);
                if (nr < 0) nr = N - (Math.abs(nr) % N);
                if (nr >= N) nr = nr % N;
                if (nc < 0) nc = N - (Math.abs(nc) % N);
                if (nc >= N) nc = nc % N;
                A[nr][nc]++;                        // 구름이 있는 칸의 바구니 물의 양 증가
                clouds.set(i, new int[]{nr, nc});   // 구름 자리 업데이트
            }
            // 물복사버그 마법
            for (int i = 0; i < clouds.size(); i++) {
                int k = 0;
                for (int d = 2; d < 9; d += 2) {
                    int nr = clouds.get(i)[0] + dr[d];
                    int nc = clouds.get(i)[1] + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && A[nr][nc] != 0) {
                        k++;
                    }
                }
                A[clouds.get(i)[0]][clouds.get(i)[1]] += k;
            }
            // 구름이 있던 자리 true로
            boolean[][] hadClouds = new boolean[N][N];
            for (int i = 0; i < clouds.size(); i++) {
                hadClouds[clouds.get(i)[0]][clouds.get(i)[1]] = true;
            }
            // 구름 사라짐
            clouds.clear();
            // 물의 양이 2이고 이전에 구름 없던 자리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] >= 2 && !hadClouds[i][j]) {
                        clouds.add(new int[]{i, j});    // 구름이 생기고
                        A[i][j] -= 2;                     // 물의 양은 2감소
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += A[i][j];
            }
        }
        System.out.println(answer);
    }
}
