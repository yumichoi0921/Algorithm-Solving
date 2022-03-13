package Algorithm.dynamic_programming;

import java.util.Scanner;

public class DP2_MinCoinTest {
	// 동전 1, 4, 6원
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1];
		
		D[0] = 0;
		for (int i = 1; i <= money; i++) {
			int min = Integer.MAX_VALUE;
			// 1원을 쓴다면
			if (i >= 1 && D[i-1]+1<min) {
				min = D[i-1]+1;
			}
			// 4원을 쓴다면
			if (i >= 4 && D[i-4]+1<min) {
				min = D[i-4]+1;
			}
			// 6원을 쓴다면
			if (i >= 6 && D[i-6]+1<min) {
				min = D[i-6]+1;
			}
			
			D[i] = min;
		}
		System.out.println(D[money]);

	}

}
