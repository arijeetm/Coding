package Google;

public class plusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] plusOne(int[] digits) {
		int carry=1, sum, n=digits.length;
	      for(int i=n-1; i>=0; i--){
	    	  sum = digits[i] + carry;
	    	  if(sum==10){
	    		  digits[i] =0;
	    	  }else{
	    		  carry =0;
	    		  digits[i] =sum;
	    	  }
	      }
	       if(carry==1) {
	    	  int newint[]=new int[n+1];
	    	  newint[0] = 1;
	    	  for(int i=1;i<n;i++) 
	    		  newint[i]=digits[i];
	    	  return newint;
	      }
	      return digits;
    }
}
