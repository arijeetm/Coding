package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class removeKdigitsProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeKdigits("12345",1));
	}
	public static String removeKdigits(String num, int k) {
		if(num==null || num.isEmpty() || k==0) return num;
		int len=num.length();
		int keep=len-k;
		if(keep<0) return "0";
		Stack<Integer> st= new Stack<Integer>();
		for(int i=0; i<len; i++){
			int val = num.charAt(i)-'0';
			while(!st.isEmpty() && st.peek()>val
			 && st.size() + (len-1-i) >= keep ) //check if we can afford to pop anymore
				//elements in stack + remain elements to be traversed is the maximum value that can be kept
				// so check it we can remove any additional element
			{
				st.pop();
			}
			if(keep > st.size()) { //upper bound
				st.push(val); 
			}
		}
		StringBuilder res = new StringBuilder();
		while(!st.isEmpty())
			res.insert(0, st.pop());
		while(res.length()>0 && res.charAt(0)=='0')
			res.deleteCharAt(0);
		return res.length()==0? "0" : res.toString();
	}
	
	 /*public static String removeKdigits(String num, int k) {
	        if(num==null || num.isEmpty() || k==0) return num;
	        return String.valueOf(removeKdigitsUtil(num,k));
	    }
		public static int removeKdigitsUtil(String num, int k){
			if(num==null || num.isEmpty()) return 0;
			if(k==0) return Integer.valueOf(num);
			int min=Integer.MAX_VALUE;
			for(int i=0; i<num.length(); i++){
				String prev=num;
				num = num.substring(0, i)+num.substring(i+1);
				min= Math.min(min,  removeKdigitsUtil(num, k-1));
				num=prev;
			}
			return min;
		}*/
}
