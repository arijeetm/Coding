package Google;

import java.util.ArrayList;
import java.util.List;

class Point{
	int x,y;
	public Point(int i, int j){
		x=i; y=j;
	}
}
class TrieNode{
	TrieNode next[]= new TrieNode[26]; // 26 possible next ways to traverse
	String word;
}

public class WordSearch {

	public static void main(String[] args) {
		char board[][]= new char[][]{
		  {'o','a','a','n'},
		  {'e','t','a','e'},
		  {'i','h','k','r'},
		  {'i','f','l','v'}
		};
		String words[]= new String[]{"oath","pea","eat","rain"};
		System.out.println(findWords(board, words));

	}
	private static TrieNode buildTrie(String words[]){
		TrieNode root= new TrieNode();
		for(String w: words){
			TrieNode curr= root; //search for appropriate location
			for(Character c: w.toCharArray()){
				int i= c-'a';
				if(curr.next[i]==null) curr.next[i]= new TrieNode();
				curr = curr.next[i];
			}
			curr.word= w; // insert
		}
		return root;
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList();
		TrieNode root= buildTrie(words);
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				findWordsUtil(board, root, new Point(i,j), res);
			}
		}
		return res;
	}
	private static void findWordsUtil(char[][] board, TrieNode node, Point p, List<String> res) {
		char c= board[p.x][p.y];
		if(c=='$' // already traversed
				|| node.next[c-'a']== null) // cannot lead to effective word
			return;
		node= node.next[c-'a'];
		if(node.word != null) // reach the leaf with non null word value
		{
			res.add(node.word);
			node.word=null;
		}
		
		int dirx[]={-1,1,0,0}, diry[]={0,0,-1,1};
		board[p.x][p.y]='$'; // marking to prevent loop back
		for(int i=0; i<4; i++){
			Point np= new Point(p.x+ dirx[i], p.y+ diry[i]);
			if(isValidPoint(np.x, np.y, board.length, board[0].length)){
				findWordsUtil(board, node, np, res);
			}
		}
		board[p.x][p.y]= c; //backtrack
	}
	private static boolean isValidPoint(int x, int y, int m, int n) {
		if(x<0 || y<0 || x>=m || y>=n) return false;
		return true;
	}
}
