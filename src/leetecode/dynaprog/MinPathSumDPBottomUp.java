package leetecode.dynaprog;

public class MinPathSumDPBottomUp {
    
    public static void main(String ...args) {
        int a[][] = {{1,3,1},{1,5,1},{4,2,1}};
        MinPathSumDPBottomUp mp = new MinPathSumDPBottomUp();
        System.out.println(mp.minPathSum(a));
        System.out.println(mp.minPathSumTopDown(a));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int s[][] = new int[m][n];
        return minPathSumBt(0, 0, m-1, n-1,grid, s);
    }
    
    private int minPathSumBt(int i, int j, int m, int n, int a[][], int s[][]) {
        if(i == m && j == n) {
            return a[i][j];
        }
        if(s[i][j] != 0)
            return s[i][j];
        int pathSumRight = 0, pathSumDown=0, prevMinSum = 0;
        if(i<m && j<n) {
            pathSumRight = minPathSumBt(i, j+1, m,n,a, s);
            pathSumDown = minPathSumBt(i+1, j, m,n,a, s);
            prevMinSum = Math.min(pathSumRight, pathSumDown);
        }else if(i<a.length-1)
            prevMinSum = minPathSumBt(i+1, j, m,n,a, s);
        else
            prevMinSum = minPathSumBt(i, j+1, m,n,a, s);
        s[i][j] = a[i][j] + prevMinSum;
        return s[i][j];
    }

    public int minPathSumTopDown(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int s[][] = new int[m][n];
        s[0][0] = grid[0][0];

        //Fill the 0 column rows
        for(int i=1; i<m; i++){
            s[i][0] =grid[i][0]+s[i-1][0];
        }

        //Fill the 0 row columns
        for(int j=1; j<n; j++){
            s[0][j] =grid[0][j]+s[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                    s[i][j] = grid[i][j] + Math.min(s[i-1][j], s[i][j-1]);
            }
        }
        return s[m-1][n-1];
    }
}
