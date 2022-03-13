package SWEA.m8.week4;

import java.util.*;

// 창용 마을 무리의 개수 - dfs
// union-find로 풀어볼것
public class Solution_7465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 각각 창용 마을에 사는 사람의 수
            int M = sc.nextInt();   //  서로를 알고 있는 사람의 관계 수
            int[][] relation = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                relation[from][to] = 1;
                relation[to][from] = 1;
            }

            ArrayList<boolean[]> group = new ArrayList<>();
            boolean[] visited = new boolean[N+1];
            for (int i = 1; i < relation.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(relation, visited, i);
//                    System.out.println(Arrays.toString(visited));
                    isSelected(group, visited); // 중복된 무리 체크
                }
                Arrays.fill(visited, false);
            }
            System.out.printf("#%d %d\n", tc, group.size());
        }
    }

    private static void isSelected(ArrayList<boolean[]> group, boolean[] visited) {
        boolean flag = false;
        for (int i = 0; i < group.size(); i++) {
            flag = false;
            if (Arrays.equals(group.get(i), visited)){
                flag = true;
                break;
            }
        }
        if (!flag) {
            group.add(visited.clone());
        }
    }

    private static void dfs(int[][] relation, boolean[] visited, int idx) {
        for (int i = 1; i < relation[idx].length; i++) {
            if (relation[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(relation, visited, i);
            }
        }
    }
}
