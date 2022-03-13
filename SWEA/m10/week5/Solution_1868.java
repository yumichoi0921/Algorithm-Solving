package SWEA.m10.week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 파핑파핑 지뢰찾기
// bfs
public class Solution_1868 {
    static int N, result;
    static char[][] map;
    static int[] dr ={-1, -1 ,-1, 0, 0, 1, 1, 1};
    static int[] dc ={-1, 0 ,1, -1, 1, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                map[i] = str.toCharArray();
            }

            result = 0;
            bfs_flip(0, 0);    // bfs로 지뢰 없는 모든 칸 숫자로 변경

            boolean[][] v = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '0' && !v[i][j]) { // 방문 안하고 0이면
                        check(i, j, v); // 8방탐색하여 연쇄적으로 클릭할 수 있는 칸 확인
                        result++;   // 클릭 수 증가
                    } else if (map[i][j] !='*' && map[i][j] !='0' && !v[i][j]) {    // 방문 안하고 0이상이면
                        boolean flag = true;
                        for (int d = 0; d < 8; d++) {
                            int nr = i+dr[d];
                            int nc = j+dc[d];
                            if (nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]=='0') {   // 8방탐색시 0이 없으면 클릭 수 증가
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            result++;
                        }
                    }
                }
            }
            System.out.println("#"+tc+" "+result);
        }
    }

    private static void check(int i, int j, boolean[][] v) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        v[i][j] = true;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = pos[0]+dr[d];
                int nc = pos[1]+dc[d];
                if (nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
                    v[nr][nc] = true;
                    if (map[nr][nc]=='0') {
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    private static void bfs_flip(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[N][N];
        q.add(new int[] {0, 0});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int bomb = 0;
            for (int d = 0; d < 8; d++) {
                int nr = pos[0]+dr[d];
                int nc = pos[1]+dc[d];
                if (nr>=0&&nr<N&&nc>=0&&nc<N) {
                    if (map[nr][nc] == '*') {
                        bomb++;
                    } else if (map[nr][nc] == '.' && !v[nr][nc]) {
                        q.add(new int[] {nr, nc});
                        v[nr][nc] = true;
                    }
                }
            }
            map[pos[0]][pos[1]] = (char)(bomb+'0');
//            if (map[pos[0]][pos[1]] =='.') {
//            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
