
public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("abbab"));
	}
	public static int minCut(String s) {
		if(s==null || s.length()==0) return 0;
		int len= s.length();
		int cut[]= new int[len];
		boolean p[][]= new boolean[len][len];
		for(int i=0; i<len; i++){
			p[i][i]= true;
			int min= i; 
			for(int j=0; j<=i; j++){
				if(s.charAt(i)==s.charAt(j) 
						&& (i-j<=1 || p[j+1][i-1])){
					p[j][i]= true;
					if(j==0) min=0; // no partition needed since 0..i is palindrome
					else min=Math.min(min, 1+ cut[j-1]);
				}
			}
			cut[i]=min;
		}
		return cut[len-1];
	}
}
