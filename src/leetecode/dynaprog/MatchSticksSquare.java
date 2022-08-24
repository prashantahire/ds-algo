package leetecode.dynaprog;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatchSticksSquare {
    public boolean makesquare(int[] matchsticks) {
        boolean used[] = new boolean[matchsticks.length];
        return makeSqr(matchsticks, 0, used, 0);
    }

    private boolean makeSqr(int[] matchsticks, int step, boolean used[], int targetLen) {
        if (step >= 4) {
            for (boolean u : used) {
                if (!u)
                    return false;
            }
            return true;
        }
        int len = 0;
        boolean b[] = Arrays.copyOf(used, used.length);
        for (int i = 0; i < matchsticks.length; i++) {
            if (!used[i]) {
                if (step == 0) {
                    targetLen = len + matchsticks[i];
                }
                len += matchsticks[i];
                if (len > targetLen)
                    break;
                used[i] = true;
                if (makeSqr(matchsticks, step + 1, used, targetLen)) {
                    return true;
                }
            }
        }
        used = b;
        return false;
    }

    int possibleSqSide;

    public boolean makesquare2(int[] matchsticks) {
        int total = 0;
        for (int i : matchsticks) {
            total += i;
        }
        possibleSqSide = total / 4;
        if (possibleSqSide * 4 != total)
            return false;
        Map<Pair, Boolean> map = new HashMap<>();
        return makeSqr2(matchsticks, (1<<matchsticks.length), 0, map);
    }

    private boolean makeSqr2(int ms[], Integer usedMs, int sidesDone, Map<Pair, Boolean> memo) {
        Pair pair = new Pair(usedMs, sidesDone);

        int total = 0;
        int n = ms.length;
        for(int i=n-1; i>=0; i--){
            if((usedMs & (1<<i)) == 0){
                total+=ms[n-1-i];
            }
        }
        if(total > 0 && total % this.possibleSqSide == 0){
            sidesDone++;
        }

        if(sidesDone == 3)
            return true;
        if(memo.containsKey(pair))
            return memo.get(pair);

        int c = total / this.possibleSqSide;

        // Remaining vlength in the current partially formed side.
        int rem = this.possibleSqSide * (c + 1) - total;

        boolean ans = false;
        for(int i=n-1; i>=0; i--) {
            if(ms[n - 1 - i] <= rem && (usedMs & (1 << i)) > 0){
                if(makeSqr2(ms, usedMs^(1<<i), sidesDone, memo)){
                    ans = true;
                    break;
                }
            }
        }
        memo.put(pair, ans);
        return ans;
    }

    public static void main(String[] args) {
        MatchSticksSquare ms = new MatchSticksSquare();
        int a[] = {1, 1, 2, 2, 2};
        //System.out.println(ms.makesquare(a));
        Integer i = 1;
        System.out.println(Integer.toBinaryString(i));
        i = (i << 4);
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        i = i - 1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));

    }
}

class Pair {
    int key;
    int value;

    public Pair(int k, int v){
        this.key = k;
        this.value = v;
    }
    @Override
    public int hashCode() {
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Pair)obj).key == this.key && ((Pair)obj).value == this.value;
    }
}