package Algorithm.io;

import java.util.Arrays;

public class A01_ShiftTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(arr));
		rightShift(arr);
		System.out.println(Arrays.toString(arr));
		leftShift(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void leftShift(int[] arr) {
		// TODO Auto-generated method stub
		int temp = arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp;
	}

	private static void rightShift(int[] arr) {
		// TODO Auto-generated method stub
		int temp = arr[arr.length-1];
		for (int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

}
