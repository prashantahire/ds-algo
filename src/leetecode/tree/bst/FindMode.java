package leetecode.tree.bst;
import java.util.*;
import java.util.stream.Collectors;

public class FindMode {
    Map<Integer, Integer> map = new HashMap<>();
    //Time: O(n)
    //Space: O(n)
    public int[] findMode(TreeNode root) {
        findModeRec(root);
        int a[] = new int[map.size()];
        int i=0;
        int maxCnt = 0;

        for(int k : map.keySet()){
            maxCnt = Math.max(maxCnt, map.get(k));
        }
        List<Integer> list = new ArrayList<>();
        for(int k: map.keySet()){
            if(maxCnt == map.get(k)){
                list.add(k);
            }
        }
        return list.stream().mapToInt(k->k).toArray();
    }

    private void findModeRec(TreeNode root){

        if(root == null)
            return;
        findModeRec(root.left);
        if(map.containsKey(root.val)){
            map.put(root.val, map.get(root.val)+1);
        } else{
            map.put(root.val, 1);
        }
        findModeRec(root.right);
    }

    List<Integer> ans = new ArrayList<>();
    TreeNode prev = null;
    int count=1, maxCount=0;
    // Time O(n)
    // Space constant
    public int[] findMode2(TreeNode root) {
        findModeRec(root);
        updateCount();
        return ans.stream().mapToInt(e -> e).toArray();
    }

    private void findModeRec2(TreeNode root){

        if(root == null)
            return;
        findModeRec2(root.left);
        if(prev == null || prev.val != root.val){
            updateCount();
        } else {
            count++;
        }
        prev = root;
        findModeRec2(root.right);
    }

    private void updateCount(){
        if(maxCount < count){
            maxCount = count;
            ans.clear();
            if(prev != null)
                ans.add(prev.val);
        } else if(maxCount == count){
            ans.add(prev.val);
        }
        count = 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right = new TreeNode(2);
        FindMode fm = new FindMode();
        fm.findMode(root);
    }
}
