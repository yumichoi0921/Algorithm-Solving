package Algorithm.backtrack;

import java.util.Scanner;

public class SubsetSumTest {

	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static int cnt1, cnt2;
	static int S;
	static int callCnt1, callCnt2;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		isSelected = new boolean[N];
		cnt1 = cnt2 = callCnt1 = callCnt2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		generateSubset(0, 0);
		System.out.println("경우의 수: " + cnt1 + " 함수 호출 횟수: " + callCnt1);
		generateSubset_pruning(0, 0);
		System.out.println("경우의 수: " + cnt2 + " 함수 호출 횟수: " + callCnt2);
		
	}
	
	// 가지치기 안함
	private static void generateSubset(int idx, int sum) {
		callCnt1++;
		if(idx == N) {
			// 부분집합 완성

			// 부분집합의 합 == 목표합 체크
			if (sum == S) {
				cnt1++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) {
						System.out.print((isSelected[i]? arr[i] : "X")+" ");
					}
				}
				System.out.println();
			}
			return;
		}
		// 현재 원소를 부분집합에 넣기
		isSelected[idx] = true;
		generateSubset(idx+1, sum+arr[idx]);
		
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[idx] = false;
		generateSubset(idx+1, sum);
	}
	
	// 가지치기함
	private static void generateSubset_pruning(int idx, int sum) {
		callCnt2++;
		// 부분집합의 합 == 목표합 체크
		// sum: 기존까지 부분집합 구성원소들의 합
		if (sum == S) {
			cnt2++;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					System.out.print((isSelected[i]? arr[i] : "X")+" ");
				}
			}
			System.out.println();
			return;
		}  
		// 기존까지 부분집합 원소 합이 sum보다 크거나 || 집합의 모든 원소를 더해도 S보다 작을 경우
		if(sum > S || idx == N) return; 
		
		// 현재 원소를 부분집합에 넣기
		isSelected[idx] = true;
		generateSubset_pruning(idx+1, sum+arr[idx]);
		
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[idx] = false;
		generateSubset_pruning(idx+1, sum);
	}

}
