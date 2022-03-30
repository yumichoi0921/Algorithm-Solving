// 최소스패닝트리
// prim -> 메모리초과 => 우선순위큐로 풀기
package BAEKJOON.y22.m3.w4;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class __Main_1197_prim_pq {
    static int V, E;
    static ArrayList<Node>[] edgeList;  // 정점별 간선 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        edgeList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            int val = sc.nextInt();
            edgeList[s].add(new Node(e, val));
            edgeList[e].add(new Node(s, val));
        }

        int answer = 0;
        int cnt = 0;
        boolean[] visited = new boolean[V];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        pq.add(new Node(0, 0)); // 임의로 0부터 탐색
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.e]) continue;

            answer += node.val;
            visited[node.e] = true;

            if (++cnt == V) break;

            for (int i = 0; i < edgeList[node.e].size(); i++) {
                Node n = edgeList[node.e].get(i);
                if (!visited[n.e]) pq.add(n);
            }
        }
        System.out.println(answer);
    }


    static class Node {
        int e, val;

        public Node(int e, int val) {
            this.e = e;
            this.val = val;
        }
    }
}
