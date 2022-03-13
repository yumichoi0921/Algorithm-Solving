package Algorithm.dynamic_programming;

public class fibo_dp {

	static int[] memo;
	static int N = 10;
	public static void main(String[] args) {
		long start = 0, end = 0;
		start = System.currentTimeMillis();
		int ans;
		
		// 2. return을 이용한 재귀
		ans = fibo_return(N);
		System.out.println(ans);
		
		// 3. recursive+memoization (하향식)
		memo = new int[N+1]; 
		ans = fibo_memo(N);
		System.out.println(ans);
		
		// 4. dp(상향식)
		memo = new int[N+1];
		ans = fibo_up(N);
		System.out.println(ans);
		
		// 5. 반복문 이용
		memo = new int[N+1];
		ans = fibo_loop(N);
		System.out.println(ans);
		
		end = System.currentTimeMillis();
		System.out.println("execute time " + (end-start));

	}

	private static int fibo_loop(int n) {
		if(n <= 1) {
			return n;
		}
		int a = 0;
		int b = 1;
		for (int i = 0; i < n-1; i++) {
			int tmp = a;
			a = b;
			b = tmp+b;
		}
		return b;
	}

	private static int fibo_up(int n) {	// 빅오: n
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i-1]+memo[i-2];
		}
		return memo[n];
	}

	private static int fibo_memo(int n) {	// 빅오: 2^n이지만 가지치기를 통해 시간 획기적으로 줄임
		if (n<=1) {
			memo[n] = n;
			return memo[n];
		}
		if (memo[n] != 0) {
			return memo[n];
		}
		return memo[n] = fibo_memo(n-1)+fibo_memo(n-2);
	}

	private static int fibo_return(int n) {	// 빅오: 2^n -> 한번 호출할 때마다 2개로 갈라짐
		if(n <= 1) {
			return n;
		}
		return fibo_return(n-1)+fibo_return(n-2);
		
	}
}
