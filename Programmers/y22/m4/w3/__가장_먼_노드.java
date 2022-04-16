package Programmers.y22.m4.w3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class __가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Node>[] edgeList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            edgeList[edge[i][0] - 1].add(new Node(edge[i][1] - 1, 1));
            edgeList[edge[i][1] - 1].add(new Node(edge[i][0] - 1, 1));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.v - o2.v);
        pq.add(new Node(0, 0));

        int maxV = Integer.MIN_VALUE;
        int maxCnt = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.e]) continue;
            visited[node.e] = true;

            System.out.println(node.e + " " + node.v + " " + maxV);

            if (maxV < node.v) {
                maxV = node.v;
                maxCnt = 1;
            } else if (maxV == node.v) {
                maxCnt++;
            }

            for (int i = 0; i < edgeList[node.e].size(); i++) {
                Node newNode = edgeList[node.e].get(i);
                pq.add(new Node(newNode.e, node.v + newNode.v));
                System.out.println(newNode.e);

            }
        }


        return maxCnt;
    }

    static class Node {
        int e, v;

        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }

}
