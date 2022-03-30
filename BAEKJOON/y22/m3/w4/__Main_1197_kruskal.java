// 최소스패닝트리
// kruskal
package BAEKJOON.y22.m3.w4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class __Main_1197_kruskal {
    static int V, E;
    static ArrayList<Edge> edgeList;
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        edgeList = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            int val = sc.nextInt();
            edgeList.add(new Edge(s, e, val));
        }

        int answer = kruskal();
        System.out.println(answer);
    }

    private static int kruskal() {
        int answer = 0;
        // sort: 정렬
        Collections.sort(edgeList, (o1, o2) -> {
            return o1.val - o2.val;
        });

        // make: 모든 정점 자신이 대표자가 되게함
        parents = new int[V];
        make();

        int cnt = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            if (union(edgeList.get(i).s, edgeList.get(i).e)) {
                answer += edgeList.get(i).val;
                cnt++;
                if (cnt == V - 1) break;
            }
        }
        return answer;
    }

    private static void make() {
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    // 두 정점을 하나의 집합으로 합치기(대표자 이용)
    private static boolean union(int start, int end) {
        int sRoot = find(start);
        int eRoot = find(end);
        if (sRoot == eRoot) return false;    // 이미 같은 집합이므로 합치지 않음

        // 다른 집합이면 대표자 합치기
        parents[eRoot] = sRoot;
        return true;
    }

    // vertex가 속한 집합 대표자 찾기
    private static int find(int vertex) {
        if (parents[vertex] == vertex) return vertex;    // 자신이 대표자일 때 자기 리턴
        return parents[vertex] = find(parents[vertex]);   // 부모의 대표자 찾아서 그걸 자신의 대표자로 만들어 리턴
    }

    static class Edge {
        int s, e, val;

        public Edge(int s, int e, int val) {
            this.s = s;
            this.e = e;
            this.val = val;
        }
    }
}
