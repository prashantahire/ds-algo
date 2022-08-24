package leetecode.greedy;

public class BestTimeToBuySellStock2 {
    public int maxProfit(int[] prices) {
        return calcMaxProfit(prices, 0);
    }

    public int calcMaxProfit(int p[], int b){
        if(b == p.length)
            return 0;
        int maxProfit1 = 0;
        for(int j=b; j<p.length; j++){
            int maxProfit2 = 0;
            for(int k=j+1; k<p.length; k++){
                if(p[j] < p[k]){
                    int profit = calcMaxProfit(p, k+1)+p[k]-p[j];
                    if(profit > maxProfit2)
                        maxProfit2 =profit;
                }
            }
            if(maxProfit2 > maxProfit1)
                maxProfit1 = maxProfit2;
        }
        return maxProfit1;
    }

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 1)
            return 0;
        int min = 0, max=0;
        int maxProfit = 0;
        int i=0;
        while(i < prices.length-1){
            while (i < prices.length-1 && prices[i]>=prices[i+1])
                i++;
            min = prices[i];
            i++;
            while (i < prices.length-1 && prices[i] <= prices[i+1])
                i++;
            max = prices[i];
            maxProfit+=(max-min);
            i++;
        }
        return maxProfit;
    }
}
