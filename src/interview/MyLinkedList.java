package interview;

public class MyLinkedList {
	private Node head;
	
	public MyLinkedList(int s) {
		head = new Node(s);
	}
	
	public Node getHead() {
		return head;
	}
	
	public void add(int s) {
		if(head == null) {
			head = new Node(s);
		} else {
			Node nodeToAdd = new Node(s);
			nodeToAdd.setNext(head);
			head = nodeToAdd;
		}
	}
	
	public void printLinkedList() {
		Node front = head;
		while(front != null) {
			System.out.print(front.getValue() + " ");
			front = front.getNext();
		}
	}

}
