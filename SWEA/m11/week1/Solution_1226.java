package SWEA.m11.week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 미로1
// bfs - 후보중에 하나만 찾으면 되므로 최단거리 찾으면 종료
public class Solution_1226 {
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();
            map = new int[16][16];
            int Sr = 0, Sc = 0, Dr = 0, Dc = 0;
            for (int i = 0; i < 16; i++) {
                String str = sc.next();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = str.charAt(j)-'0';
                    if (map[i][j] == 2) {
                        Sr = i;
                        Sc = j;
                    } else if (map[i][j] == 3) {
                        Dr = i;
                        Dc = j;
                    }
                }
            }

            int res = 0;
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[16][16];
            q.add(new int[] {Sr, Sc});
            v[Sr][Sc] = true;
            while (!q.isEmpty()) {
                int[] pos = q.poll();
                if (pos[0] == Dr && pos[1] == Dc) {
                    res = 1;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = pos[0]+dr[d];
                    int nc = pos[1]+dc[d];
                    if (nr>=0 && nr<16 && nc>=0 && nc<16 && map[nr][nc]!=1 && !v[nr][nc]) {
                        v[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                }
            }

            System.out.println("#"+tc+" "+res);

        }
    }
}
