package Algorithm.permu_combi_subset.subset;

import java.util.Scanner;

public class S1_SubsetTest {

	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static int cnt;
	static int[] ans;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		isSelected = new boolean[N];
		cnt = 0;
		ans = new int[N];

		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println("경우의 수: " + cnt);
		
	}
	
	private static void generateSubset(int idx) {
		if(idx == N) {
			cnt++;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					ans[i] = arr[i];
					System.out.print(ans[i] + " ");
				}
//				System.out.print((isSelected[i]? arr[i] : "X")+" ");
			}
			System.out.println();
			return;
		}
		// 현재 원소를 부분집합에 넣기
		isSelected[idx] = true;
		generateSubset(idx+1);
		
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[idx] = false;
		generateSubset(idx+1);
	}

}
