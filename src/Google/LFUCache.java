package Google;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2.00-1.10);
	}
	private static Map<Integer, Integer> valuemap;
	private static Map<Integer, Integer> countmap;
	private static Map<Integer, LinkedHashSet<Integer>> cache;
	private static int cap, min;
	
	public LFUCache(int capacity) {
		valuemap= new HashMap<>();
		countmap= new HashMap<>();
		cache= new HashMap<>();
		cap= capacity;
		min=-1;
		cache.put(1, new LinkedHashSet<>());
	}
	    
	public int get(int key) {
		if(!valuemap.containsKey(key)) return -1;
		int count= countmap.get(key);
		countmap.put(key, count+1);
		cache.get(count).remove(key);
		if(min==count && cache.get(min).size()==0){
			min++;
		}
		if(cache.get(count+1)==null) cache.put(count+1, new LinkedHashSet<>());
		cache.get(count+1).add(key);
		return valuemap.get(key);
	}
	    
	public void put(int key, int value) {
		if(cap<=0) return;
		if(valuemap.containsKey(key)){
			valuemap.put(key, value);
			get(key);
			return;
		}
		if(cap <= valuemap.size()){
			//eviction
			int evict= cache.get(min).iterator().next(); // head
			cache.get(min).remove(evict);
			valuemap.remove(evict);
			countmap.remove(evict);
		}
		//add first occurrence
		min=1;
		countmap.put(key, 1);
		valuemap.put(key, value);
		cache.get(1).add(key);
	}
}
