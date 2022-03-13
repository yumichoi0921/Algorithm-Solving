package BAEKJOON.y21.m11.week1;
import java.util.Scanner;
// 바이러스
// dfs
public class Main_2606 {
    static int N, M, res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 컴퓨터 수
        M = sc.nextInt();   // 직접 연결되어 있는 컴퓨터 쌍의 수

        int[][] adjMatrix = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            adjMatrix[r][c] = 1;
            adjMatrix[c][r] = 1;
        }

        res = 0;
        boolean[] computer = new boolean[N+1];
        dfs(computer, adjMatrix, 1);
        System.out.println(res);

    }

    private static void dfs(boolean[] computer, int[][] adjMatrix, int start) {
        computer[start] = true;
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[start][i] == 1 && !computer[i]) {
                res++;
                dfs(computer, adjMatrix, i);
            }
        }
    }
}
