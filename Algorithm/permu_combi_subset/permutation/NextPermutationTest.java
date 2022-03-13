package Algorithm.permu_combi_subset.permutation;

import java.util.Arrays;

// 오름차순을 순열을 내림차순으로 
public class NextPermutationTest {

	public static void main(String[] args) {

		int[] input = {7, 1, 4};
		// 가장 작은 순열 만들기
		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
		} while (next_Permutation(input));


	}
	
	// 다음 큰 순열이 있으면 true, 없으면  false;
	private static boolean next_Permutation(int[] numbers) {
		int N = numbers.length;
		
		// 1. 꼭대기 i를 찾는다. 꼭대기를 통해  교환위치(i-1)찾기
		int i = N-1;
		while (i > 0 && numbers[i-1] >= numbers[i]) i--;
		// 꼭대기가 첫번재에 있다면
		if (i == 0) return false;
		
		// 2. i-1위치값하고 교환할 큰 값을 찾기
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) j--;
		
		// 3. i-1위치 값과 j위치값 교환
		swap(numbers, i-1, j);
		
		// 4. 꼭대기부터 맨 뒤까지 내림차순형태의 순열을 오름차순으로 정렬
		int k = N-1;
		while(i < k) {
			swap(numbers, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
