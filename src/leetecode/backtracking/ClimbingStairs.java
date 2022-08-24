package leetecode.backtracking;

public class ClimbingStairs {

    public static void main(String ...args){
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(5));
        System.out.println(cs.csDpBottomUp(5));
        System.out.println(cs.climbStairsTopDown(5));
    }

    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        return climbStairBacktracking(0, n);
    }
    private int climbStairBacktracking(int i, int n){
        if(i==n)
            return 1;
        else if(i > n)
            return 0;
        return climbStairBacktracking(i+1, n)+ climbStairBacktracking(i+2, n);
    }

    public int csDpBottomUp(int n){
        int [] a = new int[n+1];
        for(int i=0; i<=n; i++)
            a[i] = -1;
        return climbStairsDp(n, a);
    }
    private int climbStairsDp(int n, int a[]){
        if(n == 0 || n== 1){
            a[n] = 1;
        }else if(n < 0){
            return 0;
        }
        if(a[n] != -1){
            return a[n];
        }
        a[n] = climbStairsDp(n-1, a) + climbStairsDp(n-2, a);
        return a[n];
    }
    public int climbStairsTopDown(int n){
        int [] a = new int[n+1];
        a[0] = 1;
        a[1] = 1;
        for(int i = 2; i<=n; i++){
            a[i] = a[i-1]+a[i-2];
        }
        return a[n];
    }
}
