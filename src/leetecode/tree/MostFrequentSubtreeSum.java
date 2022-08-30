package leetecode.tree;

import java.util.*;

// TIme O(n)
//Space O(m)
public class MostFrequentSubtreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        int sum = sumRec(root);

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> keySet : map.entrySet()){
            if(keySet.getValue() == maxFreq){
                ans.add(keySet.getKey());
            }
        }
        return ans.stream().mapToInt(k->k).toArray();
    }

    private int sumRec(TreeNode root){
        if(root == null)
            return 0;
        int leftSum = sumRec(root.left);
        int rightSum = sumRec(root.right);
        int sum = root.val + leftSum + rightSum;
        if(!map.containsKey(sum)){
            map.put(sum, 0);
        }
        map.put(sum, map.get(sum)+1);
        maxFreq = Math.max(maxFreq, map.get(sum));
        return sum;
    }
}
