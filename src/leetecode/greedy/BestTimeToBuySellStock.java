package leetecode.greedy;

public class BestTimeToBuySellStock {
    public static void main(String ...args){
        int a[]={2,7,1,4};
        System.out.println(new BestTimeToBuySellStock().maxProfit2(a));
    }
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++)
                if(maxProf < (prices[j]-prices[i]))
                        maxProf = prices[j]-prices[i];
        }
        return maxProf;
    }

    //O(n)
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <1)
            return 0;
        int minEle = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(minEle > prices[i])
                minEle = prices[i];
            if(maxProfit < prices[i]-minEle)
                maxProfit = prices[i]-minEle;
        }
        return maxProfit;
    }
}
