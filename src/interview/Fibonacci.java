package interview;

public class Fibonacci {

	//1, 1, 2, 3, 5, 8, 13, 21, 34
	public static int fibonacci(int n) {
		if(n == 0 || n == 1)
			return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		for(int k = 1; k < 10; k++) {
			System.out.println("K:" + k + ":" + fibonacci(k));
		}
	}
}
