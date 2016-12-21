package Google;

public class decodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decodeString("100[leetcode]"));
	}

	public static String decodeString(String s) {
		if(s.contains("[")){
			return decodeStringUtil(s, "");
		}
        return s;
    }
	
	public static String decodeStringUtil(String s, String res) {
		int left=0, count=0, flag=0;
		String str="";
		for(char c: s.toCharArray()){
			if(flag==0 && c>='0' && c<='9'){
				count= count*10 + (c-'0');
				continue;
			}
			if(c=='[') {
				left++;
				if(flag==0)	{
					flag=1;
					continue;
				}
			}
			else if(c==']') {
				left--;
			}
			if(left> 0) str += c;
			if(left==0){
				if(count==0) res+=c;
				else res+=countUtil(str, count);
				str="";
				count=0;
				flag=0;
			}
		}
		if(res.contains("[")) 
			return decodeStringUtil(res, "");
        return res;
    }
	
	private static String countUtil(String str, int count) {
		String res="";
		for(int i=0; i<count; i++){
			res+=str;
		}
		return res;
	}

}
