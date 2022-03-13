package Algorithm.recursion;

public class R03_HanoiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hanoi(3, 1, 2, 3);
	}
	
	private static void hanoi(int n, int start, int temp, int dest) {
		if(n==0) return;
		
		// 맨 밑 위쪽의 n-1개 원판 들어내기 -> 임시기둥으로 옮기기
		hanoi(n-1, start, dest, temp);
		// 맨 밑 원판 옮기기 -> 목적기둥으로 옮기기
		System.out.println(n+": " + start + ">" + dest);
		// 맨 밑 위쪽의 n-1개 원판을 맽 밑 원판 위에 쌓기 ->목적기둥으로 옮기기
		hanoi(n-1, temp, start, dest);
	}

}
