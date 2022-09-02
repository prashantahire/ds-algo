package leetecode.math;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class PerfectNumber {
    // Time O(n);
    public boolean checkPerfectNumber(int num) {
        int divsor = 1;
        int sum = 0;
        while(divsor <= num/2){
            if(num%divsor == 0){
                sum+=divsor;
            }
            divsor++;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022, Month.DECEMBER, 31);
        LocalDate prevDate = LocalDate.of(2022, Month.DECEMBER, 1);
        System.out.println(prevDate.until(date, ChronoUnit.DAYS));
    }
}
