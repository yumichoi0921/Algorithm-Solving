package BAEKJOON.y21.m9.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토
// 인접 토마토 - 델타
// 토마토가 모두 익는 최소 일수 - bfs, 큐의 사이즈
public class Main_7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] map = new int[N][M];
        ArrayList<int[]> tomatoes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) tomatoes.add(new int[]{i, j});   // 초기에 익은 토마토
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int day = 0;
        if (check(map, 0)) {    //  저장될 때부터 모든 토마토가 익어있는 상태
            System.out.println(day);
        } else {                      // 저장될 때부터 모든 토마토가 익어있는 상태가 아니라면
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[N][M];
            for (int i = 0; i < tomatoes.size(); i++) {
                q.offer(tomatoes.get(i));
                v[tomatoes.get(i)[0]][tomatoes.get(i)[1]] = true;
            }
            day = -1;
            while (!q.isEmpty()) {
                day++;
                int size = q.size();    // bfs 시작점이 여러곳이므로 사이즈 이용
                for (int i = 0; i < size; i++) {
                    int[] pos = q.poll();
                    int r = pos[0];
                    int c = pos[1];
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !v[nr][nc]) {
                            q.add(new int[]{nr, nc});
                            map[nr][nc] = 1;
                            v[nr][nc] = true;
                        }
                    }
                }
            }
            if (check(map, 0)) { // 안익은게 있는지 확인
                System.out.println(day);
            } else {
                System.out.println(-1);
            }
        }


    }

    private static boolean check(int[][] map, int status) { // 박스 상태 확인
        int check = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == status) check++;
            }
        }
        if (check == 0) return true;
        else return false;
    }
}
