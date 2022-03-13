package SWEA.september.week3;

import java.util.ArrayList;
import java.util.Scanner;
// 프로세서 연결하기
// dfs
// 부분집합
// 배열 복구
public class A_Solution_1767 {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int core, line;
    static class Core {
        int r, c;
        Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            int[][] arr = new int[N][N];    // 0은 빈 cell // 1은 core
            ArrayList<Core> cores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i==0||i==N-1||j==0||j==N-1) continue;
                    if (arr[i][j] == 1) cores.add(new Core(i, j));
                }
            }

            core = Integer.MIN_VALUE;
            line = Integer.MAX_VALUE;
            dfs(arr, cores, 0, 0);
            System.out.printf("#%d %d\n", tc, line);

        }
    }




    private static void dfs(int[][] arr, ArrayList<Core> cores, int idx, int coreCnt) {
        if (idx == cores.size()) {
            if (coreCnt > core) {   // 선택된 코어 개수로 갱신
                core = coreCnt;
                line = getLength(arr);
            } else if (coreCnt == core) {   // 코어 개수가 같다면 최소 전선 길이 합
                line = Math.min(line, getLength(arr));
            }
            return;
        }

        int r = cores.get(idx).r;
        int c = cores.get(idx).c;
        // idx 코어 선택 -> 4방향 시도
        for (int d = 0; d < 4; d++) {
            if (isAvailable(arr, r, c, d)) {
                // 전선 놓기
                setStatus(arr, r, c, d, 2);
                // 다음 코어로
                dfs(arr, cores, idx+1, coreCnt+1);
                // 놓았던 전선 지우기
                setStatus(arr, r, c, d, 0);
            }
        }
        // idx 코어 선택 안함
        dfs(arr, cores, idx+1, coreCnt);
    }

    private static void setStatus(int[][] arr, int r, int c, int d, int s) {
        int nr = r;
        int nc = c;
        while (true) {
            nr = nr +dr[d];
            nc = nc +dc[d];
            if (!(nr>=0&&nr<N&&nc>=0&&nc<N)) break;
            arr[nr][nc] = s;
        }
    }

    private static boolean isAvailable(int[][] arr, int r, int c, int d) {
        int nr = r;
        int nc = c;
        while (true) {
            nr = nr +dr[d];
            nc = nc +dc[d];
            if (!(nr>=0&&nr<N&&nc>=0&&nc<N)) break;
            if (arr[nr][nc] >= 1) return false;
        }
        return true;
    }

    private static int getLength(int[][] arr) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 2) res++;
            }
        }
        return res;
    }
}
