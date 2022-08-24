package leetecode.dynaprog;

public class UniquePathsDP {
    
    public static void main(String ...args) {
        UniquePathsDP u = new UniquePathsDP();
        System.out.println(u.uniquePaths(51, 9));
    }
    public int uniquePaths(int m, int n) {
        int a[][] = new int[n][m];
        uniquePathBt(0, 0, n, m, a);
        return a[0][0];
    }
    private int uniquePathBt(int i, int j, int n, int m, int a[][]) {
        if(i == n-1 && j==m-1) {
            a[i][j] = 1;
        }
        if(a[i][j] != 0)
            return a[i][j];
        
        int pathRight=0; int pathDown = 0;
        if(i < n-1 && j< m-1) {
            pathRight = uniquePathBt(i, j+1, n, m, a);
            pathDown = uniquePathBt(i+1, j, n, m, a);
        }else if(i<n-1)
            pathDown = uniquePathBt(i+1, j, n, m, a);
        else
            pathRight = uniquePathBt(i, j+1, n, m, a);
        
        a[i][j] = pathDown+pathRight;
        return pathDown+pathRight;
    }
}
