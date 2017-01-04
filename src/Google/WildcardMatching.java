package Google;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("ho","**ho"));
	}
	public static boolean isMatch(String s, String p) {
		int slen= s.length(), plen=p.length();
		boolean dp[][]= new boolean[slen+1][plen+1];
		//fill boundary
		dp[0][0]= true;
		for(int i=1; i<=slen; i++) dp[i][0]=false;
		for(int j=1; j<=plen; j++){
			if(j==1) {
				while(j<=plen && p.charAt(j-1)=='*') {
					dp[0][j++]=true;
				}
			}		
			else dp[0][j]=false;
		}
		for(int i=1; i<=slen; i++){
			for(int j=1; j<=plen; j++){
				if(s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='?') dp[i][j]=dp[i-1][j-1];
				else if(p.charAt(j-1)=='*'){
					dp[i][j]= dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[slen][plen];
	}
}
