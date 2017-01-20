package CompetitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(arrangeSequence(10, 8, Arrays.asList(1,4,7,3,4,10,1,3)));
	}
	public static List<Integer> arrangeSequence(int n, int m, List<Integer> ops){
		List<Integer> res= new ArrayList();
		for(int i=1; i<=n; i++) res.add(i);
		if(ops==null|| ops.size()==0) return res; // no change
		for(int i=0; i<m; i++){
			int indx= res.indexOf(ops.get(i));
			if(indx==-1) continue; //ignore
			res.remove(indx); //remove
			res.add(0, ops.get(i)); //add
		}
		return res;
	}
}
