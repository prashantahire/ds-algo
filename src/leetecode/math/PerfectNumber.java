package leetecode.math;

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
}
