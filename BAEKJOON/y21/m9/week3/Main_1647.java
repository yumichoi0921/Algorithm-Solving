package BAEKJOON.y21.m9.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 도시 분할 계획
// 크루스칼
public class Main_1647 {
    static int N, M;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 집의 개수
        M = sc.nextInt();   // 길의 개수
        edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            edgeList.add(new Edge(s, d, e));
        }

        // make
        int[] parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        // sort
        Collections.sort(edgeList);

        int cnt = 0;
        int result = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            if (union(edgeList.get(i).s, edgeList.get(i).d, parents)) {
                result += edgeList.get(i).e;
                // 기존 크루스칼처럼 진행
                // 마을 내 집들 사이 최소 비용은 유지
                // 마을 두 개여야 함
                // 마을 N-1개까지 연결하면 집1개 마을, 집N-1개마을 두개 마을 생성됨
                // 간선리스트가 정렬되어 있으므로 두 마을 내 집들은  최소 비용유지됨
                if (++cnt == N - 2) break;
            }
        }
        System.out.println(result);
    }

    private static boolean union(int s, int d, int[] parents) {
        int sRoot = find(s, parents);
        int dRoot = find(d, parents);
        if (sRoot == dRoot) return false;
        parents[dRoot] = sRoot;
        return true;
    }

    private static int find(int i, int[] parents) {
        if (parents[i] == i) return parents[i];
        return parents[i] = find(parents[i], parents);
    }

    static class Edge implements Comparable<Edge> {
        int s, d, e;

        Edge(int s, int d, int e) {
            this.s = s;
            this.d = d;
            this.e = e;
        }

        @Override
        public int compareTo(Edge o) {
            return this.e - o.e;
        }
    }
}
