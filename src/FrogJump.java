import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
	}
	public static boolean canCross(int[] stones) {
        if(stones==null|| stones.length==0) return false;
        int len= stones.length;
        Map<Integer, Set<Integer>> jumps= new HashMap<>(len);
        for(int i=0; i<len; i++) jumps.put(stones[i], new HashSet<Integer>());
        jumps.get(0).add(1);
        
        for(int i=0; i<len; i++) {
        	int stone= stones[i];
        	for(Integer step: jumps.get(stone)){
        		int stepon= stone+ step;
        		if(stepon==stones[len-1]) return true;
        		Set<Integer> val= jumps.get(stepon);
        		if(val!=null) // valid stone
        		{
        			// add all possible steps for the next stone
        			val.add(step);
        			val.add(step+1);
        			if(step>1) val.add(step-1); //step cannot be zero
        		}
        	}
        }
        return false;
    }
}
