
public class BuySellStockWithAtMax2trans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[]{2,1}));
	}
	public static int maxProfit(int[] prices) {
		if(prices==null|| prices.length<2) return 0;
		int len=prices.length;
		int fbuy=Integer.MIN_VALUE, fsell=0, sbuy=Integer.MIN_VALUE, ssell=0, curr;
		for(int i=0; i<len; i++){
			curr=prices[i];
			fbuy=Math.max(fbuy, -curr); 
			fsell=Math.max(fsell, fbuy+curr);
			sbuy=Math.max(sbuy, -curr+ fsell);
			ssell=Math.max(ssell, sbuy+curr);
		}
		return ssell;
	}

}
