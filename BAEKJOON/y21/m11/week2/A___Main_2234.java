package BAEKJOON.y21.m11.week2;

import java.util.*;

public class A___Main_2234 {

    static int N, M, cnt, size, wallBreakSize;
    static int[][] map, room;
    static Map<Integer, Integer> rooms;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0}; //서 북 동 남

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        cnt = 0;
        size = 0;
        rooms = new HashMap<>();
        room = new int[M][N];
        boolean[][] v = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    cnt++;
                    getCntAndSize(i, j, v);
                }
            }
        }

        wallBreakSize = 0;
        v = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    getWallBreakSize(i, j, v);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(size);
        System.out.println(wallBreakSize);
    }

    private static void getWallBreakSize(int i, int j, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        v[i][j] = true;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && !v[nr][nc]){
                    if ((map[r][c] & 1 << d) != 1 << d) {
                        v[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    } else {
                        if (room[r][c] != room[nr][nc]) {
//                            System.out.println(room[r][c] +" "+room[nr][nc]);
                            wallBreakSize = Math.max(wallBreakSize, rooms.get(room[r][c])+rooms.get(room[nr][nc]));
                        }
                    }
                }
            }

        }
    }


    private static void getCntAndSize(int i, int j, boolean[][] v) {
        int tmpSize = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        v[i][j] = true;
        while (!q.isEmpty()) {
            tmpSize++;
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && !v[nr][nc] && (map[r][c] & 1 << d) != 1 << d) {
                    v[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
            room[r][c] = cnt;
        }
        rooms.put(cnt, tmpSize);
        size = Math.max(size, tmpSize);
    }
}
