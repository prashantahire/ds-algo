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
