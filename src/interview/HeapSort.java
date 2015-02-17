package interview;

public class HeapSort {

	public static void main(String[] args) {
		int[] myarray = {5,4,6,2,4,1};
		heapsort(myarray);
		for(int k:myarray) {
			System.out.print(k + " ");
		}
	}

	public static void heapsort(int[] array) {
		int count = array.length-1;
		buildHeap(array, count);
		while(count > 0) {
			int temp = array[count];
			array[count] = array[0];
			array[0] = temp;
			buildHeap(array, count);
			count-=1;
		}
	}
	
	public static void buildHeap(int[] array, int count) {
		// 1. Start from half of count:
		int position = (int) Math.floor(count/2);
		while(position >= 0) {
			heapify(array, position, count);
			position-=1;
		}
	}
	
	public static void heapify(int[] array, int position, int count) {
		int leftChildPos = position*2+1;
		int rightChildPos = position*2+2;
		int largestPos = -1;
		
		if(leftChildPos < count && array[position] < array[leftChildPos]) {
			largestPos = leftChildPos;
		} else {
			largestPos = position;
		}
		
		if(rightChildPos < count && array[largestPos] < array[rightChildPos]) {
			largestPos = rightChildPos;
		}
		
		// If we find out that we had to do a swap, we should try to heapify the new structure. 
		if(largestPos != position) {
			int temp = array[position];
			array[position] = array[largestPos];
			array[largestPos] = temp;
			
			heapify(array, largestPos, count);
		}
	}
}
