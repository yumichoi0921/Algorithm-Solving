package Y2022_spring_SKICT;

public class Solution4 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}};
        System.out.println(solution(5, edges));
    }

    public static long solution(int n, int[][] edges) {
        long answer = 0;
        boolean[][] hasEdge = new boolean[n][n];
        for (int i = 0; i < edges.length; i++) {
            hasEdge[edges[i][0]][edges[i][1]] = true;
            hasEdge[edges[i][1]][edges[i][0]] = true;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k || i == j) continue;
                    if (hasEdge[i][k] && hasEdge[k][j]) {
                        System.out.println(i + " " + k + " " + j);
                        answer++;
                    }
                }
            }
        }

//        System.out.println(i + " " + k + " " + j);
//        answer++;
        return answer;
    }


}
