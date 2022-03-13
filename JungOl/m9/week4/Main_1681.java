package JungOl.m9.week4;

import java.util.Scanner;
// 해밀턴 순환회로
// 순열
// 백트래킹
public class Main_1681 {
    static int N, res;
    static int[][] map;
    static int[] sequence;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];        // 비용배열
        sequence = new int[N+1];    // 순서배열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean[] v = new boolean[N];   // 방문배열
        sequence[0] = 0;                // 출발은 무조건 회사(0)부터
        v[0] = true;
        res = Integer.MAX_VALUE;
        permutation(v, 1,  0);
        System.out.println(res);
    }

    private static void permutation(boolean[] v, int seq, int cost) {
        if (cost > res) return; // 현재 비용이 이제까지 최소비용보다 클 경우 리턴
        if (seq == N) {         // 모든 배송지 탐색
            if (map[sequence[seq-1]][sequence[0]] == 0) return; // 마지막 배송지에서 회사로 갈 수 없다면 리턴
            else {
                res = Math.min(res, cost+map[sequence[seq-1]][sequence[0]]);    // 현재 비용 + 마지막 배송지에서 회사까지 비용
                return;
            }
        }
        for (int i = 1; i < N; i++) {
            if (!v[i]) {
                if (map[sequence[seq-1]][i] == 0 ) continue;    // 이전 배송지에서 현재 장소까지 올 수 없다면 다른 장소 탐색
                sequence[seq] = i;
                v[i] = true;
                permutation(v, seq+1, cost+map[sequence[seq-1]][sequence[seq]]);    // 현재 비용+이전 배송지에서 현재 비송지까지 비용
                v[i] = false;
            }
        }
    }
}