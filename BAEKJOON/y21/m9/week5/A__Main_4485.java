package BAEKJOON.y21.m9.week5;

import java.util.PriorityQueue;
import java.util.Scanner;

// 녹색 옷을 입은 애가 젤다지?
// bfs? -> 최단거리가 최소비용을 보장하지 않음 X
// dfs? -> 입력이 100을 넘어가므로 시간초과날 것
// dfs+백트래킹, dfs+dp?
// 시작점부터 목적지까지 최소비용으로 가는 것 -> 다익스트라
// 다익스트라-우선순위큐
public class A__Main_4485 {
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 0;
        while (true) {
            N = sc.nextInt();
            if (N == 0) break;
            tc++;
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            result = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[][] visited = new boolean[N][N];
            pq.offer(new Node(0, 0, map[0][0]));
            visited[0][0] = true;
            while (!pq.isEmpty()) {
                Node n = pq.poll();
                if (n.r == N - 1 && n.c == N - 1) {
                    result = n.weight;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = n.r + dr[d];
                    int nc = n.c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                        pq.add(new Node(nr, nc, n.weight + map[nr][nc]));
                        visited[nr][nc] = true;
                    }
                }
            }
            System.out.printf("Problem %d: %d\n", tc, result);

        }
    }

    static class Node implements Comparable<Node> {
        int r, c, weight;

        Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
