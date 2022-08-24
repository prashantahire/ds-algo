package leetecode.array;

public class ThemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int tot = 0;
        for(int i=0; i<timeSeries.length-1; i++) {
            int ttp = timeSeries[i]+duration-1;
            if(ttp >=  timeSeries[i+1]){
                tot += timeSeries[i+1]-timeSeries[i];
            } else {
                tot+=duration;
            }
        }
        return tot+=duration;
    }
}
