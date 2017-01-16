package Google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class gamePLayCanWin {

	public static void main(String[] args) {
		System.out.println(canIWin(4, 6));

	}
	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if(desiredTotal==0) return true;
		int sum= maxChoosableInteger*(maxChoosableInteger+1)/2;
		if(sum < desiredTotal) return false;
		return canIWinUtil(new int[maxChoosableInteger+1], desiredTotal, new HashMap());		
	}
	private static boolean canIWinUtil(int[] state, int total, Map<String, Boolean> map) {
		String curr= Arrays.toString(state);
		if(map.containsKey(curr)) return map.get(curr);
		for(int i=0; i<state.length; i++){
			state[i]=1;
			if(total<i+1 || !canIWinUtil(state, total-(i+1), map)){ // failure of second player 
				map.put(curr, true);
				state[i]=0;
				return true;
			}
			state[i]=0;
		}
		map.put(curr, false);
		return false;
	}
	      
}
