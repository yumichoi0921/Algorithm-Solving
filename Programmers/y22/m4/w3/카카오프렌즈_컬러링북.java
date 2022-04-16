package Programmers.y22.m4.w3;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    visited[i][j] = true;
                    int tmpSize = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        tmpSize++;
                        for (int d = 0; d < 4; d++) {
                            int nr = pos[0] + dr[d];
                            int nc = pos[1] + dc[d];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && picture[nr][nc] == picture[i][j]) {
                                q.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmpSize);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
