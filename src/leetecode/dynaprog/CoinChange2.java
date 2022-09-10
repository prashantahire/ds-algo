package leetecode.dynaprog;

import java.util.*;

public class CoinChange2 {
    int ans= 0;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return dfs(amount, coins, 0);
    }

    private int dfs(int amount, int[] coins, int i){

        if(amount <= 0){
            if(amount == 0) {
                return 1;
            }
            return 0;
        }
        int a = 0;
        for(int j=i; j<coins.length; j++){
            a +=dfs(amount-coins[j], coins, j);
        }
        return a;
    }

    public int change2(int amount, int[] coins) {
        Arrays.sort(coins);
        Map<String, Integer> map = new HashMap<>();
        return dfs(amount, coins, 0, map);
    }

    private int dfs(int amount, int[] coins, int i, Map<String, Integer> map){

        if(amount <= 0){
            if(amount == 0) {
                return 1;
            }
            return 0;
        }
        String key = amount+"#"+i;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int a = 0;
        for(int j=i; j<coins.length; j++){
            a = dfs(amount-coins[j], coins, j, map);
        }
        map.put(key, a);
        return a;
    }

    // Time m*m*n
    // Space m*n
    public int change3(int amount, int[] coins) {
        int a[][] = new int[coins.length][amount+1];
        for(int b[] : a){
            Arrays.fill(b, -1);
        }
        return dfs(amount, coins, 0, a);
    }

    private int dfs(int amount, int coins[], int i, int a[][]){
        if(amount <= 0){
            return amount == 0 ? 1 : 0;
        }
        if(a[i][amount] != -1)
            return a[i][amount];
        int an = 0;
        for(int j=i; j<coins.length; j++){
            an += dfs(amount-coins[j], coins, j, a);
        }
        a[i][amount] = an;
        return an;
    }

    /// Better solution without for-loop

    // Time : 2^n
    public int change4(int amount, int[] coins) {
        return dfs(amount, 0, coins);
    }

    private int dfs(int amount, int i, int[] coins){
        if(amount == 0)
            return 1;
        if(amount < 0 || i == coins.length)
            return 0;
        return dfs(amount-coins[i], i, coins) + dfs(amount, i+1, coins);
    }

    public int change5(int amount, int[] coins) {
        int a[][] = new int[coins.length][amount+1];
        for(int b[] : a){
            Arrays.fill(b, -1);
        }
        return dfs2(amount, 0, coins, a);
    }

    private int dfs2(int amount, int i, int coins[], int a[][]){
        if(amount == 0)
            return 1;
        if(amount < 0 || i == coins.length)
            return 0;
        if(a[i][amount] != -1)
            return a[i][amount];
        a[i][amount] = dfs(amount-coins[i], i, coins) + dfs(amount, i+1, coins);
        return a[i][amount];
    }
    public static void main(String[] args) {
        CoinChange2 cc = new CoinChange2();
        int a[] = {1,2,5};
        System.out.println(cc.change2(5, a));
    }
}
