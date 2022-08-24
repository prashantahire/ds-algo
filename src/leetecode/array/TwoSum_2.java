package leetecode.array;

public class TwoSum_2 {

    public static void main(String ...args){
        TwoSum_2 ts = new TwoSum_2();
        int a[] = {5,25,75};
        int a1[] = ts.twoSum(a, 100);
        System.out.println(a1[0] +"-"+a1[1]);
    }
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int ans[] = new int[2];
        for(int i=0; i<n; i++){
            int num2 = target - numbers[i];
            int i2;
            if(num2 < numbers[i])
                i2 = bstIndxSrch(numbers, 0, i-1, num2);
            else
                i2 = bstIndxSrch(numbers, i+1, n-1, num2);
            if(i2 != -1){
                if(i < i2) {
                    ans[0] = i+1;
                    ans[1] = i2+1;
                }else {
                    ans[0] = i2+1;
                    ans[1] = i+1;
                }
                return ans;
            }
        }
        return ans;
    }

    private int bstIndxSrch(int a[], int i, int j, int val){
        while(i<=j){
            int m = (i+j)/2;
            if(a[m] == val)
                return m;
            if(val < a[m])
                j=m-1;
            else
                i=m+1;
        }
        return -1;
    }

    public int[] twoSum2(int[] numbers, int target){
        int i=0, j=numbers.length-1;
        while (i<j){
            if(numbers[i]+numbers[j] == target)
                break;
            if(numbers[i]+numbers[j] < target)
                i++;
            else
                j--;
        }
        if(i<j){
           return new int[]{i+1, j+1};
        }
        return null;
    }
}
