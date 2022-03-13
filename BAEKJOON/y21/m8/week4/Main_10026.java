package BAEKJOON.y21.m8.week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 적록색약 - bfs
public class Main_10026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int N = sc.nextInt();
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next().toCharArray();
        }
        // 적록색약 아닐때
        boolean[][] visited = new boolean[N][N];
        int cnta = 0;
        Queue<int[]> group = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {               // 방문하지 않았다면
                    group.add(new int[]{i, j});    // 그룹에 포함
                    char color = arr[i][j];         // 그룹 색깔
                    visited[i][j] = true;           // 방문 표시
                    while (!group.isEmpty()) {
                        int[] pos = group.poll();   // 현재 위치
                        for (int d = 0; d < 4; d++) {   // 사방탐색
                            int nr = pos[0] + dr[d];
                            int nc = pos[1] + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && arr[nr][nc] == color) {   // 사방탐색한 위치의 색이 그룹 색이랑 같다면
                                group.add(new int[]{nr, nc});  // 다음 탐색할 큐에 포함
                                visited[nr][nc] = true;         // 방문 표시
                            }
                        }
                    }
                    cnta++;
                }
            }
        }
        // 적록색약일때
        visited = new boolean[N][N];
        int cntb = 0;
        group = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    group.add(new int[]{i, j});
                    char color = arr[i][j];
                    visited[i][j] = true;
                    while (!group.isEmpty()) {
                        int[] pos = group.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = pos[0] + dr[d];
                            int nc = pos[1] + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                                if (color == 'R' || color == 'G') {                 // 그룹색이 적색이나 초록색일 때
                                    if (arr[nr][nc] == 'R' || arr[nr][nc] == 'G') {  // 현재 색도 적색이나 초록색이면
                                        group.add(new int[]{nr, nc});              // 그룹에 포함
                                        visited[nr][nc] = true;
                                    }
                                } else {                                            // 그룹색이 파란색이면
                                    if (arr[nr][nc] == color) {                     // 현재 색이 파란색일 때
                                        group.add(new int[]{nr, nc});             // 그룹에 포함
                                        visited[nr][nc] = true;
                                    }
                                }
                            }
                        }
                    }
                    cntb++;
                }
            }
        }
        System.out.println(cnta + " " + cntb);
    }
}
