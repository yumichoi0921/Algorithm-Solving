// 인구이동
// 시뮬레이션
package BAEKJOON.y22.m3.w2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16234 {
    static int N, L, R;
    static int[][] A;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer;
    static Queue<ArrayList<int[]>> unions;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        answer = 0;

        checkUnions();  // 연합이 있는지 확인
        while (!unions.isEmpty()) { // 연합이 있다면 인구 이동 시작
            while (!unions.isEmpty()) { // 모든 연합이 인구이동을 마칠 때까지 반복
                ArrayList<int[]> union = unions.poll(); // 연합 하나 빼기
                int unionSize = 0;  // 연합인 나라 사이즈
                int peopleSize = 0; // 연합인 나라 총 인구
                for (int i = 0; i < union.size(); i++) {
                    unionSize++;    // 연합에 포함되는 나라 개수 증가
                    peopleSize += A[union.get(i)[0]][union.get(i)[1]];  // 연합의 총 인구 증가
                }
                for (int i = 0; i < union.size(); i++) {    // 인구 이동
                    A[union.get(i)[0]][union.get(i)[1]] = peopleSize / unionSize;
                }
            }
            answer++;
            checkUnions();
        }
        System.out.println(answer);
    }

    private static void checkUnions() {
        unions = new LinkedList<>();    // 연합들 저장
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ArrayList<int[]> union = new ArrayList<>(); // 연합
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        union.add(pos);
                        for (int d = 0; d < 4; d++) {
                            int nr = pos[0] + dr[d];
                            int nc = pos[1] + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                                int diff = Math.abs(A[pos[0]][pos[1]] - A[nr][nc]);
                                if (diff >= L && diff <= R) {   // 인구 차이 확인
                                    q.add(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                }
                            }
                        }
                    }
                    if (union.size() > 1) { // 연합에 나라가 한개보다 많다면 -> 연합 맞음
                        unions.add(union);
                    }
                }
            }
        }
    }
}
