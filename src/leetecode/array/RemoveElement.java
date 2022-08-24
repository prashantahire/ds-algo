package leetecode.array;

public class RemoveElement {
    
    public static void main(String ...args) {
        RemoveElement rm = new RemoveElement();
        int a[] = {3, 2, 2, 3};
        System.out.println(rm.removeElement(a, 3));
    }
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != val){
                  nums[i] = nums[j];
            i++;          
            }

        }
        return i;
    }
}
