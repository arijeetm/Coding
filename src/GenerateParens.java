import java.util.HashSet;
import java.util.Set;

public class GenerateParens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(genParens(3));
	}
	public static Set<String> genParens(int count){
		Set<String> res = new HashSet<String>();
		if(count==0){
			res.add("");
			return res;
		}
		Set<String> prev = genParens(count-1);
		for(String str: prev){
			for(int i=0; i<str.length(); i++){
				res.add(insertAfter(str, i));
			}
			res.add("()"+str); // build up to top -- DP Core
		}
		return res;
	}
	private static String insertAfter(String str, int i) {
		// TODO Auto-generated method stub
		String left = str.substring(0, i+1);
		String right = str.substring(i+1);
		return left+ "()" + right;
	}
}
