package interview;

public class BinarySearch {

	public static int getMidpoint(int start, int end) {
		int diff = end-start;
		return (start + (int) Math.floor(diff/2));
	}
	
	public static int binarySearch(int[] list, int numberToFind, int start, int end) {
		if(start > end) {
			return -1;
		} else {
			int middle = getMidpoint(start, end);
			if(numberToFind < list[middle]) {
				return binarySearch(list, numberToFind, start, middle-1);
			} else {
				if(numberToFind > list[middle]) {
					return binarySearch(list, numberToFind, middle+1, end);
				} else {
					return middle;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] myList = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(myList, 3, 0, myList.length));
	}
}
