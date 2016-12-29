package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class isRectangleCoverProb {

	public static void main(String[] args) {
		System.out.println(isRectangleCover(new int[][]
				{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}
						));
	}
	public static boolean isRectangleCover(int[][] rectangles) {
        return isRectangleCoverUtil(rectangles);
    }
	
	/*private static boolean checkOverLap(int[][] rect) {
		int m= rect.length;
		Set<Integer> listX = new HashSet<Integer>();
		Set<Integer> listY = new HashSet<Integer>();
		for(int i=0; i<m; i++){
			int startX = rect[i][0], endX= rect[i][2];
			int startY= rect[i][1], endY= rect[i][3];
			
			if(!listX.add(startX)) listX.remove(startX);
			if(!listX.add(endX)) listX.remove(endX);
			if(!listY.add(startY)) listY.remove(startY);
			if(!listY.add(endY)) listY.remove(endY);
		}
		
		return true;
	}
	
	
	private static boolean doOverLap(int rect1[], int rect2[]){
		
		if(rect1[0]>=rect2[2] || rect2[0] >= rect1[2]) 
			return false;
		else if(rect1[1] >= rect2[3] || rect2[1]>=rect1[3]) 
			return false;
		return true;
	}*/
	
	/*private static int totalSum(int[] area) {
		int sum=0;
		for(int i=0; i<area.length; i++) sum+=area[i];
		return sum;
	}*/
	
	private static boolean isRectangleCoverUtil(int[][] rect){
		int m=rect.length;
		int sumArea=0;
		int minX=Integer.MAX_VALUE, minY=Integer.MAX_VALUE, maxX=0, maxY=0;
		Set<String> point  = new HashSet<String>();
		
		for(int i=0; i<m; i++){
			minX= Math.min(minX, rect[i][0]); //min x
			minY= Math.min(minY, rect[i][1]); //min y
			maxX= Math.max(maxX, rect[i][2]); //max x
			maxY= Math.max(maxY, rect[i][3]); //max y
			
			String leftbottom = rect[i][0]+ "" +  rect[i][1];
			String lefttop = rect[i][0]+ "" +  rect[i][3];
			String righttop = rect[i][2]+ "" +  rect[i][3];
			String rightbottom = rect[i][2]+ "" +  rect[i][1];

			if(!point.add(leftbottom)) point.remove(leftbottom);
			if(!point.add(lefttop)) point.remove(lefttop);
			if(!point.add(righttop)) point.remove(righttop);
			if(!point.add(rightbottom)) point.remove(rightbottom);
			
			sumArea += (rect[i][2]-rect[i][0])*(rect[i][3]-rect[i][1]);	
		}
		
		int barea = (maxX-minX)*(maxY-minY);
		if(sumArea != barea) return false;
		
		if(point.size()!=4) return false;
		if(!point.contains(minX+""+minY) || !point.contains(minX+""+maxY)|| !point.contains(maxX+""+minY) || !point.contains(maxX+""+maxY)) return false;
		return true;
	}
}
