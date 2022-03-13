package Algorithm.permu_combi_subset.permutation;

import java.util.Arrays;

// 1, 2, 3 순열
public class PermutationTest {

	static int N = 3, R = 3;
	static int[] numbers;	// 순열 저장 배열
	static boolean[] isSelected;	// 인덱스에 해당하는 숫자가 사용 중인지 저장하는 배열
	
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		permutation(0);
	}

	// cnt -> 수가 들어갈 위치(현재까지 뽑은 순열의 개수)
	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수 시도
		for (int i = 1; i <= N; i++) {
			// 사용중인 수이면 다음 수로
			if(isSelected[i]) continue;
			numbers[cnt] = i;	// 순열 조합에 수 넣기
			isSelected[i] = true;	// 순열 조합에 사용중으로 바꾸기
			
			// 다음 자리 순열을 뽑으로 감
			permutation(cnt+1);
			// 맨 앞에 1, 2, 3 모두 오는 경우를 생각해야 하므로 사용중 해제
			isSelected[i] = false;
		}
	}

}
