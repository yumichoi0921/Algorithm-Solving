package Y2022_spring_SKICT;

public class Solution2 {

    public static void main(String[] args) {
//        solution(5, true);
    }

    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = {};
        answer = new int[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int[][] dirs = {{0, 1, 2, 3}, {1, 0, 3, 2}};
        int dir;
        int cnt = n - 1;
        int start = 1;
        int[] pos = new int[]{0, 0};
        if (clockwise) {
            dir = 0;
        } else {
            dir = 1;
        }
        while (cnt > 0) {
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < cnt; i++) {
                    System.out.println(pos[0] + " " + pos[1]);
                    answer[pos[0]][pos[1]] = start + i;
                    pos[0] += dr[dirs[dir][d]];
                    pos[1] += dc[dirs[dir][d]];
                }
            }
            pos[0]++;
            pos[1]++;
            start += cnt;
            cnt = cnt - 2;
        }
        if (n % 2 == 1) answer[n / 2][n / 2] = start;
        return answer;
    }
}
