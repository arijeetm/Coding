package Google;

import java.util.Arrays;

public class UTF8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validUtf8(new int[]{228,189,160,229,165,189,13,10}));
	}

	public static int getBytesInteger(int n){
		int msbmask = (1<<7);
		int num=0;
		while((n & msbmask)==msbmask){
			num++;
			n <<=1;
		}
		return num;
	}
	
	public static boolean validUtf8(int[] data) {
		int n= data.length, a=0, i=0;
		while(i<n) {
			a = getBytesInteger(data[i]);
			System.out.println(a);
			if(a==0) i++;
			else if (a==1 || a > n-i) return false;
			else {
				i++;
				for(int k=1; k<a; k++, i++){
					if(i>=n) return false;
					System.out.println(data[i] + "-" + Integer.toBinaryString(data[i]));
					if(!validateByte(data[i])) return false;
				}
			}
		}
		return true;
	}

	private static boolean validateByte(int data) {
		int msb = 1<<7;
		data &= -1<<6; // clear remaining bits
		if ( (data ^ msb) != 0) return false;
		return true;
	}
}
