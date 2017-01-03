package Google;

public class Regex {

	public static void main(String[] args) {
		System.out.println(isMatch("aa",".*"));

	}
	public static boolean isMatch(String s, String p) {
		int slen= s.length(), plen=p.length();
		
		//dp[i][j] -> true if regex match between s[0..i] and p[0..j]
		boolean dp[][]= new boolean[slen+1][plen+1];
		
		dp[0][0]=true;
		//fill the boundary cases
		for(int i=1; i<slen; i++) dp[i][0]=false; //any string will not match with empty pattern
		
		for(int j=1; j<=plen; j++){ //balance the diff between index and count
			if(j>=2 && p.charAt(j-1)=='*') dp[0][j]= dp[0][j-2];
			else dp[0][j]=false;
		}
		
		for(int i=1; i<=slen; i++){
			for(int j=1; j<=plen; j++){
				if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') dp[i][j]=dp[i-1][j-1];
				if(p.charAt(j-1)=='*'){
					dp[i][j]= dp[i][j-2] //zero occurrence
							|| (p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.' // if one occurrence
							? dp[i-1][j]: false);
				}
			}
		}
		return dp[slen][plen];
	}

}
