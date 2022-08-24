package leetecode.string;

public class MagicalString {
    public int magicalString(int n) {
        int slow=1;
        int fast=1;
        int num=1;
        int a[] = new int[n+2];
        while(fast<=n){
            a[fast] = num;
            fast++;
            if(a[slow]==2){
                a[fast] = num;
                fast++;
            }
            slow++;
            num=3-num;
        }
        int count=0;
        for(int i=1; i<=n; i++){
            if(a[i]==1){
                count++;
            }
        }
        return count;
    }
}
