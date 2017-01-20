import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res= new ArrayList();
		if(strs==null|| strs.length==0) return res;
		int len=strs.length;
		
		Map<String, ArrayList<String>> map= new HashMap();
		for(int i=0; i<len; i++){
			char freq[]= new char[26];
			for(Character c: strs[i].toCharArray()) freq[c-'a']++;
			String key= new String(freq);
			if(map.containsKey(key)) map.get(key).add(strs[i]);
			else{
				ArrayList<String> list= new ArrayList();
				list.add(strs[i]);
				map.put(key, list);
			}
		}
		res.addAll(map.values());
		return res;
	}
}
