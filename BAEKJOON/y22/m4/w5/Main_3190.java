// 뱀
package BAEKJOON.y22.m4.w5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3190 {
    static int N, K, L;
    static int[][] map;
    static Queue<DirInfo> dirInfos;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }
        L = sc.nextInt();
        dirInfos = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            dirInfos.add(new DirInfo(sc.nextInt(), sc.next()));
        }

        int[] head = {0, 0};
        int dir = 0;
        map[head[0]][head[1]] = -1;
        Queue<int[]> body = new LinkedList<>();
        body.add(new int[]{head[0], head[1]});
        int time = 0;

        Move:
        while (true) {
            time++;
            if (!dirInfos.isEmpty() && time > dirInfos.peek().x) {
                DirInfo info = dirInfos.poll();
                if (info.c.equals("L")) {
                    dir = ((dir + 4) - 1) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
            int nr = head[0] + dr[dir];
            int nc = head[1] + dc[dir];
            if (!(nr >= 0 && nr < N && nc >= 0 && nc < N)) {
                break Move;
            }
            if (map[nr][nc] == -1) {
                break Move;
            }

            if (map[nr][nc] == 0) {
                int[] tail = body.poll();
                map[tail[0]][tail[1]] = 0;
            }
            head[0] = nr;
            head[1] = nc;
            body.add(new int[]{head[0], head[1]});
            map[head[0]][head[1]] = -1;
        }

        System.out.println(time);
    }

    static class DirInfo {
        int x;
        String c;

        public DirInfo(int x, String c) {
            this.x = x;
            this.c = c;
        }

    }
}
