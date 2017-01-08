import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()"));

	}
	public static int longestValidParentheses(String s) {
		if(s==null|| s.length()==0) return 0;
		int len=s.length();
		Stack<Integer> st= new Stack<Integer>(); 
		for(int i=0; i<len; i++){
			Character ch= s.charAt(i);
			if(ch=='(') st.push(i);
			else {
				if(!st.isEmpty() && s.charAt(st.peek())=='(') 
					st.pop();
				else st.push(i);
			}
		}
		//stack should contain only unbalanced paranthesis
		if(st.isEmpty()) return len; 
		int max=0, end=len;
		while(!st.isEmpty()){
			// consider other substring on right to be valid i.e {start,start+1.....end-1}
			int start= st.pop();
			max= Math.max(max, end-start-1); // maximize their length
			end=start;
		}
		return Math.max(max, end); //first balanced valid substring
	}
}
