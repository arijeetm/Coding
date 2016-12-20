import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printPerms("java"));
	}
	public static List<String> printPerms(String input){
		Map<Character, Integer> map = new HashMap<>();
		List<String> res = new ArrayList<>();
		buildFreqMap(input, map);
		return printPermsUtil(map, "", input.length(), res);
	}
	public static List<String> printPermsUtil(Map<Character, Integer> map, String prefix, int length, List<String> res){
		//System.out.println(prefix);
		if(length==0){
			res.add(prefix);
		} else{
			for(Character c: map.keySet()){
				int count=map.get(c);
				if(count>0) {
					map.put(c, count-1);
					printPermsUtil(map, c + prefix, length-1, res);
					//Backtrack
					map.put(c, count);
				}
			}
		}
		return res;
	}
	public static void buildFreqMap(String str, Map<Character, Integer> map){
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			} else 	map.put(ch, 1);
		}
	}
}
