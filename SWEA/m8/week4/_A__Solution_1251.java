package SWEA.m8.week4;

import java.util.Arrays;
import java.util.Scanner;

// 하나로-최소신장트리-prim// kruskal로 풀어보기
public class _A__Solution_1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 섬의 개수
            int[][] island = new int[N][2]; // 0: x좌표 1: y좌표
            for (int i = 0; i < N; i++) {
                island[i][0] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                island[i][1] = sc.nextInt();
            }
            double E = sc.nextDouble(); // 환경 부담 세율
            // 환경 부담금 정책 : E * 각 해저터널 길이^2

            boolean[] visited = new boolean[N]; // 방문 배열
            double[] expense = new double[N]; // 비용 배열
            Arrays.fill(expense, Double.MAX_VALUE);
            expense[0] = 0;

            for (int i = 0; i < N; i++) {
                // 방문하지 않은 정점중 가장 비용이 작은 정점으로 이동
                int minIdx = -1;
                double minEx = Double.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && expense[j] < minEx) {
                        minIdx = j;
                        minEx = expense[j];
                    }
                }
                visited[minIdx] = true;

                // 현재 정점에서 방문하지 않은 정점까지의 비용 계산 후 업데이트
                for (int j = 0; j < N; j++) {
                    if (!visited[j]) {
                        double dis = Math.pow(island[minIdx][0]-island[j][0], 2) +
                                Math.pow(island[minIdx][1]-island[j][1], 2);
                        double val = E * dis;
                       if (val < expense[j]) {
                           expense[j] = val;
                       }
                    }
                }
            }
            double totalExpense = 0;
            for (int i = 0; i < expense.length; i++) {
                totalExpense += expense[i];
            }
            System.out.printf("#%d %.0f\n", tc, totalExpense);
        }
    }
}
