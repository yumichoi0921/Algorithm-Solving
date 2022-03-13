package BAEKJOON.y21.m8.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _N__Main_16236 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int r = -1, c = -1; // 아기 상어 처음 위치
        int size = 2;   // 아기 상어 처음 사이즈

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                arr[i][j] = sc.nextInt();
//                if (arr[i][j] == 9) {
//                    r = i; c = j;
//                }
//            }
//        }

        List<int[]> fish = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int s = sc.nextInt();
                if (s == 9) {
                    r = i;
                    c = j;
                } else if (s >= 1 && s <= 6) {
                    fish.add(new int[]{i, j, s});
                }
            }
        }
        // 물고기 > 상어 -> 먹기X 지나감X
        // 물고기 = 상어 -> 먹기X 지나감O
        // 물고기 < 상어 -> 먹기O 지나감O
//        Collections.sort(fish, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[2]-o2[2];
//            }
//        });
        for (int i = 0; i < fish.size(); i++) {
            System.out.println(fish.get(i)[0] + " " + fish.get(i)[1] + " " + fish.get(i)[2]);
        }


        int time = 0;
        int eat = 0;
        while (!fish.isEmpty()) {
            System.out.println();
            int fishIdx = -1;
            int minDis = Integer.MAX_VALUE;
            int minC = Integer.MAX_VALUE;
            for (int i = 0; i < fish.size(); i++) {
                if (fish.get(i)[2] < size) {
                    int dis = Math.abs(r - fish.get(i)[0]) + Math.abs(c - fish.get(i)[1]);
                    if (dis < minDis) {
                        minDis = dis;
                        minC = fish.get(i)[1];
                        fishIdx = i;
                    } else if (dis == minDis) {
                        if (fish.get(i)[1] < minC) {
                            minC = fish.get(i)[1];
                            fishIdx = i;
                        }
                    }
                }
            }
            if (fishIdx == -1) break;
            findTime(arr, r, c, fish.get(fishIdx)[0], fish.get(fishIdx)[1], size);

//            dijkstra()
            time += minDis;
            eat++;
            r = fish.get(fishIdx)[0];
            c = fish.get(fishIdx)[1];

            System.out.println(Arrays.toString(fish.get(fishIdx)) + " " + time);

            fish.remove(fishIdx);
            if (size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.println(time);


//        int cnt = -1;
//        Queue<int[]> pos = new LinkedList<>();
//        pos.add(new int[] {r, c});
//        while (!pos.isEmpty()) {
//            cnt ++;
//            int[] p = pos.poll();
//            r = p[0]; c = p[1];
//            int loop = pos.size();
//
//            for (int d = 0; d < 4; d++) {
//                int nr = r+dr[d];
//                int nc = c+dc[d];
//                if (nr>=0 &&nr<N && nc>=0 && nr<N) {
//                    if (arr[nr][nc] <= size) {
//                        pos.add(new int[]{nr, nc});
//                        if (arr[nr][nc] < size) {
//
//                        }
//                    }
//                }
//            }
//        }

    }

    private static void findTime(int[][] arr, int sr, int sc, int dr, int dc, int size) {

    }
}
