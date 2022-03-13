package SWEA.m10.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 수지의 수지맞는 여행
// dfs
public class Solution_7699 {
    static int R, C, res;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            R = sc.nextInt();
            C = sc.nextInt();
            map = new char[R][C];
            for (int i = 0; i < R; i++) {
                String str = sc.next();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

//            print(map);
            res = 0;
            ArrayList<Character> list = new ArrayList<>();
            list.add(map[0][0]);
            dfs(0, 0, list);
            System.out.println("#"+tc+" "+res);
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    private static void dfs(int r, int c, ArrayList<Character> list) {
        for (int d = 0; d < 4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if (nr>=0 && nr<R && nc>=0 && nc<C && !list.contains(map[nr][nc])) {
                list.add(map[nr][nc]);
                dfs(nr, nc, list);
                list.remove(list.size()-1);
            }

        }
        res = Math.max(res, list.size());
    }
}
