package BAEKJOON.y21.m9.week3;

import java.util.Arrays;
import java.util.Scanner;

// 다리만들기2
// 섬 넘버링 - dfs
// 인접행렬 만들기
// 섬 연결 - MST - prim
public class Main_17472 {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n; // 섬의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[][] area = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        n = 0;  // 섬의 개수
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {   // 섬 dfs로 구하기
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 1 && !visited[i][j]) {
                    n++;
                    int r = i, c = j;
                    findIslandsDFS(area, visited, r, c);
                }
            }
        }

        int[][] bridges = new int[n + 1][n + 1];    // 다리후보 배열
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(bridges[i], 9);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] != 0) {  // 만약 섬이면
                    for (int d = 0; d < 4; d++) {   // 사방탐색
                        int r = i, c = j;   // 현재 좌표
                        int len = 0;        // 다리 길이
                        r += dr[d];
                        c += dc[d];
                        while (r >= 0 && r < N && c >= 0 && c < M) {
                            if (area[r][c] == area[i][j]) { // 만약 사방탐색 했는데 같은 섬이면 중지
                                break;
                            }
                            if (area[r][c] != 0) {  // 다른 섬이면
                                if (len >= 2) {     // 다리 길이가 2 이상이면
                                    int from = area[i][j];
                                    int to = area[r][c];
                                    bridges[from][to] = Math.min(bridges[from][to], len);
                                }
                                break;
                            }
                            r += dr[d];
                            c += dc[d];
                            len++;
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(area[i][j] +" ");
//            }
//            System.out.println();
//        }
//        for (int i = 1; i < n+1; i++) {
//            for (int j = 1; j < n+1; j++) {
//                System.out.print(bridges[i][j] +" ");
//            }
//            System.out.println();
//        }

        boolean[] nVisited = new boolean[n + 1];
        int[] node = new int[n + 1];
        Arrays.fill(node, Integer.MAX_VALUE);
        int result = 0;    // 최소 신장트리 비용
        node[1] = 0;    // 임의의 시작점 1의 간선비용을 0으로 세팅

        for (int i = 1; i <= n; i++) {
            // 1. 신장트리에 포함되지 않은 노드 중 최소 간선 비용의 노드 찾기
            int minDis = Integer.MAX_VALUE;
            int minVertex = -1;    // 최소간선비용의 노드번호

            for (int j = 1; j <= n; j++) {
                if (!nVisited[j] && minDis > node[j]) {
                    minDis = node[j];
                    minVertex = j;
                }
            }
            if (minVertex == -1) {
                result = -1;
                break;
            }

            nVisited[minVertex] = true; // 신장트리에 포함시킴
            result += minDis; // 간선비용 누적

            //	2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트

            for (int j = 1; j <= n; j++) {
                // 아직 신장트리에 포함되지 않았고, 인접한 정점이며, 간선 비용이 저장된 최소 비용보다 작을 때
                if (!nVisited[j] && bridges[minVertex][j] != 9 && node[j] > bridges[minVertex][j]) {
                    node[j] = bridges[minVertex][j];    // 최소 간선 비용 업데이트
                }
            }
        }
        System.out.println(result);
    }


    private static void findIslandsDFS(int[][] area, boolean[][] visited, int r, int c) {   // 섬을 구하는 dfs
        if (!(area[r][c] == 1 && !visited[r][c])) {
            return;
        }
        visited[r][c] = true;
        area[r][c] = n;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                findIslandsDFS(area, visited, nr, nc);
            }
        }
    }
}
