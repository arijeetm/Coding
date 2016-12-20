package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.sun.xml.internal.ws.util.StringUtils;

public class longestAbsolutePath {

	public static void main(String[] args) {
		System.out.println(lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
				//"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
				//"dir\n\t        file.txt\n\tfile2.txt"));
				//"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
				//"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		//System.out.println(countTabs("        says"));
	}
	
	public static int countTabs(String temp){
		int level=0, i=0;
		for(i=0; temp.charAt(i)=='\t'; i++){}
		level =i;

		for(; temp.charAt(i)==' '; i++){}
		level += (i-level)/4;	
		return level;
	}
	
	public static int lengthLongestPath(String input) {
		LinkedList<String> list = new LinkedList();
		StringTokenizer st = new StringTokenizer(input, "\n");
		int level =0, prevlevel =0, len=0, maxlen=0;
		while(st.hasMoreTokens()){
			String temp = st.nextToken();
			level = countTabs(temp);
			temp = temp.trim();
			for(int i=0; i<(level-prevlevel-1); i++) {
				// managing white spaces before file names
				// each line can have at max an incremental space of 1 tab at max
				list.add("    ");  // padding
				temp = "    " + temp;
			}
			/*
			 * Back tracking
			 */
			while(!list.isEmpty() && level <= prevlevel){
				String last = list.removeLast();
				if(!last.isEmpty()){
					len  -= last.length()+1; //removing name with '/'
				}
				prevlevel--;	
			}
			if(temp!=null){
				list.add(temp);
				len+=temp.length()+1;
				if(temp.contains(".")){
					if(maxlen < (len-1)) { //excluding the last '/' after file name
						maxlen=len-1;
					}
				}
			}
			prevlevel = level;
			level =0;
		}
		return maxlen;
	}
}
