package Google;

public class findMedianSortedArraysProb {

	public static void main(String[] args) {
		//System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));

	}
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int n= nums1.length + nums2.length;
			if(n%2==0){
			    double left= findMedian(n/2, nums1, nums2, 0, 0);
				double right= findMedian(n/2+1, nums1, nums2, 0, 0);
				return ( left+right )/2;
			}
			else return findMedian(n/2+1, nums1, nums2, 0, 0);
		}
		
		private double findMedian(int k, int[] a, int[] b, int starta, int startb) {
			if(starta>=a.length) return b[startb+k-1];
			if(startb>=b.length) return a[starta+k-1];
			if(k==1) return Math.min(a[starta], b[startb]); //1st element in sorted array
			int m1= starta+k/2-1;
			int m2= startb+k/2-1;
			double v1= m1<a.length? a[m1]: Double.MAX_VALUE;
			double v2= m2<b.length? b[m2]: Double.MAX_VALUE;
			if(v1<v2) return findMedian(k-k/2, a, b, m1+1, startb);
			return findMedian(k-k/2, a, b, starta, m2+1);
		}
}
