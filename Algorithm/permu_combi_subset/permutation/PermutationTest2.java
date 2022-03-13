package Algorithm.permu_combi_subset.permutation;

import java.util.Arrays;

// N개의 서로 다른 수에서 R개를 뽑는 순열
public class PermutationTest2 {

	static int N = 3, R = 2;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		input = new int[] {1, 4, 7};
		numbers = new int[R];
		isSelected = new boolean[N];
		
		permutation(0);
	}

	// cnt -> 수가 들어갈 위치
	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수들이 들이었는 배열의 인덱스에 대해 시도
		for (int i = 0; i < N; i++) {
			// 인덱스에 해당하는 수가 사용중이면 다음 수로
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];	// 순열 조합에 수 넣기
			isSelected[i] = true;	// 순열 조합에 사용중으로 바꾸기
			
			// 다음 자리 순열을 뽑으로 감
			permutation(cnt+1);
			// 맨 앞에 1, 2, 3 모두 오는 경우를 생각해야 하므로 사용중 해제
			isSelected[i] = false;
		}
	}

}
