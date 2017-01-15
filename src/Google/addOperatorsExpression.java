package Google;

import java.util.ArrayList;
import java.util.List;

public class addOperatorsExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addOperators("3456237490", 9191));
	}
	public static List<String> addOperators(String num, int target) {
		List<String> res= new ArrayList();
		if(num==null|| num.length()==0) return res;
		StringBuilder result= new StringBuilder();
		for(int i=1; i<=num.length(); i++){
			if(i>=2 && num.charAt(0)=='0') continue;
			result.setLength(0); //clear
			addOperatorsUtil(num.substring(i), result.append(num.substring(0, i)), 0, true, 
					Long.parseLong(num.substring(0, i)), target, res);
		}
		return res;
    }
	
	private static void addOperatorsUtil(String num, StringBuilder str, long prev, boolean sign, long curr, int target, List<String> res) {
		long sum= sign ? prev+curr: prev-curr;
		//System.out.println(sum);
		if(num.length()==0){
			if(sum==(long)target) res.add(str.toString()); 
			return;
		}
		for(int len=1; len<=num.length(); len++){
			if(len>=2 && num.charAt(0)=='0') continue; //drop irrelevance zero
			long val= Long.parseLong(num.substring(0, len));
			int sb= str.length();
			addOperatorsUtil(num.substring(len), str.append("+").append(val), sum, true, val, target, res);
			str.setLength(sb);
			addOperatorsUtil(num.substring(len), str.append("-").append(val), sum, false, val, target, res);
			str.setLength(sb);
			addOperatorsUtil(num.substring(len), str.append("*").append(val), prev, sign, curr*val, target, res);
			str.setLength(sb);
			/*if(val!=0){
				addOperatorsUtil(num.substring(len), str.append("/").append(val), prev, sign, curr/val, target, res);
				str.setLength(sb);
			}*/
		}
	}
}
