
public class WraparoundString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findSubstringInWraproundString(String p) {
		if(p==null||p.length()==0) return 0;
		//find number of sub strings ending at a char in p
		int count[]= new int[26];
		int max=1; //each char is a sub string
		int res=0;
		for(int i=0; i<p.length(); i++){
			if(i>0 && (p.charAt(i)-p.charAt(i-1)==1 || p.charAt(i-1)-p.charAt(i)==25)) max++;
			else max=1;
			int indx= p.charAt(i)-'a';
			count[indx]=Math.max(count[indx], max);
		}
		for(int i=0; i<26; i++) res+=count[i];
		return res;
	}
}
