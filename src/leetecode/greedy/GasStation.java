package leetecode.greedy;

public class GasStation {

    public static void main(String ...args){
        int g[] = {1,2,3,4,5};
        int c[] = {3,4,5,1,2};
        //System.out.println(new GasStation().canCompleteCircuit3(g, c));
        int g1[] = {3,3,4};
        int c1[] = {3,4,4};
        System.out.println(new GasStation().canCompleteCircuit3(g1, c1));

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length ==0) return -1;
        if(gas.length == 1) return gas[0]-cost[0] >= 0 ? 0 : -1;
        for(int i=0; i<gas.length; i++){
            int totCoast = gas[i] - cost[i];
            if(totCoast <0)
                continue;
            int j=i+1;
            int total = gas[i];
            while (j !=i){
                j = j == gas.length ? 0 : j;
                total = total - cost[j==0 ? gas.length-1 : j-1];
                if(total < 0)
                    break;
                total = total + gas[j];
                j++;
            }
            if(j==i && total >=0) return i;
        }
        return -1;
    }

    /**
     * Can't go with this greedy approach as it fails for below
     * g[5,8,2,8]
     * c[6,5,6,6]
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit3(int[] gas, int[] cost) {

        int si = -1;
        double maxGCRatio = Double.MIN_VALUE;
        for(int i=0; i<gas.length; i++){
            double tmp = gas[i]/cost[i];
            if(tmp > maxGCRatio){
                maxGCRatio = tmp;
                si = i;
            }
        }

        if(gas[si] < cost[si])
            return -1;

        int j=si+1;
        int total = gas[si];
        while (j != si){
            total = total - cost[j==0 ? gas.length-1 : j-1];
            if(total < 0)
                return -1;
            total = total + gas[j];
            j++;
            j = j == gas.length ? 0 : j;
        }
        return total < cost[si] ? -1 : si;
    }


    /**
     * Neat!
     * Add a small proof to those who feel confused about why we can simply start from the next point when sum is negative:
     * The sum accumulates from res(which is implied in the code).
     *
     * Until station i, each accumulation is positive.
     * If the i makes the sum negative, its cost[i] is bigger than gas[i] by some number x. This x is bigger than the accumulation from res to i-1.
     * Since each accumulation between res and i-1 is positive, subtracting any accumulation from res to j (an index between res to i-1) will make x bigger than the accumulation even more, thus definitely negative to start from any j, between res and i-1.
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {

        if(gas == null || cost == null || gas.length == 0 || cost.length ==0)
            return -1;
        int sum = 0;
        int totalsum = 0;
        int res = 0;
        int len = gas.length;
        for(int i=0; i<len; i++){
            sum+=gas[i]-cost[i];
            if(sum < 0){
                totalsum+=sum;
                sum = 0;
                res = i+1;
            }
        }
        totalsum +=sum;
        return totalsum < 0 ? -1 : res;
    }
}
