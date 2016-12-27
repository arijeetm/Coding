package Google;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class frequencySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(frequencySort("sdsdsfcccaa"));

	}
    public static String frequencySort(String s) {
    	StringBuilder res = new StringBuilder();
    	Map<Character, Integer> map = new HashMap();
    	for(Character c: s.toCharArray()){
    		if(map.containsKey(c)){
    			map.put(c, map.get(c)+1);
    		} else{
    			map.put(c, 1);
    		}
    	}
    	
    	TreeMap<Character, Integer> sortedmap = sortedMapByValue(map);
    	for(Character ch: sortedmap.keySet()){
    		for(int i=0; i<map.get(ch); i++)
    			res.append(ch);
    	}
    	return res.toString();
    }
	private static TreeMap<Character, Integer> sortedMapByValue(Map<Character, Integer> map) {
		Comparator<Character> cmp = new ValueComparator(map);
		TreeMap<Character, Integer> tmap = new TreeMap(cmp);	
		tmap.putAll(map);
		return tmap;
	}
}

class ValueComparator implements Comparator<Character>{

	Map<Character, Integer> map = new HashMap();
	public ValueComparator(Map<Character, Integer> map){
		this.map.putAll(map);
	}
	
	@Override
	public int compare(Character c1, Character c2) {
		if(map.get(c1) <= map.get(c2)){
			return 1;
		} else return -1;
	}
}
