package GoldenProbs;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		Set<String> set= new HashSet(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca",
				"br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur",
				"rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha",
				"hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn",
				"mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
		System.out.println(findLadders("qa", "sq", set));
	}
	private static boolean isConnected=false;
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res= new ArrayList();
		Set<String> forward= new HashSet(); forward.add(beginWord);
		Set<String> backward= new HashSet(); backward.add(endWord);
		Map<String, Set<String>> map= new HashMap();
		BFS(forward, backward, wordList, false, map);
		if(!isConnected) return res;
		List<String> curr= new ArrayList(); curr.add(beginWord);
		DFS(beginWord, endWord, res, curr, map);
		return res;
	}
	private static void DFS(String start, String end, List<List<String>> res, List<String> curr,
			Map<String, Set<String>> map) {
		if(start.equals(end)) {
			res.add(new ArrayList<>(curr)); return;
		}
		if(!map.containsKey(start)) return;
		for(String s: map.get(start)){
			curr.add(s);
			DFS(s, end, res, curr, map);
			curr.remove(curr.size()-1);
		}
	}
	private static void BFS(Set<String> forward, Set<String> backward, Set<String> wordList, boolean swap,
			Map<String, Set<String>> map) {
		//Always try to explore from the smaller edge
		if(forward.isEmpty() || backward.isEmpty()) return;
		if(forward.size()>backward.size()){
			BFS(backward, forward, wordList, !swap, map);
		}
		// to avoid loops
		wordList.removeAll(forward);
		wordList.removeAll(backward);
		Set<String> newforward= new HashSet();
		for(String str: forward){
			for(int i=0; i<str.length(); i++){
				char arr[]= str.toCharArray();
				for(char j='a'; j<='z'; j++){
					arr[i]= j;
					String temp= new String(arr);
					if(!wordList.contains(temp) && !backward.contains(temp)) continue;
					String source= swap? temp: str;
					String dest= swap? str:temp;
					if(!map.containsKey(source)) map.put(source, new HashSet());	
					if(backward.contains(temp)){
						isConnected=true;
						map.get(source).add(dest);
					}
					if(!isConnected && wordList.contains(temp)){
						map.get(source).add(dest);
						newforward.add(temp);
					}
				}
			}
		}
		if(!isConnected) 
			BFS(newforward, backward, wordList, swap, map);
	}
}
