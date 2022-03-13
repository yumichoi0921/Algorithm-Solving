package Algorithm.backtrack;

import java.util.Scanner;
// 처음부터 퀸을 같은 행에 두지 않는 방식
// N개 퀸을 위협적이지 않게 놓는 모든 경우의 수

public class NQueenTest2 {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] col = new int[N+1];
		cnt = 0;
		setQueens(col, 1);
		System.out.println(cnt);
	}
	
	private static void setQueens(int[] col, int rowNo) {
		
		if(rowNo == col.length) {
			cnt++;
			return;
		}
		
		// 현재 퀸 1열부터 N열까지 놓기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i < col.length; i++) {
			col[rowNo] = i;	// i열에 놓아보기
			if(isAvailable(col, rowNo)) {	// 유먕성 체크: rowNo행까지 유망한지 체크
				setQueens(col, rowNo+1);	// 가능하면 다음 퀸으로
			}
			
		}
	}
	
	private static boolean isAvailable(int[] col, int rowNo) {
		for (int i = 1; i < rowNo; i++) {	// i: 이전 퀸
			// 같은 열에 있거나 대각선 열에 있다면 유망하지 않음
			if(col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == (rowNo-i)) return false;
		}
		return true;
	}

}
