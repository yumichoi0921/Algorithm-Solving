package Algorithm.permu_combi_subset.permutation;
// 비트마스킹
import java.util.Arrays;

public class PermutationTest_bit {

	static int N = 3, R = 2;
	static int[] input;
	static int[] numbers;	// 순열 저장 배열
	
	public static void main(String[] args) {
		input = new int[]{1, 4, 7};
		numbers = new int[R];
		
		permutation(0, 0);
	}

	// idx -> 수가 들어갈 위치(현재까지 뽑은 순열의 개수)
	private static void permutation(int idx, int flag) {
		if(idx == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수 시도
		for (int i = 0; i < N; i++) {
			// 사용중인 수이면 다음 수로
			if((flag & 1<<i) != 0) continue;
			numbers[idx] = input[i];	// 순열 조합에 수 넣기
					
			// 다음 자리 순열을 뽑으로 감
			permutation(idx+1, flag|1<<i);
		}
	}
	

}
