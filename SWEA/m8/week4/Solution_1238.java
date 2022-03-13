package SWEA.m8.week4;

import java.util.*;
// 그래프 탐색-bfs-레벨별로 제일 큰 노드 찾기
// 너비탐색 레벨 나누기
public class Solution_1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int sVertex = sc.nextInt();

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < 101; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < N/2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                adjList.get(from).add(to);
            }
//            for (int i = 1; i < adjList.size(); i++) {
//                System.out.println(i+" "+adjList.get(i).toString());
//            }

            Queue<Integer> Q = new LinkedList<>();
            boolean[] visited = new boolean[101];

            visited[sVertex] = true;    // 첫 노드 방문
            Q.offer(sVertex);
            int level = 0;  // 현재 레벨
            int level_max = sVertex;    // 현재 레벨의 max 노드
            while (!Q.isEmpty()) {
//                System.out.println("=========level "+level+"============");
                int size = Q.size();    // 현재 레벨에 있는 노드 개수
                level_max = 0;  // 레벨마다 max 노드 초기화
                for (int i = 0; i < size; i++) {    // 현재 레벨에 있는 노드 개수만큼 반복
                    int v = Q.poll();   // 현재 레벨에 있는 노드
                    level_max = Math.max(level_max, v); // 현재 레벨에서 max 노드 비교
//                    System.out.print(v +" ");
                    for (int j = 0; j < adjList.get(v).size(); j++) {   // 현재 노드의 인접 노드 확인
                        if (!visited[adjList.get(v).get(j)]) {
                            Q.offer(adjList.get(v).get(j));
                            visited[adjList.get(v).get(j)] = true;
                        }
                    }
                }
                level++;
            }
            System.out.printf("#%d %d\n", tc, level_max);
        }
    }
}
