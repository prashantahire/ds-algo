package leetecode.dynaprog;

public class UniqueBSTs {

    public static void main(String ...args){
        System.out.println(new UniqueBSTs().numTrees(5));
        System.out.println(new UniqueBSTs().numTreesMem(5));
    }
    public int numTrees(int n) {
        int a[] = new int[n+1];
        a[0] = 1;
        a[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                a[i] = a[i]+a[j]*a[i-j-1];
            }
        }
        return a[n];
    }

    //use backtracking
    public int numTrees2(int n) {
        return numTrees2Bt(1, n);
    }

    public int numTrees2Bt(int left, int right){
        if(left>=right)
            return 1;
        int count = 0;
        for(int i=left; i<=right; i++){
            int countLeftSubTress = numTrees2Bt(left, i-1);
            int countRightSubTress = numTrees2Bt(i+1, right);
            count+=countLeftSubTress*countRightSubTress;
        }
        return count;
    }

    //use memoization/dp
    public int numTreesMem(int n) {
        int a[] = new int[n];
        return numTrees2MemRec(1, n, a);
    }
    public int numTrees2MemRec(int left, int right, int[] a) {
        if(left>=right)
            return 1;
        int count = 0;
        for(int i=left; i<=right; i++){

            //check if number of subtrees with number of nodes n(i-left) calculated
            if(a[i-left] == 0)
                a[i-left] = numTrees2MemRec(left, i-1, a);
            int countLeftSubTress = a[i-left];

            //check if number of subtrees with number of nodes n(i-left) calculated
            if(a[right-i] == 0)
                a[right-i] = numTrees2MemRec(i+1, right, a);
            int countRightSubTress = a[right-i];

            count+=countLeftSubTress*countRightSubTress;
        }
        return count;
    }

}
