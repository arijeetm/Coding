import java.util.Arrays;
import java.util.Comparator;

class Box{
	int h,w,d;
	Box(int i, int j, int k){
		h=i; w=j; d=k;
	}
}
public class BoxStacking {

	public static void main(String[] args) {
		System.out.println(getMaxHeight(new Box[]{ new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32)}));
	}
	public static int getMaxHeight(Box[] arr){
		if(arr==null || arr.length==0) return 0;
		int n= arr.length, k=0, res=-1, h,w,d;
		Box rot[]= new Box[3*n];
		for(int i=0; i<n; i++){
			rot[k++]= arr[i];	
			
			w = Math.max(arr[i].h, arr[i].d);
			d= Math.min(arr[i].h, arr[i].d);
			h = arr[i].w;
			rot[k++]= new Box(h,w,d);
			
			w= Math.max(arr[i].h, arr[i].w);
			d= Math.min(arr[i].h, arr[i].w);
			h= arr[i].d;	
			rot[k++]= new Box(h,w,d);	
		}
		n*=3;
		Arrays.sort(rot, new Comparator<Box>(){
			@Override
			public int compare(Box o2, Box o1) {
				return (o1.w*o1.d) - (o2.w*o2.d);
			}	
		});
		int msh[]= new int[n];
		for(int i=0; i<n; i++) msh[i]= rot[i].h;
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(rot[j].w>rot[i].w && rot[j].d>rot[i].d && msh[i] < msh[j]+rot[i].h) {
					msh[i]= msh[j]+ rot[i].h;
				}
			}
		}
		for(int i=0; i<n; i++) res= Math.max(res, msh[i]);
		return res;
	}
}
