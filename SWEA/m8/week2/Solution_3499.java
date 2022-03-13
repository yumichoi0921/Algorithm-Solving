package SWEA.m8.week2;
import java.util.*;

public class Solution_3499 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            Queue<String> q1 = new LinkedList<>();
            Queue<String> q2 = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if (N%2 == 1) {
                    if (i<=N/2) q1.offer(sc.next());
                    else q2.offer(sc.next());
                } else {
                    if (i<N/2) q1.offer(sc.next());
                    else q2.offer(sc.next());
                }
            }

            Queue<String> res = new LinkedList<>();
            while (true) {
                if (res.size() == N) {
                    break;
                }
                if (!q1.isEmpty()) res.offer(q1.poll());
                if (!q2.isEmpty()) res.offer(q2.poll());
            }

            System.out.printf("#%d ", tc);
            while (!res.isEmpty()) System.out.print(res.poll()+" ");
            System.out.println();
        }
    }
}
