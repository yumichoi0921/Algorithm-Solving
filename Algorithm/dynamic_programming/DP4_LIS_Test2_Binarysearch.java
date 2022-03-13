package Algorithm.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;
// 정렬된 배열에서  Arrays.binarysearch(arr, k)를 하면 arr에서 k값의 인덱스 알 수 있음
// 만약 arr에 k가 없다면 -(만약 k값이 있다고 가정할 때 정렬을 유지하는 insert point)-1 리턴
// Arrays.binarysearch(arr, from, to, k) -> from(inclusive)부터 to(exclusive)까지 탐색
public class DP4_LIS_Test2_Binarysearch {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];	// 모든 원소의 값은 다름
		int[] LIS = new int[N];	// 해당 길이의 증가수열 중 맨 끝 값(최소값으로 유지)
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0;	// LIS에 채워진 원소 수	
		for (int i = 0; i < N; i++) {			
			// 중복값이 없으므로 탐색 실패: 음수값 -> 삽입 위치 환산
			int tmp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1;
			LIS[tmp] = arr[i];
			
			// 추가된 위치가 맨 뒤라면 사이즈 증가 (끝에 추가된 것)
			if (tmp == size) size++;
			// 만약 추가되지 않고 대체되면 사이즈 증가되는 것 X
		}
		System.out.println(size);
		
		
				
	}

}
