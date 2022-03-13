public class dfs_return {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N = 4;
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args) {
        map = new int[N][N];
        v = new boolean[N][N];
        dfs(0, 0, 1);
        print();

    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(int r, int c, int cnt) {
        v[r][c] = true;
        map[r][c] = cnt;
        if (r==N-1&&c==N-1) {
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if (nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
                dfs(nr, nc,cnt+1);
            }
        }
    }
}
