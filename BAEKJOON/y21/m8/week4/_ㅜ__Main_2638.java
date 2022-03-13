package BAEKJOON.y21.m8.week4;

import java.util.ArrayList;
import java.util.Scanner;

// 치즈 - dfs 외부공기 찾기
public class _ㅜ__Main_2638 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[N][M];
        ArrayList<int[]> cheese = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) cheese.add(new int[]{i, j});
            }
        }

        boolean[][] visited;
        int cnt = 0;
        while (!cheese.isEmpty()) {
            visited = new boolean[N][M];
            outerAir(arr, 0, 0, visited);
            ArrayList<Integer> meltIdx = new ArrayList<>();
            for (int i = 0; i < cheese.size(); i++) {
                int r = cheese.get(i)[0];
                int c = cheese.get(i)[1];
                int contact = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == -1) {
                        contact++;
                    }
                    if (contact >= 2) {
                        meltIdx.add(i);
                        break;
                    }
                }
            }

            for (int i = 0; i < meltIdx.size(); i++) {
                int idx = meltIdx.get(i);
                int r = cheese.get(idx)[0];
                int c = cheese.get(idx)[1];
                arr[r][c] = 0;
                cheese.get(idx)[0] = -1;
            }
            for (int i = 0; i < cheese.size(); i++) {
                if (cheese.get(i)[0] == -1) {
                    cheese.remove(i);
                    i--;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void outerAir(int[][] arr, int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        arr[r][c] = -1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (arr[nr][nc] != 1 && !visited[nr][nc]) {
                    outerAir(arr, nr, nc, visited);
                }
            }
        }
    }
}
