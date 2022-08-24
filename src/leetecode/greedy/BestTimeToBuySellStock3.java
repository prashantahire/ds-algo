package leetecode.greedy;

import java.util.Arrays;

public class BestTimeToBuySellStock3 {

    public static void main(String ...args){
        int a[] = {3,3,5,0,0,3,1,4};
        System.out.println(new BestTimeToBuySellStock3().maxProfit(a));
    }
    public int maxProfit(int[] prices) {
        return calculateProf(prices, 0, 0);
    }

    private int calculateProf(int[] p, int i, int txn){
        if(i == p.length || txn >=2)
            return 0;
        int maxProf1 = 0;
        for(int b=i; b<p.length; b++){
            int maxProf2 = 0;
            for(int s=b+1; s<p.length; s++){
                if(p[b]<p[s]){
                    int profit = calculateProf(p,s+1, txn+1)+p[s]-p[b];
                    if(maxProf2 < profit)
                        maxProf2 = profit;
                }
                if(maxProf1 < maxProf2)
                    maxProf1 = maxProf2;
            }
        }
        return maxProf1;
    }

    //First dp ->Next improve it in next iteration
    public int maxProfitDp1(int[] prices) {
        if(prices == null || prices.length<=1)
            return 0;
        int dp[][] = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        maxProfitDp1Rec(0,0,prices, dp);
        return dp[0][0];
    }

    private int maxProfitDp1Rec(int i, int txn, int p[], int dp[][]){
        if(i == p.length || txn >=2)
            return 0;
        if(dp[txn][i] != -1)
            return dp[txn][i];

        int maxProf1 = 0;
        for(int b=i; b<p.length; b++){
            int maxProf2 = 0;
            for(int s=b+1; s<p.length; s++){
                if(p[b]<p[s]){
                    int profit = maxProfitDp1Rec(s+1, txn+1, p, dp)+p[s]-p[b];
                    if(maxProf2 < profit)
                        maxProf2 = profit;
                }
                if(maxProf1 < maxProf2)
                    maxProf1 = maxProf2;
            }
        }
        dp[txn][i] = maxProf1;
        return maxProf1;
    }




    public int maxProfit2(int[] prices) {
        int profit[] = new int[prices.length];
        int maxprice = prices[prices.length-1];
        int i = prices.length-2;
        while(i >= 0){
            if(maxprice < prices[i])
                maxprice = prices[i];
            if(profit[i] < maxprice-prices[i])
                profit[i] = maxprice-prices[i];
            else
                profit[i] = profit[i+1];
            i--;
        }
        i=1;
        int minprice = prices[0];
        while (i< prices.length){
            if(minprice > prices[i])
                minprice = prices[i];
            if(profit[i-1] > profit[i]+(prices[i]-minprice)){
                profit[i] = profit[i]+(prices[i]-minprice);
            }else
                profit[i] = profit[i-1];
            i++;
        }
        return profit[prices.length-1];
    }
}
