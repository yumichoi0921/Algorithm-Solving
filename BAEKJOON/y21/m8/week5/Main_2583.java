package BAEKJOON.y21.m8.week5;

import java.util.*;

public class Main_2583 {
    static ArrayList<Integer> area;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[M][N];
        int[][] square = new int[K][4]; //왼아래 x, y, 오른위 x, y
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 4; j++) {
                square[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < square.length; i++) {
            int w = square[i][2] - square[i][0];
            int h = square[i][3] - square[i][1];
            int nx = square[i][0];
            int ny = M - square[i][3];
            for (int j = ny; j < ny + h; j++) {
                for (int k = nx; k < nx + w; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        cnt = 0;
        area = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    bfs(arr, i, j);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(area);
        for (int i = 0; i < area.size(); i++) {
            System.out.print(area.get(i) + " ");
        }
        System.out.println();
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    private static void bfs(int[][] arr, int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        arr[sr][sc] = 1;
        int a = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && arr[nr][nc] == 0) {
                    queue.offer(new int[]{nr, nc});
                    arr[nr][nc] = 1;
                    a++;
                }
            }
        }
        cnt++;
        area.add(a);
    }
}
