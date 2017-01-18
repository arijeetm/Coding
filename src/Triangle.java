import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minimumTotal(Arrays.asList(
				Arrays.asList(1), Arrays.asList(3,2), Arrays.asList(1,2,-1)
				)));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null || triangle.size()==0) return 0;
		int n= triangle.size();
		Integer minlength[]= triangle.get(n-1).toArray(new Integer[0]); 
		//each element is shortest path to itself in leaf level.
		for(int i=n-2; i>=0; i--){ //move across rows		
			for(int j=0; j<=i; j++){
				minlength[j]= triangle.get(i).get(j) + Math.min(minlength[j], minlength[j+1]);
			}
		}
		return minlength[0];
	}
}
