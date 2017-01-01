package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat","cats","and","sand","dog"))));

	}
	public static List<String> wordBreak(String s, Set<String> wordDict) {
		Map<String, List<String>> cache= new HashMap();
        return dfs(s, wordDict, cache);     		
	}
	private static List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> cache) {
		if(cache.containsKey(s)) return cache.get(s);
		List<String> res= new ArrayList();
		if(s.length()==0) {
			res.add("");
			return res;
		}
		for(String word: wordDict){
			if(s.startsWith(word)) {
				List<String> subword= dfs(s.substring(word.length()), wordDict, cache);
				for(String sub: subword){
					res.add(word+ (sub.isEmpty() ? "": " ")+ sub);
				}
			}
		}
		cache.put(s, res);
		return res;
	}
}
