

package leetecode.backtracking;


public class CanJump {
    public static void main(String... args) {
        CanJump cj = new CanJump();
        int a[] = { 2, 3, 1, 1, 4 };
        int b[] = { 3, 2, 1, 0, 4 };
        int c[] = {2,0};
       // System.out.println(cj.canJumpTopDownWithMemo(a));
        System.out.println(cj.canJumpTopDownWithMemo(c));
        System.out.println(cj.canJumpBottomUp(a));
        System.out.println(cj.canJumpBottomUp(b));
    }

    public boolean canJump(int[] nums) {
        return bt(0, nums);
    }

    private boolean bt(int s, int a[]) {

        if (s == a.length - 1)
            return true;

        if (a[s] == 0)
            return false;
        int farthestjmp = Math.min(s + a[s], a.length);
        for (int i = farthestjmp; i > s; i--) {
            if (bt(i, a))
                return true;
        }
        return false;
    }

    public boolean canJumpTopDownWithMemo(int[] nums) {
        int m[] = new int[nums.length];

        return btTopDownWithMemo(0, nums, m);
    }

    private boolean btTopDownWithMemo(int s, int a[], int memo[]) {

        if (s == a.length - 1) {
            return true;
        }

        if (a[s] == 0) {
            memo[s] = 1;
            return false;
        }
        int farthestjmp = Math.min(s + a[s], a.length-1);
        for (int i = farthestjmp; i > s; i--) {
            if (memo[i] == 0) {
                if (btTopDownWithMemo(i, a, memo)) {
                    memo[i] = 2;
                    return true;
                }
            }
        }
        memo[s] = 1;
        return false;
    }
    
    public boolean canJumpBottomUp(int[] nums) {
        int m[] = new int[nums.length];
        m[nums.length-1] = 2;
        for(int i=nums.length-2; i>=0; i--) {
            int farthestjump = Math.min(i+nums[i], nums.length-1);
            for(int j=i+1; j<=farthestjump; j++) {
                if(m[j] == 2) {
                    m[i] = 2;
                    break;
                }
            }
        }
        return m[0] == 2;
    }    
}
