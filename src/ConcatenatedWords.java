import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
	}
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> res= new ArrayList<String>();
		if(words==null || words.length<3) return res;
		Arrays.sort(words, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.length()-s2.length(); // sort by length
			}	
		});
		int len= words.length;
		int min= words[0].length(), max=words[len-1].length();
		Set<String> w= new HashSet<>();
		w.addAll(Arrays.asList(words));
		
		for(int i=0; i<len; i++){ // output cannot be from first 2 words-> prune
			w.remove(words[i]);
			if(canformdp(words[i], min, max, 0, 0, w)) 
				res.add(words[i]);
			w.add(words[i]);
		}
		return res;
	}
	//dp
	private static boolean canformdp(String str, int min, int max, int start, int count, Set<String> words) {
		boolean dp[]= new boolean[str.length()+1]; // dp[i] is true if str[0...i-1] can be decomposed, could start from here
		dp[0]= true;
		for(int i=min; i<=str.length(); i++){
			for(int j=0; j<=i; j++){
				if(dp[j] && words.contains(str.substring(j, i))){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[str.length()];
	}
	
	// Recursive
	private static boolean canform(String str, int min, int max, int start, int count, Set<String> words) {
		if(start==str.length()) {
			if(count>0) return true;
			else return false;
		}
		for(int i=min; i<max; i++){
			if(start+i > str.length()) break;
			String first= str.substring(start, start+i);
			if(words.contains(first)){
				if (canform(str, min, max, start+i, count+1, words)) return true;
			}
		}
		return false;
	}
	
}
