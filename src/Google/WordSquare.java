package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Trie{
	List<String> starts;
	Trie next[];
	Trie(){
		starts= new ArrayList();
		next= new Trie[26];
	}
}

public class WordSquare {

	public static void main(String[] args) {
		System.out.println(wordSquares(new String[]{"area","lead","wall","lady","ball"}));

	}
	private static Trie buildTrie(String words[]){
		Trie root= new Trie();
		for(int i=0; i<words.length; i++){
			Trie curr= root;
			for(Character c: words[i].toCharArray()){
				int indx= c-'a';
				if(curr.next[indx]==null) curr.next[indx]= new Trie();
				curr.next[indx].starts.add(words[i]);
				curr = curr.next[indx];
			}
		}
		return root;
	}
	private static List<String> searchByPrefix(Trie root, String prefix){
		List<String> res= new ArrayList();
		Trie curr= root;
		for(Character c: prefix.toCharArray()){
			int indx= c-'a';
			if(curr.next[indx]==null) return res;
			curr= curr.next[indx];
		}
		res.addAll(curr.starts);
		return res;
	}
	public static List<List<String>> wordSquares(String[] words){
		List<List<String>> res= new ArrayList();
		if(words==null|| words.length==0) return res;
		Trie root= buildTrie(words);
		Arrays.sort(words); // sort by length
		int len= words.length;
		List<String> ans= new ArrayList();
		for(int i=0; i<len; i++){
			ans.add(words[i]);
			wordSquaresUtil(words[i].length(), ans, root, res);
			ans.remove(ans.size()-1);
		}
		return res;
	 }
	private static void wordSquaresUtil(int len, List<String> ans, Trie root, List<List<String>> res) {
		if(ans.size()==len) {
			res.add(new ArrayList<>(ans)); return;
		}
		int indx= ans.size();
		StringBuilder prefix= new StringBuilder();
		for(String str: ans){
			prefix.append(str.charAt(indx));
		}
		List<String> startWith= searchByPrefix(root, prefix.toString());
		for(String s: startWith){
			ans.add(s);
			wordSquaresUtil(len, ans, root, res);
			ans.remove(ans.size()-1);
		}
	}

}
