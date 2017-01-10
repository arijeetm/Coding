import java.util.Arrays;

class Points{
	int x, y;
	Points(int i, int j){
		x=i; y=j;
	}
}
public class MinimumPolygonTriangulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMinCost(new Points[]{new Points(0, 0), new Points(1, 0), new Points(2, 1), new Points(1, 2), new Points(0, 2)}));
	}
	
	public static double getMinCost(Points[] pts){
		double res=0.0;
		if(pts==null || pts.length<3) return res;
		int n= pts.length;
		double dp[][]= new double[n][n];
		for(int i=0; i<n-2; i++){
			for(int j=i+2; j<n; j++){
				dp[i][j]= Integer.MAX_VALUE;
				for(int k=i+1; k<j; k++){
					double val= dp[i][k]+ dp[k][j]+ findCost(pts[i],pts[j],pts[k]);
					dp[i][j]= Math.min(val, dp[i][j]);
				}
			}
		}
		return dp[0][n-1];
	}

	private static double findCost(Points i, Points j, Points k) {
		return getDistance(i,j) + getDistance(j, k) + getDistance(i, k);
	}
	
	private static double getDistance(Points p1, Points p2){
		return Math.sqrt(Math.pow(p2.x-p1.x, 2.0)  + Math.pow(p2.y-p1.y,2.0));
	}
}
