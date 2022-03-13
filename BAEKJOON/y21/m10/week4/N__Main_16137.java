package BAEKJOON.y21.m10.week4;

import java.util.*;

// floyd fill -> 최소 몇회까지 갈수있는지
// 백트래킹 -> 몇가지가 있는지
// 역추적 -> 배열 하나 더 return하면서 적기
public class N__Main_16137 {
    static int N, M;
    static int[][] map = new int[N][M];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c, cnt, edge;
        public Node(int r, int c, int cnt, int edge) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.edge = edge;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0;


        boolean[][][] v = new boolean[N][N][2];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        v[0][0][0] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.r == N-1 && n.c==N-1) {
                time = n.cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = n.r+dr[d];
                int nc = n.c+dc[d];
                if (nr>=0&&nr<N&&nc>=0&&nc<N) {
                    if (map[nr][nc] == 1 && !v[nr][nc][0] && !v[nr][nc][1]) {

                    }
                }
            }
        }



    }
}
