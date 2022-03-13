package SWEA.m9.week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 탈주범 검거
// bfs
// type을 문자열 배열로 해서 contains하면 구하기 쉬울듯
public class Solution_1953 {
    static int[] dr = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};
    static int N, M, mr, mc, L, result;
    static int[][] map;
//    static int[][] type = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
    static String[] type = {"", "0123", "01", "23", "03", "13", "12", "02"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            mr = sc.nextInt();
            mc = sc.nextInt();
            L = sc.nextInt();
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            result = 0;
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[N][M];
            q.add(new int[]{mr, mc, map[mr][mc]});
            v[mr][mc] = true;
            int cnt = 0;

            while (!q.isEmpty()) {
                if (cnt==L) break;
                cnt++;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] p = q.poll();
                    int r = p[0], c = p[1], t = p[2];
                    result++;
                    for (int d = 0; d < type[t].length(); d++) {
                        int nd = type[t].charAt(d)-'0';
                        int nr = r+dr[nd];
                        int nc = c+dc[nd];
                        if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=0 && !v[nr][nc]) {
                            String[] check = {"1", "0", "3", "2"};
                            boolean flag = false;
                            int nt = map[nr][nc];
                            if (type[nt].contains(check[nd])) {
                                q.add(new int[]{nr, nc, map[nr][nc]});
                                v[nr][nc] = true;
                            }
                        }
                    }
//                    for (int d = 0; d < type[t].length; d++) {
//                        int nd = Integer.parseInt(type[t][d]);
////                        int nd = type[t][d];
//                        int nr = r+dr[nd];
//                        int nc = c+dc[nd];
//                        if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=0 && !v[nr][nc]) {
//                            int[] check = {1, 0, 3, 2};
//                            boolean flag = false;
//                            int nt = map[nr][nc];
//                            for (int j = 0; j < type[nt].length; j++) {
//                                if (type[nt][j] == check[nd]) {
//                                    flag = true;
//                                    break;
//                                }
//                            }
//                            if (flag) {
//                                q.add(new int[]{nr, nc, map[nr][nc]});
//                                v[nr][nc] = true;
//                            }
//                        }
//                    }
                }
            }

            System.out.println("#"+tc+" "+ result);
        }
    }

}



