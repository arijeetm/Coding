package GoldenProbs;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateAbbreviations("word"));
		//["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
	}
	public static List<String> generateAbbreviations(String word) {
		List<String> res= new ArrayList<>();
		if(word==null|| word.length()==0) return res;
		for(int i=0; i< (1<<word.length()); i++){
			res.add(getAbbr(word, i));
		}
		return res;
	}
	private static String getAbbr(String word, int mask) {
		StringBuilder ans= new StringBuilder();
		for(int i=0; i<word.length();){
			if((mask & 1<<i)==0){
				ans.append(word.charAt(i));
				i++;
			}else{
				int cur=i;
				while(cur<word.length() && (mask&1<<cur)>0) cur++;
				ans.append(cur-i);
				i=cur;
			}
		}
		return ans.toString();
	}
}
