package Algorithm.recursion;

public class R01_FactorialTest {
	
	private static int factorial_iter(int n) {
		int res = 1;
		for (int i = n; i > 0; i--) {
			res *= i;
		}
		return res;
	}
	
	private static int res = 1;
	private static void factorial_iter_recur(int i) {
		if(i == 0) return;
		res *= i;
		factorial_iter_recur(i-1);
	}
	
	private static int factorial(int n) {
		if(n<=1) return 1;
		return n*factorial(n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
		System.out.println(factorial_iter(5));

	}

}
