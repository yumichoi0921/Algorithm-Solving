package BAEKJOON.y22.m6.w5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_20058 {
    static int N, Q, size;
    static int[][] map;
    static List<Integer> steps;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Q = sc.nextInt();
        size = (int) Math.pow(2, N);    // 맵 사이즈
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        steps = new LinkedList<>();
        for (int i = 0; i < Q; i++) {
            steps.add(sc.nextInt());
        }

        for (int i = 0; i < steps.size(); i++) {
            int L = steps.get(i);
            rotation(map, L);   // 회전
            countingIce(map);   // 얼음 수 계산
        }

        int totalIce = 0;
        int maxSize = 0;
        boolean[][] checked = new boolean[size][size];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                totalIce += map[i][j];
                if (checked[i][j] || map[i][j] == 0) continue;
                checked[i][j] = true;
                q.add(new int[]{i, j});
                int tmpSize = 0;
                while (!q.isEmpty()) {  // 덩어리는 bfs로 계산
                    int[] pos = q.poll();
                    tmpSize++;
                    for (int d = 0; d < 4; d++) {
                        int nr = pos[0] + dr[d];
                        int nc = pos[1] + dc[d];
                        if (!(nr >= 0 && nr < size && nc >= 0 && nc < size)) continue;
                        if (!checked[nr][nc] && map[nr][nc] > 0) {
                            q.add(new int[]{nr, nc});
                            checked[nr][nc] = true;
                        }
                    }
                }
                maxSize = Math.max(maxSize, tmpSize);
            }
        }

        System.out.println(totalIce);
        System.out.println(maxSize);
    }

    private static void countingIce(int[][] map) {
        List<int[]> decreasingList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (!(nr >= 0 && nr < size && nc >= 0 && nc < size)) continue;
                    if (map[nr][nc] > 0) cnt++;
                }
                if (cnt < 3) {  // 차례로 얼음을 세는 것이 아니라 한번에 같이 세야 함
                    decreasingList.add(new int[]{i, j});
                }
            }
        }
        for (int[] pos : decreasingList
        ) {
            map[pos[0]][pos[1]] = map[pos[0]][pos[1]] - 1 >= 0 ? map[pos[0]][pos[1]] - 1 : 0;
        }

    }

    private static void rotation(int[][] map, int L) {
        int sr = 0, sc = 0;
        int sectionSize = (int) Math.pow(2, L); // 단계별 격자 사이즈
        while (true) {
            if (sc >= size) {
                sc = 0;
                sr += sectionSize;
            }
            if (sr >= size) break;
            int[][] newSection = new int[sectionSize][sectionSize]; // 회전된 새로운 격자 저장
            for (int i = 0; i < sectionSize; i++) {
                for (int j = 0; j < sectionSize; j++) {
                    newSection[i][j] = map[sr + sectionSize - 1 - j][sc + i];   // 90도 회전하여 저장
                }
            }
            for (int i = 0; i < sectionSize; i++) {
                for (int j = 0; j < sectionSize; j++) {
                    map[sr + i][sc + j] = newSection[i][j]; // 새 격자를 기존 맵에 저장
                }
            }
            sc += sectionSize;
        }
    }
}
