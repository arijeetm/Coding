package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class RandomizedSet {

		private List<Integer> data;
		
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        data= new ArrayList<Integer>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        return data.add(val);
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if(!data.contains(val)) return false;
	    	int last= data.get(data.size()-1);
	    	data.set(data.indexOf(val), last);
	    	data.remove(data.size()-1);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	Random rand = new Random();
	        return data.get(rand.nextInt(data.size()-1)); 
	    }
	}
}
