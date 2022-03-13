package Algorithm.dynamic_programming;

public class add_dp {

	static int[] memo;
	static int N = 10000;
	public static void main(String[] args) {
		long start = 0, end = 0;
		start = System.currentTimeMillis();
		// 1. 인자를 이용한 재귀
		add(1, 0);
		
		// 2. return을 이용한 재귀
		int ans = 0;
		ans = add_return(N);
		System.out.println(ans);
		
		// 3. memoization 
		memo = new int[N+1];
		ans = add_memo(N);
		System.out.println(ans);
		
		// 4. dp(상향식)
		add_up(N);
		
		
		end = System.currentTimeMillis();
		System.out.println("execute time " + (end-start));

	}

	private static void add_up(int N) {
		// f(n) = f(n-1)+f(n)
		for (int i = 0; i < memo.length; i++) {
			memo[i] = memo[i-1]+i;
		}
		System.out.println(memo[N]);
		
	}

	private static int add_memo(int idx) {
		if (idx==0) {
			return 0;
		}
		if (memo[idx] != 0) {
			return memo[idx];
		}
		memo[idx] = idx+add_memo(idx-1);
		return memo[idx];
	}

	private static int add_return(int idx) {
		if(idx == 0) {
			return 0;
		}
		return idx+add_return(idx-1);
		
	}

	private static void add(int idx, long sum) {
		if (idx > N) {
			System.out.println(sum);
			return;
		}
		add(idx+1, sum+idx);
	}

}
