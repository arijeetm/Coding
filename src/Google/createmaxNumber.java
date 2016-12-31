package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class createmaxNumber {

	public static void main(String[] args) {
		int res[] = maxNumber(new int[]{1,7,5}, new int[]{8,6,9}, 3);
		for(int i=0; i<res.length; i++) System.out.println(res[i]);
	}
	
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		if(nums1==null && nums2==null) return new int[0]; 
		if((nums1==null || nums1.length==0) && nums2.length==k) return nums2;
		if((nums2==null || nums2.length==0) && nums1.length==k) return nums1;
        List<int[]> result = new ArrayList();
        for(int i=0; i<k; i++){
        	int res[]= new int[k];
        	int l1[]= getMax(nums1, i);
        	int l2[] = getMax(nums2, k-i);
        	if(l1!=null & l2!=null) {
        		merge(l1, l2, res);
        		result.add(res);
        	}
        }
        //elimination
        return findLargestList(result, k);
    }
	
	private static int[] findLargestList(List<int[]> result, int k) {
		for(int i=0; i<k; i++){
			int max=0, len=result.size();
			for(int j=0; j<len; j++){
				max= Math.max(max, result.get(j)[i]);
			}
			for(int j=0; j<result.size(); j++){
				if(result.get(j)[i] != max) {
					result.remove(j);
					j--;
				}
				if(result.size()==1) break;
			}
		}
		return result.get(0);
	}
	
	private static int[] getMax(int a[], int k){

		if(k==0) return new int[0];
		if(k>a.length) return null;
		if(k==a.length) {
			return a;
		}
		int res[]= new int[k];
		int indx=0;
		for(int i=0; i<k; i++){
			int maxindx=indx;
			for(int j= indx; j<=a.length-(k-i); j++){
				if(a[maxindx]<a[j]) maxindx=j;
			}
			res[i]=a[maxindx];
			indx = maxindx+1;
		}
		return res;
	}
	
	private static void merge(int a[], int b[], int res[]){

		if(a==null) { res=b; return;}
		if(b==null) { res=a; return;}
		int i=0, j=0;
		while(i<a.length && j<b.length){
			if(a[i]>b[j]) res[i+j]=a[i++];
			else if(a[i]<b[j]) res[i+j]=b[j++];
			else{ // a[i]==b[j]
				int i1=i, j1=j;
				while(i1<a.length && j1<b.length && a[i1]==b[j1]) {
					i1++; j1++;
				}
				
				if(a[i1]>b[j1]) res[i+j]=a[i++];
				else if (a[i1]<b[j1]) res[i+j]=b[j++];
				else{
					if(i1==a.length) res[i+j]=b[j++];
					else if(j1==b.length) res[i+j]=a[i++];
				}
			}
		}
		while(i<a.length) res[i+j]=a[i++];
		while(j<b.length) res[i+j]=b[j++];
	}
}
