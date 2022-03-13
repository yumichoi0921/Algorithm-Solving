package BAEKJOON.y21.m9.week3;

import java.util.*;

// 네트워크 연결
// prim, kruskal
public class Main_1922 {
    static int N, M;
    static int[][] lineValue;   // 인접배열
    static ArrayList<int[]> lineList; // 간선리스트
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 컴퓨터의 수
        M = sc.nextInt();   // 연결할 수 있는 선의 수
        lineValue = new int[N + 1][N + 1];
        lineList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int v = sc.nextInt();
            lineValue[from][to] = v;    // 인접배열
            lineValue[to][from] = v;
            lineList.add(new int[]{from, to, v});  // 간선리스트
        }

        result = 0;
        prim();
        result = 0;
        kruskal();


    }

    // kruskal-union 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
    private static boolean union(int from, int to, int[] parents) {
        int fRoot = find(from, parents);
        int tRoot = find(to, parents);
        if (fRoot == tRoot) return false; // 이미 같은 집합 -> 신장트리에 포함되어 있음 -> 합치지 않음

        parents[tRoot] = fRoot;
        return true;
    }

    // kruskal-find vertex가 속한 집합의 대표자 찾기
    private static int find(int vertex, int[] parents) {
        if (vertex == parents[vertex]) return vertex;
        return parents[vertex] = find(parents[vertex], parents);
    }

    private static void kruskal() {
        // make - 모든 원소 대표자는 자기 자신
        int[] parents = new int[N + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        // sort
        Collections.sort(lineList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int cnt = 0;
        // 간선 하나씩 시도
        for (int i = 0; i < lineList.size(); i++) {
            if (union(lineList.get(i)[0], lineList.get(i)[1], parents)) {
                result += lineList.get(i)[2];
                cnt++;
                if (cnt == N) break;
            }
        }
        System.out.println("kruskal: " + result);

    }

    private static void prim() {
        boolean[] visited = new boolean[N + 1];
        int[] minValue = new int[N + 1];
        Arrays.fill(minValue, Integer.MAX_VALUE);
        minValue[1] = 0;

        for (int i = 1; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && minValue[j] < min) {
                    min = minValue[j];
                    minVertex = j;
                }
            }

            visited[minVertex] = true;
            result += min;

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && lineValue[minVertex][j] != 0 && lineValue[minVertex][j] < minValue[j]) {
                    minValue[j] = lineValue[minVertex][j];
                }
            }
        }
        System.out.println("prim: " + result);
    }

}
