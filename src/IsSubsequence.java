
public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isSubsequence(s, t));
		
	}
	public static boolean isSubsequence(String s, String t) {
		if(s.isEmpty() && t.isEmpty()) return true;
		int indxs=0, indxt=0;
		System.out.println(t.length());
		while(indxt< t.length()){
			if(indxs==s.length()) return true;
			indxt= t.indexOf(s.charAt(indxs));
			if(indxt==-1) return false;
			indxs++;
			t=t.substring(indxt);
		}
		return false;
	}
}
