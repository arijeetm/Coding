package Google;

import java.util.Arrays;
import java.util.List;

public class maxprodword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProduct(String[] words) {
		int res=0;
		for(int i=0; i<words.length; i++){
			for(int j=i+1; j<words.length; i++){
				if(notCommon(words[i], words[j]))
					res= Math.max(res, words[i].length()*words[j].length());
			}
		}
		return res;
	}
	private boolean notCommon(String str1, String str2) {
		//brute force
		for(int i=0; i<str1.length(); i++){
			for(int j=0; j<str2.length(); j++){
				if(str1.charAt(i)==str2.charAt(j)) return false;
			}
		}
		return true;
	}
}
