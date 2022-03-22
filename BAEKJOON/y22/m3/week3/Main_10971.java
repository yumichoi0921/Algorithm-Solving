// 외판원 순회
// 백트래킹
package BAEKJOON.y22.m3.week3;

import java.util.Scanner;

public class Main_10971 {
    static int N;
    static int[][] costMap;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        costMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costMap[i][j] = sc.nextInt();
            }
        }

        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            dfs(i, visited, i, 0, 0);   // i에서 출발하여 i로 돌아오는 루트 확인
        }
        System.out.println(answer);

    }

    private static void dfs(int des, boolean[] visited, int idx, int cnt, int cost) {
        if (cost > answer) return;              // 이제까지 여행한 비용이 최소값보다 크다면 더이상 볼 필요 없음
        if (cnt == N - 1) {                     // 출발지를 제외한 모든 도시 방문했을 때
            if (costMap[idx][des] != 0) {       // 마지막 방문지에서 출발지로 가는 길이 있다면 -> 이거 놓침
                answer = Math.min(answer, cost + costMap[idx][des]);    // 비용 최솟값 업데이트
            }
            return;
        }

        for (int j = 0; j < N; j++) {
            if (costMap[idx][j] != 0 && !visited[j]) {  // idx에서 j로 가는 길이 있고 아직 j를 방문하지 않았다면
                visited[j] = true;
                dfs(des, visited, j, cnt + 1, cost + costMap[idx][j]);  // 다음 시작지 j, 방문 지역 증가, 비용 증가
                visited[j] = false;
            }
        }
    }
}
