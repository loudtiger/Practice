package interview;

public class MergeSort {

	public static void main(String[] args) {
		Node three = new Node(3);
		Node one = new Node(1);
		Node five = new Node(5);
		Node six = new Node(6);
		Node four = new Node(4);
		one.setNext(three);
		five.setNext(one);
		//six.setNext(five);
		//four.setNext(six);
		//[4, 6, 5, 1, 3]
		Node linkedList = four;
		while(linkedList != null) {
			System.out.print(linkedList.getValue() + " ");
			linkedList = linkedList.getNext();
		}
		System.out.println("\nMiddle:" + getMiddle(four).getValue());
		Node sorted = mergeSort(four);
		while(sorted != null) {
			System.out.print(sorted.getValue() + " ");
			sorted = sorted.getNext();
		}
	}
	
	public static Node mergeSort(Node head) {
		if(head == null || head.getNext() == null)
			return head;
		Node middle = getMiddle(head);
		Node rightHalf = middle.getNext();
		middle.setNext(null);
		
		return merge(mergeSort(head), mergeSort(rightHalf));
	}
	
	public static Node merge(Node left, Node right) {
		Node newHead = new Node();
		Node front = newHead;
		while(left != null && right != null) {
			if(left.getValue() < right.getValue()) {
				newHead.setNext(left);
				left = left.getNext();
			} else {
				newHead.setNext(right);
				right = right.getNext();
			}
			
			newHead = newHead.getNext();
		}
		
		if(left == null) {
			newHead.setNext(right);
		} else {
			newHead.setNext(left);
		}
		
		return front.getNext();
	}
	
	public static Node getMiddle(Node head) {
		if(head == null)
			return head;
		Node slow;
		Node fast;
		slow = fast = head;
		while(fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		return slow;
	}
}
