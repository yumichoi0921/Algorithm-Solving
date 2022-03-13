package BAEKJOON.y21.m9.week4;

import java.util.ArrayList;
import java.util.Scanner;

// 게리맨더링
// 구역 나누기 - 부분집합
// 구역이 서로 연결되어있는지 확인 - dfs
// 최소 인구차 구하기
public class Main_17471 {
    static int N, res, zCnt;
    static int[] zones;
    static int[][] adjMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 구역 개수
        zones = new int[N];   // 구역별 인구
        adjMatrix = new int[N][N];  // 인접배열
        for (int i = 0; i < N; i++) {
            zones[i] = sc.nextInt();
        }
        for (int from = 0; from < N; from++) {
            int e = sc.nextInt();
            for (int j = 0; j < e; j++) {
                int to = sc.nextInt() - 1;
                adjMatrix[from][to] = 1;
                adjMatrix[to][from] = 1;
            }
        }

        res = Integer.MAX_VALUE;
        powerset(new boolean[N], 0, 0);
        System.out.println(res = res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void powerset(boolean[] v, int idx, int cnt) {
        if (idx == v.length) {
            if (!isAvailable(v)) return;
            int z1 = 0, z2 = 0;
            for (int i = 0; i < N; i++) {
                if (v[i]) z1 += zones[i];
                else z2 += zones[i];
            }
            res = Math.min(res, Math.abs(z1 - z2));
            return;
        }

        v[idx] = true;
        powerset(v, idx + 1, cnt + 1);
        v[idx] = false;
        powerset(v, idx + 1, cnt);
    }

    private static boolean isAvailable(boolean[] sel) {
        ArrayList<Integer> zone1 = new ArrayList<>();
        ArrayList<Integer> zone2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (sel[i]) zone1.add(i);
            else zone2.add(i);
        }
        if (zone1.size() == 0 || zone2.size() == 0) return false;

        boolean[] v = new boolean[N];
        isConnected(zone1, zone1.get(0), v);
        isConnected(zone2, zone2.get(0), v);
        for (int i = 0; i < N; i++) {
            if (!v[i]) return false;
        }
        return true;
    }

    private static void isConnected(ArrayList<Integer> zone, Integer idx, boolean[] visited) {
        visited[idx] = true;
        for (int i = 0; i < zone.size(); i++) {
            if (!visited[zone.get(i)] && adjMatrix[idx][zone.get(i)] == 1) {
                isConnected(zone, zone.get(i), visited);
            }
        }
    }
}
