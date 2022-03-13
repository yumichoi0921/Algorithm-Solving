package Algorithm.stack_queue.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyChewTest {

	public static void main(String[] args) {
		
		int N = 20;	// 마이쮸 갯수
		Queue<int[]> queue = new LinkedList<int[]>();	// 사람 번호, 마이쮸 갯수
		int person = 1;
		
		queue.offer(new int[] {person, 1});
		while (N>0) {
			if (!queue.isEmpty()) {
				int[] p = queue.poll();
				int availableCnt = (N>=p[1])? p[1]:N;
				N -= availableCnt;
				if (N==0) {
					System.out.println("마지막 마이쮸를 가져간 사람은 "+p[0] + "번, " + "가져간 갯수 " + availableCnt);
				} else {
					System.out.println(p[0] + "번이 " + availableCnt+"만큼 마이쮸를 가져갑니다. 남은 개수: "+N);
					p[1]++;	//받고자하는 마이쮸 갯수 증가
					queue.offer(p);
					queue.offer(new int[] {++person, 1});
				}
			}
			
		}

	}

}
