import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numberOfArithmeticSlices(int[] A) {
		if(A==null|| A.length<3) return 0;
		int res=0, len=0;
		for(int i=2; i<A.length; i++){
			if(A[i]-A[i-1]==A[i-1]-A[i-2]){
				len++;
				res+=len;
			}else len=0;
		}
		return res;
	}
	public int numberOfArithmeticSlicesII(int[] A) {
		if(A==null|| A.length<3) return 0;
		int len=A.length, res=0;
		Map<Integer, Integer> map[]= new HashMap[len]; //map[i] is the array of AP's ending at i
		//each  map if a pair of AP difference , count
		for(int i=0; i<len; i++){
			map[i]= new HashMap();
			int curr= A[i];
			for(int j=0; j<i; j++){
				if((long)curr-A[j]>Integer.MAX_VALUE || (long)curr-A[j]<Integer.MIN_VALUE) continue; //ignore
				int diff= curr-A[j];
				int count= map[j].getOrDefault(diff, 0);
				map[i].put(diff, count+1 + map[i].getOrDefault(diff, 0));
				res+=count+1;
			}
		}
		return res;
	}
}
