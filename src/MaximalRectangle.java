import java.util.Arrays;

public class MaximalRectangle {

	public static void main(String[] args) {
		System.out.println(maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));

	}
	public static int maximalRectangle(char[][] matrix) {
		if(matrix==null || matrix.length==0) return 0;
		int m= matrix.length, n= matrix[0].length;
	    int left[]= new int[n];
	    int right[]= new int[n];
	    int height[]= new int[n];
	    Arrays.fill(right, n);
	    int res=0;
	    for(int i=0; i<m; i++){
	    	//height for each column
	    	for(int j=0; j<n; j++) {
	    		if(matrix[i][j]=='1') height[j]++;
	    		else height[j]=0;
	    	}
	    	//find left and right most boundary for 1
	    	int lb=-1;
	    	for(int j=0; j<n; j++){
	    		if(matrix[i][j]=='1') left[j]= Math.max(left[j], lb+1);
	    		else{
	    			left[j]=0;
	    			lb=j; //latest occurrence of 0
	    		}
	    	}
	    	int rb=n;
	    	for(int j=n-1; j>=0; j--){
	    		if(matrix[i][j]=='1') right[j]= Math.min(right[j], rb);
	    		else{
	    			right[j]=n;
	    			rb=j; // closest occurrence of 0
	    		}
	    	}
	    	for(int j=0; j<n; j++)
	    		res= Math.max(res, (right[j]-left[j])* height[j]);
	    }
	    return res;
	}
}
