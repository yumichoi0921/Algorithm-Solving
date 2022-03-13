package Algorithm.stack_queue.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty()+"/"+queue.size());
		
		queue.offer("김");
		queue.offer("이");
		queue.offer("박");
		queue.offer("최");
		queue.offer("여");
		
		System.out.println(queue.isEmpty()+"/"+queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"/"+queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty()+"/"+queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
	}

}
