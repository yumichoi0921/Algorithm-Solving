package Algorithm.linkedlist;

public class SinglyLinkedList {
	
	// head 자체에 첫번째 노드를 저장할 것임
	private Node head;
	
	// 첫번째 노드로 삽입하기
	public void addFisrtNode(String data) {
		// head가 가진 첫째 노드의 링크를 newNode의 링크 필드에 저장
		// newNode가 기존 첫째 노드를 가리킴
		Node newNode = new Node(data, head);
		// head가 첫째 노드를 가리킴
		head = newNode;
	}
	
	// 마지막 노드 찾기
	public Node getLastNode() {
		// head부터 탐색
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			// 자신의 링크 필드(가리키는 노드)에 아무것도 없으면 자신이 마지막 노드
			if(currNode.link == null) {	
				return currNode;
			}
		}
		return null;
	}
	
	// 마지막 노드로 삽입하기
	public void addLastNode(String data) {
		// 공백리스트일 경우
		if (head == null) {
			// 마지막노드 == 첫번째노드이므로 첫번째 노드로 삽입하기 재사용
			addFisrtNode(data);
			return;
		}
			
		// 기존 마지막 노드 찾기
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		// 기존 마지막노드의 링크필드에 새로운 노드의 참조값 저장
		lastNode.link = newNode;
	}
	
	// 중간 노드로 삽입
	public void insertAfterNode(Node preNode, String data) {
		// 선행 노드가 없으면 삽입불가
		if (preNode == null) {
			System.out.println("선행노드가 없어서 삽입이 불가능합니다.");
			return;
		}
		
		// 새로운 노드의 링크필드에 선행노드의 링크필드 값을 복사
		Node newNode = new Node(data, preNode.link);
		// 선행노드의 링크필드에 새로운 노드의 참조값 저장
		preNode.link = newNode;
	}
	
	// 데이터 필드에 data를 가지고 있는 첫번째 노드 리턴
	public Node getNode(String data) {
		// head부터 탐색
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			// 자신의 데이터 필드가 data와 같으면 해당 노드 리턴
			if(currNode.data.equals(data)) {	
				return currNode;
			}
		}
		return null;
	}
	
	// target의 이전 노드 찾기
	public Node getPreviousNode(Node target) {
		// head부터 탐색
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			// 자신의 링크 필드(가리키는 노드)가 target이면 자신이 target 이전 노드 
			if(currNode.link == target) {	
				return currNode;
			}
		}
		return null;
	}
	
	// data를 갖고 있는 노드를 찾아서 삭제
	public void deleteNode(String data) {
		// data를 가지고 있는 노드
		Node targetNode = getNode(data);
		// data를 가지고 있는 노드가 없다면
		if (targetNode == null) {
			System.out.println("삭제할 노드가 없어서 삭제가 불가능합니다. ");
			return;
		}
		
		Node preNode = getPreviousNode(targetNode);
		// target이 첫번째 노드인 경우
		if(preNode == null) {
			// head에 삭제할 노드가 가리키고 있던 참조값 저장
			head = targetNode.link;
		} else {
			// 이전 노드의 링크필드에 삭제할 노드가 가리키고 있던 참조값 저장
			preNode.link = targetNode.link;
		}
		// 삭제할 노드의 링크필드 연결 끊음 
		targetNode.link = null;
	}
	
	// 연결 리스트 출력
	public void printList() {
		System.out.print("L = ( ");
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data +" ");
		}
		System.out.println(" ) ");		
	}

}
