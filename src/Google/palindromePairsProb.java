package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class palindromePairsProb {

	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[]{"bat", "tab", "cat"}));
	}
	private static boolean isPalindrome(String s){
		int left=0, right=s.length()-1;
		while(left<right){
			if(s.charAt(left++)!=s.charAt(right--)) return false;
		}
		return true;
	}
	
	public static List<List<Integer>> palindromePairs(String[] words) {
		Set<List<Integer>> res= new HashSet();
		int len= words.length;
		Map<String, Integer> m= new HashMap<>();
		for(int i=0; i<len; i++) m.put(words[i], i);
		
		for(int i=0; i<words.length; i++){
			for(int j=0; j<=words[i].length(); j++){
				String left= words[i].substring(0, j);
				String right= words[i].substring(j);
				if(isPalindrome(left)){
					String rev= new StringBuilder(right).reverse().toString();
					if(m.containsKey(rev) && m.get(rev)!=i) res.add(Arrays.asList(m.get(rev), i));
				}
				else if(isPalindrome(right)){
					String rev= new StringBuilder(left).reverse().toString();
					if(m.containsKey(rev) && m.get(rev)!=i) res.add(Arrays.asList(i, m.get(rev)));
				}
			}
		}
		return new ArrayList(res);	
	}
}
