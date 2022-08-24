package leetecode.dynaprog;

public class UniquePaths {
    public static void main(String ...args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(2, 3));
    }
    public static int uniquePaths(int m, int n) {
        int a[][] = new int[n][m];
        for(int i=0; i<m; i++)
            a[0][i] = 1;
        for(int j=0;j<n;j++)
            a[j][0] = 1;
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                a[i][j] = a[i-1][j]+a[i][j-1];
            }
        }
        return a[n-1][m-1];
    }
}
