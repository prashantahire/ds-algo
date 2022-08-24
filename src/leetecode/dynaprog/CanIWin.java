package leetecode.dynaprog;

import java.util.Arrays;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean availInt[] = new boolean[maxChoosableInteger+1];
        Arrays.fill(availInt, true);
        return canWinRec(availInt, 0, false, desiredTotal);
    }

    private boolean canWinRec(boolean availInt[], int sum, boolean isFirst, int desiredTotal) {
        if(sum >= desiredTotal) {
            return isFirst;
        }
        for(int i=1; i<availInt.length; i++){
            if(availInt[i]) {
                availInt[i] = false;
                if(canWinRec(availInt, sum+i, !isFirst, desiredTotal)){
                    return true;
                }
                availInt[i] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanIWin c = new CanIWin();
        System.out.println(c.canIWin(10, 11));
    }
}
