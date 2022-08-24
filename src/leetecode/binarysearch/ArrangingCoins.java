package leetecode.binarysearch;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long stairs = 0;
        long start = 1, end=n;

        while(start<=end) {

            long mid = (end+start)/2;
            long coins = (mid*(mid+1))/2;
            long remainingCoins = n - coins;
            if(remainingCoins < 0) {
                end = mid;
            } else if(remainingCoins > mid) {
                start = mid+1;
            } else {
                stairs = mid;
                break;
            }

        }
        return (int)stairs;
    }

    public static void main(String[] args) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println(ac.arrangeCoins(5));

        double unroundedFactor = Math.pow(10, 18);
        double roundedFactor = Math.pow(10, 6);
        System.out.println(""+unroundedFactor);
        System.out.println(roundedFactor);

        double rateRoundingFactor = Math.pow(10, 6);
        double costRoundingFactor = Math.pow(10, 2);
        System.out.println(rateRoundingFactor);
        System.out.println(costRoundingFactor);
        int totalDays = (int) ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now()) + 1;
        System.out.println(totalDays);
    }
}
