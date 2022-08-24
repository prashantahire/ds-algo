package leetecode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        int ans[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                ans[i] = findNextGreater(map.get(nums1[i]), nums1[i], nums2);
            }else
                ans[i] = -1;

        }
        return ans;
    }

    private int findNextGreater(int idx, int ele, int a[]){
        for(int i=idx; i<a.length; i++){
            if(ele < a[i]){
                return a[i];
            }
        }
        return -1;
    }


    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int n : nums2) {
            while(!st.isEmpty() && st.peek() < n){
                map.put(st.pop(), n);
            }
            st.push(n);
        }
        int ans[] = new int[nums1.length];
        for(int i=0; i< nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
