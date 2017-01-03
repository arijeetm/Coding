package Google;

import java.util.ArrayList;
import java.util.List;

public class textJustificationProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fullJustify(new String[]
				{"Listen","to","many,","speak","to","a","few."}, 6));
	}
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
	    int len= words.length;
	    if(len==0) return res;
	    int cost[][]= new int[len][len];
	    int wlen[]= new int[len];
	    for(int i=0; i<len; i++) wlen[i]= words[i].length();
	    for(int i=0; i<len; i++){
	    	cost[i][i]= maxWidth-wlen[i];
	    	for(int j=i+1; j<len; j++){
	    		cost[i][j]= cost[i][j-1] - wlen[j] -1;
	    	}
	    }
	    for(int i=0; i<len; i++){
	    	for(int j=0; j<len; j++){
	    		if(cost[i][j]<0) cost[i][j]= Integer.MAX_VALUE;
	    		else cost[i][j]= cost[i][j]*cost[i][j];
	    	}
	    }
	    
	    int indx[]= new int[len];
	    int mincost[]= new int[len];
	    for(int i=len-1; i>=0; i--){
	    	mincost[i]= cost[i][len-1];
	    	indx[i]= len;
	    	for(int j=len-1; j>=i; j--){
	    		if(cost[i][j]==Integer.MAX_VALUE) continue;
	    		if(j<len-1 && mincost[i] > cost[i][j] + mincost[j+1]){
	    			mincost[i]= cost[i][j] + mincost[j+1];
	    			indx[i]= j+1;
	    		}
	    	}
	    }
	   
	    int i=0;
	    while(i<len){
	    	StringBuilder str= new StringBuilder(maxWidth);
	    	for(int j=i; j<indx[i]; j++) {
	    		str.append(words[j]);
	    		if (str.length()<maxWidth) str.append(" "); 
	    	}    		
	    	while(str.length()<maxWidth) str.append(" ");
	    	res.add(str.toString());
	    	i= indx[i];
	    }
	    return res;
	}
}
