package Google;

public class TrappingRainWaterSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int[]{0,2,0}));
	}
	public static int trap(int[] height) {
		int n= height.length;
		if(n==0) return 0;
		int left[] = new int[n];
		int right[]= new int[n];
		left[0]=height[0];
		for(int i=1; i<n; i++) left[i]= Math.max(left[i-1], height[i]);
		right[n-1]=height[n-1];
		for(int i=n-2; i>=0; i--) right[i] = Math.max(height[i], right[i+1]);
		int sum=0;
		for(int i=0; i<n; i++)
			sum+= height[i] - Math.min(left[i], right[i]);
		return sum;
	}
}
