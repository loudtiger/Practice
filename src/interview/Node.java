package interview;

public class Node {

	private int value;
	private Node next;
	
	public Node() {
		value = -1;
		next = null;
	}
	
	public Node(int s) {
		value = s;
		next = null;
	}
	
	public int getValue() {
		return value;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
}
