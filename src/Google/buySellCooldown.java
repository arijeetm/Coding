package Google;

import java.util.HashMap;
import java.util.Map;

public class buySellCooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[]{2,4,1,7}));
	}
	public static int maxProfit(int[] prices) {
		return maxProfitUtil(prices);
	}
	private static int maxProfitUtil(int[] prices) {
		if(prices==null || prices.length==0 ) 
			return 0;
		int n =prices.length;
		int buy[] = new int[n];
		int sell[] = new int[n];
		buy[0] = -prices[0];
		sell[0] = 0;
		for(int i=1; i<n; i++){
			sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]); 
			buy[i] = Math.max(buy[i-1], (i<2 ?0: sell[i-2]) - prices[i]); // buy first time or not
		}
		return sell[n-1];
	}
	
	/*
	 * Working code/ TTL Exceeded
	 * public static int maxProfitUtil(int prices[], int indx){
		int n=prices.length, buy=indx, max=0, i=indx;
		if(buy>=n) return 0;
			while(i<n-1 && prices[i+1]<prices[i]) i++;
			if(i==n-1) return 0;
			buy=i;
			for(i=buy+1; i<n; i++)
				max = Math.max(max, Math.max((prices[i]-prices[buy])+ maxProfitUtil(prices, i+2), 
						(prices[i-1]-prices[buy])+ maxProfitUtil(prices, i+1)));
			return max;
	}*/
	
	/*
	 * Attempt to save in cache - Incorrect result
	 * public static int maxProfitUtil(int prices[], int indx, Map<Integer, Integer> cache){
		int n=prices.length, buy=indx, max=0, i=indx;
		if(buy>=n) return 0;
		System.out.println(cache);
		if(cache.get(buy)!=null) return cache.get(buy);
			while(i<n-1 && prices[i+1]<prices[i]) i++;
			if(i==n-1) return 0;
			buy=i;
			for(i=buy+1; i<n; i++){
				max = Math.max(maxProfitUtil(prices, i+2, cache) + (prices[i]-prices[buy]) , 
						 maxProfitUtil(prices, i+2, cache) + (prices[i-1]-prices[buy]));
				System.out.println(max);
				if(cache.containsKey(buy)){
					if(cache.get(buy) < max)  
						cache.put(buy, max);
				}else 
					cache.put(buy, max);
			}
			return max;
	}*/
}
