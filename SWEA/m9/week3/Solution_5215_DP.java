package SWEA.m9.week3;

import java.util.Scanner;
// 햄버거 다이어트
// DP
public class Solution_5215_DP {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 재료수
            int L = sc.nextInt();   // 칼로리 제한

            int[] taste = new int[N+1]; // 맛
            int[] kcal = new int[N+1];  // 칼로리
            int[][] hamburger = new int[N+1][L+1];
            for (int i = 1; i <= N; i++) {
                taste[i] = sc.nextInt();
                kcal[i] = sc.nextInt();
            }
            res = 0;

            for (int i = 1; i <= N; i++) {  // 재료번호
                for (int k = 1; k <= L; k++) {   // 칼로리 제한
                    if (kcal[i] > k) {  // 만약 지금 재료의 칼로리가 칼로리 제한보다 크다면
                        hamburger[i][k] = hamburger[i-1][k];    // 이전까지 재료중에서 칼로리 제한까지의 최적값 저장
                    } else {
                        // 지금 재료를 넣지 않았을 때 (이전까지 재료중에서 칼로리 제한까지의 최적값)
                        // 지금 재료를 넣었을 때 (이전까지 재료 중에서 칼로리 제한에서 지금 재료 칼로리를 뺀값까지의 최적값에 지금 재료의 맛의 합)
                        hamburger[i][k] = Math.max(hamburger[i-1][k], taste[i]+hamburger[i-1][k-kcal[i]]);
                    }
                }
            }
            res = hamburger[N][L];

            System.out.printf("#%d %d\n", tc, res);

            // 1차원 배열로 푸는 법
            res = 0;
            int[] memo = new int[L+1];
            for (int i = 1; i <= N; i++) {  // 재료번호
                for (int k = L; k >= kcal[i]; k--) {   // 칼로리 제한
                   memo[k] = memo[k] > memo[k-kcal[i]]+taste[i]? memo[k] : memo[k-kcal[i]]+taste[i];
                }
            }
            res = memo[L];
            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
