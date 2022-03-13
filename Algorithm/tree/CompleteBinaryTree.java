package Algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class CompleteBinaryTree {
	
	// 완전이진트리 -> 1부터 SIZE까지 순서대로 저장
	private char[]	nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size+1];
	}
	
	public void add(char c) {
		if (lastIndex == SIZE) return;
		
		nodes[++lastIndex] = c;
	}
	
	public void bfs() {
		// 탐색을 기다리는 노드들이 저장됨 
		// 트리를 배열로 관리 ->탐색할 노드의 인덱스 저장
		Queue<Integer> queue = new LinkedList<Integer>();
		// 루트노드 인덱스 저장
		queue.offer(1);
		
		// 현재 노드 인덱스
		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			// 왼쪽 자식이 있다면
			if (current*2 <= lastIndex) {	// 단말노드가 아니라면
				queue.offer(current*2);
			}
			// 오른쪽 자식이 있다면
			if (current*2+1 <= lastIndex) {	// 단말노드가 아니라면
				queue.offer(current*2+1);
			}
		}
	}
	
	public void bfs2() {
		// 탐색을 기다리는 노드들이 저장됨 
		// 트리를 배열로 관리 ->탐색할 노드의 인덱스 저장
		Queue<Integer> queue = new LinkedList<Integer>();
		// 루트노드 인덱스 저장
		queue.offer(1);
		
		// 현재 노드 인덱스
		int current = 0;
		// 현재 레벨, 현재 큐의 사이즈
		int level = 0, size = 0;
		while (!queue.isEmpty()) {
			// 현재 레벨에 있는 노드의 수를 사이즈로 지정
			size = queue.size();
			
			System.out.print("level "+level+": ");
			// 현재 레벨에 있는 노드만 출력
			while (--size >= 0) {
				current = queue.poll();
				System.out.print(nodes[current]+" ");
				// 왼쪽 자식이 있다면
				if (current*2 <= lastIndex) {	// 단말노드가 아니라면
					queue.offer(current*2);
				}
				// 오른쪽 자식이 있다면
				if (current*2+1 <= lastIndex) {	// 단말노드가 아니라면
					queue.offer(current*2+1);
				}
			}
			System.out.println();
			// 다음 레벨
			++level;
		
		}
	}
	
	public void dfsByPreOrder() {
		System.out.println("Preorder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	
	private void dfsByPreOrder(int current) {
		// 현재 노드 처리
		System.out.print(nodes[current]+" ");
		// 왼쪽자식 노드 방문
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		// 오른쪽자식 노드 방문
		if(current*2+1 <= lastIndex) dfsByPreOrder(current*2+1);

	}
	
	public void dfsByPInOrder() {
		System.out.println("Inorder : ");
		dfsByPInOrder(1);
		System.out.println();
	}
	
	private void dfsByPInOrder(int current) {
		// 왼쪽자식 노드 방문
		if(current*2 <= lastIndex) dfsByPInOrder(current*2);
		// 현재 노드 처리
		System.out.print(nodes[current]+" ");
		// 오른쪽자식 노드 방문
		if(current*2+1 <= lastIndex) dfsByPInOrder(current*2+1);

	}
	
	public void dfsByPostOrder() {
		System.out.println("Postorder : ");
		dfsByPostOrder(1);
		System.out.println();
	}
	
	private void dfsByPostOrder(int current) {
		// 왼쪽자식 노드 방문
		if(current*2 <= lastIndex) dfsByPostOrder(current*2);
		// 오른쪽자식 노드 방문
		if(current*2+1 <= lastIndex) dfsByPostOrder(current*2+1);
		// 현재 노드 처리
		System.out.print(nodes[current]+" ");

	}
}
