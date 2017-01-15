package Google;

import java.util.ArrayList;
import java.util.List;

public class addOperatorsExpression {

	public static void main(String[] args) {
		System.out.println(addOperators("123", 6));
	}
	public static List<String> addOperators(String num, int target) {
		List<String> res= new ArrayList();
		if(num==null|| num.length()==0) return res;
		StringBuilder result= new StringBuilder();
		for(int i=1; i<=num.length(); i++){
			if(i>=2 && num.charAt(0)==0) continue;
			result.append(num.charAt(i-1));
			addOperatorsUtil(num.substring(i), result, Long.parseLong(result.toString()), 0, true, res, target);
		}
		return res;
    }
	private static void addOperatorsUtil(String num, StringBuilder curr, long currval, long prevval, boolean sign, List<String> res, int target) {
		long sum= sign? prevval+currval: prevval-currval;
		if(num.length()==0){
			if(sum==(long) target) res.add(curr.toString());
			return;
		}
		for(int i=1; i<=num.length(); i++){
			if(i>=2 && num.charAt(0)==0) continue;
			long val= Long.valueOf(num.substring(0, i));
			int len= curr.length();
			addOperatorsUtil(num.substring(i), curr.append("+").append(val), val, sum, true, res, target);
			curr.setLength(len);
			addOperatorsUtil(num.substring(i), curr.append("-").append(val), val, sum, false, res, target);
			curr.setLength(len);
			addOperatorsUtil(num.substring(i), curr.append("*").append(val), currval*val, prevval, sign, res, target);
			curr.setLength(len);
			if(val!=0) addOperatorsUtil(num.substring(i), curr.append("/").append(val), currval/val, prevval, true, res, target);
			curr.setLength(len);
		}
		
	}
	
	
}
