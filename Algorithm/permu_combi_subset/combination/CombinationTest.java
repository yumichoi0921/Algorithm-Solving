package Algorithm.permu_combi_subset.combination;

import java.util.Arrays;

// N개의 서로 다른 수 R개 뽑는 조합
public class CombinationTest {

	static int N = 3, R = 2;
	static int[] input;
	static int[] numbers;

	public static void main(String[] args) {
		input = new int[] {1, 4, 7};
		numbers = new int[R];
		
		combination(0, 0);
	}

	// cnt -> 수가 들어갈 위치, start->시작 인덱스
	private static void combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// start인덱스부터 가능한 모든 수 고려 
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];	// 조합에 수 넣기
			// 다음 자리 조합을 뽑으로 감
			combination(cnt+1, i+1);
		}
	}

}
