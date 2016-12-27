package Google;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][]{{1},{2}}));

	}
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res= new ArrayList<Integer>();
        if(matrix==null) return null;
        int m=matrix.length;
        if(m==0) return res;
        int n=matrix[0].length;
        int i=0,j=0, row=0, col=0;
        while(i<m && j<n){
        	while(j<n){
            	res.add(matrix[i][j++]);
            }
            n--;
            j--;
            i++;
            while(i<m){
            	res.add(matrix[i++][j]);
            }
          
            m--;
            j--;
            i--;
            if(i<m){
	            while(j>col){
	            	res.add(matrix[i][j--]);
	            }
	            j++;
	            col++;
            }
            if(col<n){
            	while(i>row){
                	res.add(matrix[i--][j]);
                }
                row++;
            }  
            i=row;
            j=col;
        }    	
		return res;  
    }
}
