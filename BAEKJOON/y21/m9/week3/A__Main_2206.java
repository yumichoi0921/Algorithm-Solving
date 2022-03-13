package BAEKJOON.y21.m9.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 벽부수고 이동하기
// bfs, 3차원배열
public class A__Main_2206 {
    static int N, M;
    static int result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        result = -1;
        bfs(map);
        System.out.println(result);
    }

    // 어떤 벽이 있을 때 이 벽을 부수고 가는 것이 빨리 도착할지, 부수지 않고 가는 것이 빨리 도착할지 결정
//    특정 위치(nr, nc)까지 오는데 벽을 한 번 부수고 도달했는지 or 한 번도 부수지 않고 도달했는지
//    1. 벽을 부수지 않고 방문한 경우 : v[nr][nc][0]
//    2. 벽을 부수고 방문한 경우 : v[nr][nc][1]
    private static void bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] v = new boolean[N][M][2];
        q.offer(new int[]{0, 0, 0, 1});   // 0,1 -> 좌표 / 2->벽을 뚫은 횟수 / 3-> 이동횟수
        v[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
//            System.out.println(pos[0] +" "+ pos[1]);
            if (pos[0] == N - 1 && pos[1] == M - 1) {
                result = pos[3];
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nr = pos[0] + dr[d];
                int nc = pos[1] + dc[d];
                int drillCnt = pos[2];
                int cnt = pos[3];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0 && !v[nr][nc][drillCnt]) {   // 벽이 아니고 이 상태(벽을 부숨, 부수지 않음)로 이 위치를 방문한 적이 없을 경우
                        q.offer(new int[]{nr, nc, drillCnt, cnt + 1});
                        v[nr][nc][drillCnt] = true;
                    } else if (map[nr][nc] == 1 && drillCnt == 0) {    // 벽인데 이제까지 벽을 부순적이 없다면
                        q.offer(new int[]{nr, nc, 1, cnt + 1});
                        v[nr][nc][1] = true;
                    }
                }
            }
        }

    }
}
