package interview;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

	public static void permutations(String prefix, String str) {
		int n = str.trim().length();
		if(n == 0)
			System.out.println(prefix);
		else {
			for(int i = 0; i < n; ++i) {
				permutations(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, n));
			}
		}
	}
	
	public static void permutations2(StringBuffer sb, int index) {
		if(index == 0)
			System.out.println(sb.toString());
		else {
			permutations2(sb, index-1);
			int currPos = sb.length()-index;
			for(int i = currPos+1; i < sb.length(); ++i) {
				swap(sb, currPos, i);
				permutations2(sb, index-1);
				swap(sb, i, currPos);
			}
		}
	}
	
	private static void swap(StringBuffer sb, int pos1, int pos2) {
		char c = sb.charAt(pos1);
		sb.setCharAt(pos1, sb.charAt(pos2));
		sb.setCharAt(pos2, c);
	}
	
	public static List<String> permutations3(String s) {
		List<String> permutations = new ArrayList<String>();
		if(s.length() == 1)
			permutations.add(s);
		else if(s.length() > 1) {
			int lastIndex = s.length()-1;
			String last = s.substring(lastIndex);
			String front = s.substring(0, lastIndex);
			permutations = merge(last, permutations3(front));
		}
			
		return permutations;
	}
	
	private static List<String> merge(String last, List<String> remaining) {
		List<String> subPermutation = new ArrayList<String>();
		for(String s:remaining) {
			for(int i = 0; i <= s.length(); ++i) {
				String toAdd = new StringBuffer(s).insert(i, last).toString();
				subPermutation.add(toAdd);
			}
		}
		
		return subPermutation;
	}
	
	public static void main(String[] args) {
		//permutations("", "wxyz");
		//permutations2(new StringBuffer("aacd"), 4);
		
		List<String> l = permutations3("wxyz");
		for(String s:l) {
			System.out.println(s);
		}
		
	}
}
