// 단지번호붙이기
// 완전탐색 - bfs
package BAEKJOON.y22.m3.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int total;   // 총 단지수
    static ArrayList<Integer> numOfHouse;   // 단지 내 집의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        total = 0;
        numOfHouse = new ArrayList<>();

        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 방문하지 않은 집 발견
                    total++;                            // 단지 개수 + 1
                    numOfHouse.add(0);                  // 해당 단지 내 집의 수 초기화
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        map[pos[0]][pos[1]] = total;    // 단지 번호 붙이기
                        numOfHouse.set(total - 1, numOfHouse.get(total - 1) + 1);   // 단지 내 집의 수 증가
                        for (int d = 0; d < 4; d++) {
                            int nr = pos[0] + dr[d];
                            int nc = pos[1] + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !visited[nr][nc]) {
                                q.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(numOfHouse);   // 단지 별 집의 수 정렬
        System.out.println(total);
        for (int num : numOfHouse
        ) {
            System.out.println(num);
        }

    }
}
