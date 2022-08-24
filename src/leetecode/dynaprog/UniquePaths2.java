package leetecode.dynaprog;

import java.util.Arrays;

public class UniquePaths2 {
    
    public static void main(String ...args) {
        UniquePaths2 up = new UniquePaths2();
        int a[][] = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(up.uniquePathsWithObstacles(a));
        System.out.println(up.uniquePathsWithObstaclesBottomUp(a));
        int b[][] = {{0,0},{1,1},{0,0}};
        System.out.println(up.uniquePathsWithObstacles(b));
        System.out.println(up.uniquePathsWithObstaclesBottomUp(b));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int a[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<a.length;i++)
            if(obstacleGrid[i][0] != 1)
                a[i][0] = 1;
            else
                break;
        
        
        for(int j=0; j<a[0].length; j++)
            if(obstacleGrid[0][j] != 1)
                a[0][j] = 1;
            else
                break;
        
        for(int i=1;i<a.length;i++) {
            for(int j=1;j<a[0].length; j++) {
                if(obstacleGrid[i][j] != 1) {
                    a[i][j] = a[i-1][j]+a[i][j-1];
                }
            }
            
        }
        return a[a.length-1][a[0].length-1];
    }

    public int uniquePathsWithObstaclesBt(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniqBt2(0,0,m-1,n-1, obstacleGrid);
    }

    private int uniqBt2(int i, int j, int m, int n, int a[][]){
        if(i==m && j==n && a[i][j] != 1)
            return 1;
        if(a[i][j] == 1)
            return 0;
        if(i>=m)
            return uniqBt2(i,j+1,m,n,a);
        if(j>=n)
            return uniqBt2(i+1, j,m,n,a);
        return uniqBt2(i+1,j,m,n,a)+uniqBt2(i,j+1,m,n,a);
    }

    public int uniquePathsWithObstaclesBottomUp(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int a[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(a[i], -1);
        }
        return uniqBtoomUpdp2(0,0, m-1,n-1,obstacleGrid, a);
    }
    private int uniqBtoomUpdp2(int i, int j, int m, int n, int o[][], int a[][]){
        if(i==m && j==n && o[i][j] != 1)
            return 1;
        if(o[i][j] == 1)
            return 0;
        if(a[i][j] != -1)
            return a[i][j];

        int tmp = 0;
        if(i>=m)
            tmp = uniqBtoomUpdp2(i,j+1,m,n,o,a);
        else if(j>=n)
            tmp = uniqBtoomUpdp2(i+1, j,m,n,o,a);
        else
            tmp = uniqBtoomUpdp2(i+1,j,m,n,o,a)+uniqBtoomUpdp2(i,j+1,m,n,o,a);
        a[i][j] = tmp;
        return a[i][j];
    }

}
