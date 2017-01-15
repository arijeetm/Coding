package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nthSuperUglyNumberProb {

	public static void main(String[] args) {
		System.out.println(nthSuperUglyNumber(4, new int[]{2,3,5}));
	}
	public static int nthSuperUglyNumber(int n, int[] primes){
		if(primes==null || primes.length==0) return 0;
		if(n==1) return 1;
		int res[]= new int[n];
		res[0]=1;
		int times[]= new int[primes.length];
		for(int i=1; i<n; i++){
			int min=Integer.MAX_VALUE;
			for(int j=0;j<primes.length; j++){
				min = Math.min(min, primes[j]* res[times[j]]);
			}
			res[i]=min;
			//update times
			for(int j=0; j<primes.length; j++){
				if(min==primes[j]* res[times[j]]) times[j]++;
			}
		}
		return res[n-1];
	}
	
/*	private static Set<Integer> findFactors(int n){
		Set<Integer> fac = new HashSet();
		//System.out.println(n);
		while(n%2==0){
			n=n/2;
			fac.add(2);
		}
		for(int i=3; i<Math.sqrt(n); i+=2){
			if(n%i==0){
				fac.add(i);
				n=n/i;
			}
		}
		if(n>2) fac.add(n);
		return fac;
	}*/

}
