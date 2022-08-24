package leetecode.math;

import java.util.HashSet;
import java.util.Set;

public class UglyNumber2 {

    public static void main(String ...args){
        UglyNumber2 un2 = new UglyNumber2();
        un2.nthUglyNumber(15);
        System.out.println();
    }

    public int nthUglyNumberNotWorked(int n) {
        if(n ==0 || n==1)
            return n;
        int ln2=1, ln3=1, ln5=1;
        int i=2, ans=0;
        Set<Integer> set = new HashSet<>();
        while (i<=n){
            int pn2 = ln2*2;
            int pn3 = ln3*3;
            int pn5 = ln5*5;
            ans = Math.min(pn5, Math.min(pn2, pn3));
            if(ans == pn2 && ans == pn3 && ans==pn5) {
                ln2++;
                ln3++;
                ln5++;
            }
            else if(ans == pn2 && ans == pn3){
                ln2++;
                ln3++;
            }else if(ans == pn3 && ans==pn5){
                ln3++;
                ln5++;
            }else if(ans == pn2 && ans==pn5){
                ln2++;
                ln5++;

            }else if(ans == pn2)
                ln2++;
            else if(ans == pn3)
                ln3++;
            else
                ln5++;
            i++;
//            if(ln2%2!=0 || ln2%3!=0 || ln2%5 !=0)
//                ln2++;
//            if(ln3%2!=0 || ln3%3!=0 || ln3%5 !=0)
//                ln3++;
//            if(ln5%2!=0 || ln5%3!=0 || ln5%5 !=0)
//                ln5++;
            System.out.println(ans);
        }
        return ans;
    }

    public int nthUglyNumber(int n) {
        int idx2=0,idx3=0,idx5=0;
        int u[] = new int[n];
        u[0]=1;
        int next_multiple2 = 2, next_multiple3=3, next_multiple5=5;
        for(int i=1; i<n; i++){
            int min_next_multiple = Math.min(next_multiple2, Math.min(next_multiple3, next_multiple5));
            u[i] = min_next_multiple;
            if(min_next_multiple == next_multiple2){
                idx2++;
                next_multiple2 = u[idx2]*2;
            }
            if(min_next_multiple == next_multiple3){
                idx3++;
                next_multiple3 = u[idx3]*3;
            }
            if(min_next_multiple == next_multiple5){
                idx5++;
                next_multiple5 = u[idx5]*5;
            }
        }
        return u[n-1];
    }
}
