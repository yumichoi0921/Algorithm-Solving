package Algorithm.dynamic_programming;

import java.util.Scanner;

public class DP3_KnapsackTest {

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
		
		int[] D = new int[W+1];
		
		for (int i = 1; i <= N; i++) {
			for (int w = W; w >= weights[i]; w--) {
				D[w] = Math.max(D[w], profits[i]+D[w-weights[i]]);
				
			}
		}
		System.out.println(D[W]);
		
		
	}

}
