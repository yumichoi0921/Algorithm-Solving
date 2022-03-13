package Y2022_spring_SKICT;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {

    }

    public int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        map = new int[height + 2][width + 2];
        int[] sp = {1, height + 1};
        int[] ep = {width + 1, 1};
        for (int i = 0; i < diagonals.length; i++) {
            map[sp[1] - diagonals[i][1]][diagonals[i][0]] = 1;
        }

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[height + 1][width + 1];
        q.add(new Point(sp[0], sp[1], 0));
        visited[sp[0]][sp[1]] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.r == ep[0] && p.c == ep[1]) {

            }
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dr[d];


            }
        }


        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        return answer;
    }

    public class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
