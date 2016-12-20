import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution(new int[]{0,0,0}, 0));
	}
	public static void placeMap(Map<Integer, Integer> map, int key){
		Integer prev = map.get(key);
		if(prev!=null){
			if(prev>3) return;
			map.put(key, prev+1);
		}
		else
			map.put(key, 1);
	}

	public static List<List<Integer>> Solution(int nums[], int target){
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int first = nums[i];
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			map.clear();
			for (int j = i + 1; j < nums.length; j++) {
				int key = target - (first + nums[j]);
				boolean contain = map.containsKey(key);
				if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
					if (!contain)
						map.put(nums[j], j);
					continue;
				}else {
					if (contain) {
						res.add(Arrays.asList(nums[i], key, nums[j]));
					}
				}
				if (!contain)
					map.put(nums[j], j);
			}
		}
		return res;
	}
}
