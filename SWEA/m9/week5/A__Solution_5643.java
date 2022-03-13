package SWEA.m9.week5;
import java.util.*;

// 키 순서
// dfs
// bfs
// dp
// 생각...
public class A__Solution_5643 {
    static int N, M, result;
    static int[][] h1;
    static int[][] h2;
    static int[] taller;
    static int[] shorter;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            h1 = new int[N][N];
            h2 = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                h1[a][b] = 1;  // r-c<0
                h1[b][a] = -1;
                h2[a+1][b+1] = 1;  // r-c<0
            }


//            ------------------------------bfs------------------------------------------
            result = 0;
            taller = new int[N];
            shorter = new int[N];
            bfs(taller, 1);
            bfs(shorter, -1);
            for (int i = 0; i < N; i++) {
                if (taller[i]+shorter[i] == N-1) result++;
            };
//            System.out.printf("#%d %d\n", tc, result);
//            ------------------------------dfs------------------------------------------
            cnt = 0;
            result = 0;
            for (int i = 0; i < N; i++) {
                boolean[] v = new boolean[N];
                dfs(v, i, 1);
                dfs(v, i, -1);
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (v[j] && j != i) cnt++;
                }
                if (cnt==N-1) result++;
            }
//            System.out.println("dfs: "+cnt);
            System.out.printf("#%d %d\n", tc, result);
//            ------------------------------dfs_memo------------------------------------------
            cnt = 0;
            result = 0;
            int[][] memo = new int[N][N];
            boolean[] v = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (!v[i]) {
                    dfs_memo(v, memo, i, 1);
                    dfs_memo(v, memo, i, -1);
                }
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    cnt += memo[i][j];
                    cnt += memo[j][i];
                }
                if (cnt == N-1) result++;
            }
//            System.out.println("dfs_memo: "+cnt);
            System.out.printf("#%d %d\n", tc, result);

//            ------------------------------플로이드 워샬------------------------------------------
            result = 0;
            int[][] memo_f = new int[N][N];
            floyd_warshall(memo_f);
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    cnt += memo_f[i][j];
                    cnt += memo_f[j][i];
                }
                if (cnt==N-1) result++;
            }
            System.out.printf("#%d %d\n", tc, result);
        }

    }

    private static void floyd_warshall(int[][] memo_f) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i==k||j==k||i==j) continue;
                    if (h1[i][j] == 1) memo_f[i][j] = 1;
                    else if (memo_f[i][k] == 1 && memo_f[k][j] == 1) memo_f[i][j] = 1;
                }
            }
        }
    }

    private static void dfs_memo(boolean[] v, int[][] memo, int from, int status) {
        cnt++;
        v[from] = true;
        for (int to = 0; to < N; to++) {
            if (h1[from][to] == status) {   // 자신보다 크거나 작으면
                memo[from][to] = 1;         // 표시
                if (!v[to]) { // 자신보다 크거나/작은학생 탐색 안했으면 하러감
                    dfs_memo(v, memo, to, status);
                }
                for (int i = 0; i < N; i++) {   // 자신보다 크거나/작은 학생들의 키 비교 자신에게 저장장
                    if (memo[to][i] == 1) memo[from][i] = 1;
                }
            }
        }
    }

    private static void dfs(boolean[] v, int from, int status) {
        cnt++;
        v[from] = true;
        for (int to = 0; to < N; to++) {
            if (h1[from][to] == status && !v[to]) {
                dfs(v, to, status);
            }
        }
    }

    private static void bfs(int[] height, int status) {
        for (int i = 0; i < N; i++) {
            height[i]= -1;
            Queue<Integer> tq = new LinkedList<>();
            tq.add(i);
            boolean[] v = new boolean[N];
            v[i] = true;
            while (!tq.isEmpty()) {
                height[i]++;
                int from  = tq.poll();
                for (int to = 0; to < N; to++) {
                    if (h1[from][to] == status && !v[to]) {
                        v[to] = true;
                        tq.add(to);
                    }
                }
            }
        }
    }
}
