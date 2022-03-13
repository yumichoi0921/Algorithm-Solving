package Algorithm.recursion;

public class R02_CombinationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(comb(3,2));
		System.out.println(comb(5,2));
		System.out.println(comb(3,3));
	}
	
	private static int comb(int n, int r) {
		// 자신을 포함해서 r개를 만드는 경우의 수 + 자신을 포함하지 않고  r개를 만드는 경우의 수
		// base part
		if(r==0||r==n) return 1;
		//indective part
		return comb(n-1, r-1) + comb(n-1, r);
	}

}
