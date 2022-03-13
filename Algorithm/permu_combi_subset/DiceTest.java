package Algorithm.permu_combi_subset;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	
	static int N;	// 주사위를 던질 횟수 -> 몇개 뽑을 건지
	static int numbers[];	// 수열
	static int totalCnt;	// 수열갯수 
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 주사위를 던진 횟수
		numbers = new int[N];
		totalCnt = 0;
		
		int M = sc.nextInt();	// 어떤 수열?
		
		switch (M) {
		case 1:	// 중복순열
			dice1(0);
			break;
		
		case 2:	// 순열
			isSelected = new boolean[7];
			dice2(0);
			break;
		
		case 3:	// 중복조합
			dice3(0, 1);
			break;
		
		case 4:	// 조합
			dice4(0, 1);
			break;
		
		default:
			break;
		}
		System.out.println("경우의 수: " + totalCnt);
	}
	
	
	// 중복순열
	private static void dice1(int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
		
	}
	
	// 순열
	private static void dice2(int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			// 중복 체크
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			
			dice2(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	// 중복조합
		private static void dice3(int cnt, int start) {
			
			if (cnt == N) {
				totalCnt++;
				System.out.println(Arrays.toString(numbers));
				return;
			}
			for (int i = start; i <= 6; i++) {
				numbers[cnt] = i;
				dice3(cnt+1, i);	// 지금과 같은 수도 포함가능
			}
		}
	
	// 조합
	private static void dice4(int cnt, int start) {
		
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}

}
