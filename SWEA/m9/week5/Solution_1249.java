package SWEA.september.week5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
// 보급로
// 다익스트라
// bfs+우선순위큐 -> 다익스트라
public class Solution_1249 {
    static class Point implements Comparable<Point> {
        int r, c, rt;
        public Point(int r, int c, int rt) {
            this.r = r;
            this.c = c;
            this.rt = rt;
        }
        @Override
        public int compareTo(Point o) {
            return this.rt-o.rt;
        }
    }
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j)-'0';
                }
            }

            int result;
            result = dijkstra(0, 0);
            System.out.println("#"+tc+" "+result);
            result = dijkstra_pq(0, 0);
            System.out.println("#"+tc+" "+result);
            result = my_dijkstra_pq();
            System.out.println("#"+tc+" "+result);


        }
    }

    private static int my_dijkstra_pq() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        pq.add(new Point(0, 0, map[0][0]));
        visited[0][0] = true;
        while (true) {
            Point p = pq.poll();
            if (p.r==N-1&&p.c==N-1) {
                return p.rt;
            }
            for (int d = 0; d < 4; d++) {
                int nr = p.r+dr[d];
                int nc = p.c+dc[d];
                if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.add(new Point(nr, nc, p.rt+map[nr][nc]));
                }
            }
        }
    }

    private static int dijkstra_pq(int Sr, int Sc) {
        int cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        minTime[Sr][Sc] = 0;
        pq.offer(new int[] {Sr, Sc, minTime[Sr][Sc]});

        while (true) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int minCost = cur[2];

            if (visited[r][c]) continue;
            visited[r][c] = true;
            if (r==N-1 && c==N-1) {
                return minCost;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                // r, c까지 오는 비용+ r, c에서 nr, nc로 가는 비용(사방탐색)과 기존 nr, nc로 가는 비용 비교
                if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && minCost+map[nr][nc] < minTime[nr][nc]) {
                    minTime[nr][nc] = minCost+map[nr][nc];
                    pq.offer(new int[] {nr, nc, minTime[nr][nc]});
                }
            }

        }

    }

    private static int dijkstra(int Sr, int Sc) {
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        minTime[Sr][Sc] = 0;
        while (true) {
            //  step 1: 방문하지 않은 정점중에서 출발지에서 자신으로의 비용이 최적인 좌표 선택 -> N^2소요
            int minCost = Integer.MAX_VALUE;    // 출발지에서 좌표까지의 최적 비용
            int r= -1, c = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && minTime[i][j] <= minCost) {
                        minCost = minTime[i][j];
                        r = i;
                        c = j;
                    }
                }
            }
            visited[r][c] = true;
            if (r==N-1 && c==N-1) {
                return minCost;
            }

            //  step2: step1에서 선택된 정점을 경유지로 해서 인접 정점 따져보기
            for (int d = 0; d < 4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                // r, c까지 오는 비용+ r, c에서 nr, nc로 가는 비용(사방탐색)과 기존 nr, nc로 가는 비용 비교
                if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && minCost+map[nr][nc] < minTime[nr][nc]) {
                    minTime[nr][nc] = minCost+map[nr][nc];
                }
            }
        }
    }
}
