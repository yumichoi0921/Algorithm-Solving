package Programmers.y22.m3.w5;

public class 행렬_테두리_회전하기 {
    public static void main(String[] args) {
        int[][] queries = new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        System.out.println(solution(6, 6, queries));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = ++num;
            }
        }
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int q = 0; q < queries.length; q++) {
            int sr = queries[q][0] - 1;
            int sc = queries[q][1] - 1;
            int er = queries[q][2] - 1;
            int ec = queries[q][3] - 1;
            int start = map[sr][sc];
            answer[q] = start;
            int r = sr;
            int c = sc;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                while (true) {
                    if (nr < sr || nr > er || nc < sc || nc > ec) break;
                    if (nr == sr && nc == sc) {
                        map[r][c] = start;
                        break;
                    }
                    map[r][c] = map[nr][nc];
                    answer[q] = Math.min(answer[q], map[r][c]);
                    r = nr;
                    c = nc;
                    nr = r + dr[d];
                    nc = c + dc[d];
                }
            }
        }
        return answer;
    }
}
