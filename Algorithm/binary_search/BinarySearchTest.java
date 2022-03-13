package Algorithm.binary_search;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr = {10, 4, 6, 20, 35, 7};
		Arrays.sort(arr); // 4 6 7 10 20 35
		System.out.println(binarySearch(arr, 6));
		System.out.println(binarySearch(arr, 35));
		System.out.println(binarySearch(arr, 12));
		

		System.out.println(Arrays.binarySearch(arr, 6));
		System.out.println(Arrays.binarySearch(arr, 35));
		System.out.println(Arrays.binarySearch(arr, 12));
	}
	
	// key에 해당하는 원소의 인덱스 리턴
	static int binarySearch(int[] arr, int key) {
		int start = 0, end = arr.length-1;
		
		while(start <= end) {
			int mid = (start+end);
			if(key == arr[mid]) return mid;
			
			if(key > arr[mid]) {
				start = mid + 1;
			} else if(key < arr[mid]) {
				end = mid - 1;
			}
		}
		// 못찾았다면
		return -1;
	}

}
