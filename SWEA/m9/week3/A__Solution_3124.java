package SWEA.m9.week3;

import java.util.*;
// kruskal, prim

public class A__Solution_3124 {
    static class Edge implements Comparable<Edge> {
        int from, to, val;
        Edge(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }
        @Override
        public int compareTo(Edge o) {
            return this.val-o.val;
        }
    }
    static class Vertex implements Comparable<Vertex> {
        int v, val;
        Vertex(int v, int val) {
            this.v = v;
            this.val = val;
        }
        @Override
        public int compareTo(Vertex o) {
            return this.val-o.val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            int[][] edgesArr = new int[V+1][V+1];
            ArrayList<Edge> edgeList = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int val = sc.nextInt();
                edgesArr[from][to] = val;
                edgesArr[to][from] = val;
                edgeList.add(new Edge(from, to, val));
                edgeList.add(new Edge(to, from, val));
            }
            long result;
            int cnt;

//            result = 0;
//            cnt = 0;
//            boolean[] visited = new boolean[V+1];
//            PriorityQueue<Vertex> minEdges = new PriorityQueue<>();
//            minEdges.offer(new Vertex(1, 0));
//            while (true) {
//                while (visited[minEdges.peek().v]) minEdges.poll();
//                Vertex minV = minEdges.poll();
//                int minIdx = minV.v;
//                int val = minV.val;
//                visited[minIdx] = true;
//                result += val;
//
//                if (++cnt == V) break;
//                for (int v = 1; v <= V; v++) {
//                    if (!visited[v] && edgesArr[minIdx][v]!=0) {
//                        minEdges.offer(new Vertex(v, edgesArr[minIdx][v]));
//                    }
//                }
//
//            }
//            System.out.printf("#%d %d\n", tc, result);
//----------------------------------------------------크루스칼---------------------------------------------
            result = 0;
            // make
            int[] parents = new int[V+1];
            for (int i = 1; i < parents.length; i++) {
                parents[i] = i;
            }

            Collections.sort(edgeList);
            cnt = 0;
            for (int i = 0; i < edgeList.size(); i++) {
                if (union(parents, edgeList.get(i).from, edgeList.get(i).to)) {
                    result += edgeList.get(i).val;
                    if (++cnt == V) break;
                }
            }
            System.out.printf("#%d %d\n", tc, result);

        }
    }

    private static boolean union(int[] parents, int from, int to) {
        int fRoot = find(parents, from);
        int tRoot = find(parents, to);
        if (fRoot == tRoot) return false;
        parents[tRoot] = fRoot;
        return true;

    }

    private static int find(int[] parents, int v) {
        if (parents[v] == v) return v;
        return parents[v] = find(parents, parents[v]);
    }
}
