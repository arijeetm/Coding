package Google;

import java.util.Stack;

public class basicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("".trim()));
/*		"1 + 1" = 2
				" 2-1 + 2 " = 3
				"(1+(4+5+2)-3)+(6+8)" = 23*/
	}
	public static int calculate(String s) {
		Stack<Integer> st= new Stack<Integer>();
		int res=0, sign=1, num=0;
		for(Character c: s.toCharArray()){
			if(c==' ') continue;
			if(Character.isDigit(c)) num=num*10+ (c-'0');
			if(c=='+'){
				res+= sign* num;
				sign=1;
				num=0;
			}
			if(c=='-'){
				res+= sign*num;
				sign=-1;
				num=0;
			}
			if(c=='('){
				st.push(res);
				st.push(sign);
				res=0;
				sign=1;
				num=0;
			}
			if(c==')'){
				res+= sign*num;
				res*= st.pop();
				res+= st.pop();
				sign=1;
				num=0;
			}
		}
		return num!=0? res+sign*num: res;
	}
}
