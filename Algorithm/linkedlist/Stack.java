package Algorithm.linkedlist;
// linkedlist를 이용하여 stack 만들기
public class Stack {
	
	private Node top;
	
	public void push(String data){
		// 현재 top에 있는 노드보다 앞에 있어야 하므로
		// 새로운 노드가 현재 top이 가리키는 노드를 가리키게 하고
		Node newNode = new Node(data, top);
		// top은 새로운 노드를 가리키게 함
		top = newNode;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public String pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어 있습니다.");
			return null;
		}
		
		// 기존 top이 가르키고 있는 노드를 pop해야함
		Node popNode = top;
		// 기존 top이 가리키고 있는 다음 노드를 새로운 top으로 설정
		top = popNode.link;
		// 기존 top이 다음노드를 가르키고 있던 연결을 끊음
		popNode.link = null;
		return popNode.data;
	}
	
	public String peek() {
		if (isEmpty()) {
			System.out.println("스택이 비어 있습니다.");
			return null;
		}
		return top.data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("S ( ");
		for(Node currNode=top; currNode != null; currNode = currNode.link) {
			sb.append(currNode.data).append(",");
		}
		if (!isEmpty()) {
			sb.setLength(sb.length()-1);			
		}
		sb.append(" ) ");
		return sb.toString();
	}
}
