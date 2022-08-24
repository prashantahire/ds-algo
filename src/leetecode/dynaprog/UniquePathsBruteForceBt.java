package leetecode.dynaprog;

import java.util.Arrays;

public class UniquePathsBruteForceBt {
    
    public static void main(String ...args) {
        UniquePathsBruteForceBt u = new UniquePathsBruteForceBt();
        System.out.println(u.uniquePaths(5, 4));
        System.out.println(u.uniquePaths2TopDownDp(5, 4));
    }
    public int uniquePaths(int m, int n) {
        Count c = new Count();
        uniquePathBt(0, 0, n, m, c);
        return c.cnt;
    }
    
    private void uniquePathBt(int i, int j, int n, int m, Count c) {
        if(i == n-1 && j == m-1) {
            c.cnt++;
        }else if(i == n-1) {
            uniquePathBt(i, j+1, n, m, c);
        }else if(j == m-1) {
            uniquePathBt(i+1, j, n, m, c);
        }else {
            uniquePathBt(i+1, j, n, m, c);
            uniquePathBt(i, j+1, n, m, c);
        }
        
    }

    public int uniquePaths2(int m, int n) {
        return uniqBt2(0,0,m-1,n-1);
    }

    private int uniqBt2(int i, int j, int m, int n){
        if(i==m && j==n)
            return 1;
        if(i>=m)
            return uniqBt2(i,j+1,m,n);
        if(j>=n)
            return uniqBt2(i+1, j,m,n);
        return uniqBt2(i+1,j,m,n)+uniqBt2(i,j+1,m,n);
    }

    public int uniquePaths2BottomUpDp(int m, int n) {
        int a[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(a[i], -1);
        }
        return uniqBtoomUpdp2(0,0, m-1,n-1,a);
    }
    private int uniqBtoomUpdp2(int i, int j, int m, int n, int a[][]){
        if(i==m && j==n)
            return 1;
        if(a[i][j] != -1)
            return a[i][j];

        int tmp = 0;
        if(i>=m)
            tmp = uniqBtoomUpdp2(i,j+1,m,n,a);
        else if(j>=n)
            tmp = uniqBtoomUpdp2(i+1, j,m,n,a);
        else
            tmp = uniqBtoomUpdp2(i+1,j,m,n,a)+uniqBtoomUpdp2(i,j+1,m,n,a);
        a[i][j] = tmp;
        return a[i][j];
    }

    public int uniquePaths2TopDownDp(int m, int n) {
        int a[][] = new int[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(i==0 || j==0)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i-1][j]+a[i][j-1];
            }
        return a[m-1][n-1];
    }
}
class Count{
    int cnt;
}
