package Google;

public class PowXn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(2.00000
				,-2147483648));
				//0.00001, 2147483647));
				//34.00515,-3));
	}
	public static double myPow(double x, int n) {
        if(x==1) return x;
		if(n==-2147483648) {
		    if(x==-1) return 1;
		    return 0;
		}
	    return n<0? 1/myPowPositive(x, -n): myPowPositive(x, n);
	}
	private static double myPowPositive(double x, int n){
		if(n==0) return 1;
		double res = myPowPositive(x,n/2);
		res*=res;
		if(n%2==1) return res*x;
		return res;
	}
	
	/*
	 * java.lang.NegativeArraySizeException - dp
	 * public static double myPow(double x, int n) {
		if(n==0) return 1;
        int num = n<0? -n: n;
        double pow[]= new double[num+1];
        pow[0]=1;
        double val=x, sqr=x*x;
        if(n<0) {
        	val=1/val; sqr=1/sqr;
        }
        
	     for(int i=1; i<=num; i++) {
	    	 if(i%2==1) pow[i]= pow[i-1]*val;
	    	 else pow[i]=pow[i-2] *sqr;
	     }
	     return pow[num];
    }*/
}
