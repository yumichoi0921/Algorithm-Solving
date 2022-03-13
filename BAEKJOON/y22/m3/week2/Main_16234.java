// 인구이동
package BAEKJOON.y22.m3.week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16234 {
    static int N, L, R;
    static int[][] A;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        answer = 0;


        while (true) {
            Queue<int[]> unions = checkUnions();

            if (unions.isEmpty()) break;
            while (!unions.isEmpty()) {
                int[] union = unions.poll();
                Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[N][N];
                q.add(new int[]{union[0], union[1]});
                visited[union[0]][union[1]] = true;
                while (!q.isEmpty()) {
                    int[] pos = q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = pos[0] + dr[d];
                        int nc = pos[1] + dc[d];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                            int diff = Math.abs(A[pos[0]][pos[1]] - A[nr][nc]);
                            if (diff >= L && diff <= R) {
                                q.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    A[pos[0]][pos[1]] = union[3] / union[2];
                }
            }
            answer++;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(A[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("--------------");
        }
        System.out.println(answer);
    }

    private static Queue checkUnions() {
        Queue<int[]> unions = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int unionSize = 0;
                    int people = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        unionSize++;
                        people += A[pos[0]][pos[1]];
                        for (int d = 0; d < 4; d++) {
                            int nr = pos[0] + dr[d];
                            int nc = pos[1] + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                                int diff = Math.abs(A[pos[0]][pos[1]] - A[nr][nc]);
                                if (diff >= L && diff <= R) {
                                    q.add(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                }
                            }
                        }
                    }
                    if (unionSize > 1) {
                        unions.add(new int[]{i, j, unionSize, people});
                    }
                }
            }
        }
        return unions;
    }
}
