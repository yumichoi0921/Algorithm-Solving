// 마법사 상어와 파이어볼
// 시뮬레이션
package BAEKJOON.y22.m3.w4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_20056 {
    static int N, M, K;
    static ArrayList<FireBall>[][] map;
    static Queue<FireBall> fireBalls;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        fireBalls = new LinkedList<>();
        for (int i = 0; i < M; i++) {   // 초기 파이어볼 리스트에 저장
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            fireBalls.add(new FireBall(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {
            while (!fireBalls.isEmpty()) {  // 파이어볼 이동
                FireBall fb = fireBalls.poll();
                int nr = (fb.r + dr[fb.d] * (fb.s % N) + N) % N;
                int nc = (fb.c + dc[fb.d] * (fb.s % N) + N) % N;
                fb.r = nr;
                fb.c = nc;
                map[nr][nc].add(fb);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].size() == 1) {    // 1개있으면 그냥 다음 리스트에 추가
                        fireBalls.add(map[i][j].get(0));
                    } else if (map[i][j].size() > 1) {
                        int totalM = 0;
                        int totalS = 0;
                        boolean isOdd = true;
                        boolean isEven = true;
                        for (int f = 0; f < map[i][j].size(); f++) {
                            totalM += map[i][j].get(f).m;
                            totalS += map[i][j].get(f).s;
                            isOdd = map[i][j].get(f).d % 2 == 1 ? isOdd & true : isOdd & false; // 현재까지 홀수였으면 true, 아니면 false
                            isEven = map[i][j].get(f).d % 2 == 0 ? isEven & true : isEven & false;

                        }
                        totalM = totalM / 5;
                        totalS = totalS / map[i][j].size();
                        if (totalM == 0) {
                            map[i][j].clear();
                            continue;
                        }
                        for (int f = 0; f < 4; f++) {
                            int r = i;
                            int c = j;
                            int m = totalM;
                            int s = totalS;
                            int d;
                            if (isEven | isOdd) d = f * 2;
                            else d = f * 2 + 1;
                            fireBalls.add(new FireBall(r, c, m, s, d));
                        }
                    }
                    map[i][j].clear();
                }
            }
        }
        int answer = 0;
        while (!fireBalls.isEmpty()) {
            answer += fireBalls.poll().m;
        }
        System.out.println(answer);
    }


    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}

