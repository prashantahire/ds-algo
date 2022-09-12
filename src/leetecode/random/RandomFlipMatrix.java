package leetecode.random;

import java.util.*;
public class RandomFlipMatrix {

    int m;
    int n;
    List<String> idxs;
    Random random;

    public RandomFlipMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        idxs = new ArrayList<>();
        fill();
        random = new Random();
    }

    // Time O(m*n)
    public int[] flip() {
        if(idxs.size()==0)
            return null;
        int randomidx = random.nextInt(idxs.size());
        String randomi = idxs.get(randomidx);
        idxs.set(randomidx, idxs.get(idxs.size()-1));
        idxs.remove(idxs.size()-1);
        String nums[] = randomi.split("#");
        return new int[]{Integer.parseInt(nums[0]), Integer.parseInt(nums[1])};
    }

    // Time O(m*n)
    public void reset() {
        idxs.clear();
        fill();
    }

    private void fill(){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                idxs.add(i+"#"+j);
        }
    }
}

class Solution {
    int m;
    int n;
    Random random;
    int total;
    Map<Integer, Integer> map;
    public Solution(int m, int n){
        this.m = m;
        this.n = n;
        map = new HashMap<>();
        random = new Random();
        total = m*n;
    }
    // Time O(1)
    public int[] flip() {
        int rIdx = random.nextInt(total);
        total--;
        int ele = map.getOrDefault(rIdx, rIdx);
        map.put(rIdx, map.getOrDefault(total, total));
        return new int[]{ele/n, ele%n};
    }

    public void reset() {
        total = m*n;
        map.clear();
    }
}