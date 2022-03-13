package Algorithm.dynamic_programming;

import java.util.Scanner;

public class DP3_KnapsackTest2_1Arr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 물건 갯수
		int W = sc.nextInt();	// 배낭 용량

		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[][] D = new int[N+1][W+1];
		
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				
				if (weights[i] <= w) {	// i번 물건을 가방에 넣을 수 있음
					D[i][w] = Math.max(D[i-1][w], profits[i]+D[i-1][w-weights[i]]);
				} else {	// 번 물건을 가방에 넣을 수 없음
					D[i][w] = D[i-1][w];
				}
				
			}
		}
		System.out.println(D[N][W]);
		
		
	}

}
