package leetecode.array;

public class SpiralMatrix2 {
    
    public static void main(String ...args) {
        SpiralMatrix2 sm2 = new SpiralMatrix2();
        sm2.generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int a[][] = new int[n][n];
        int lval = n*n;
        int sval =1;
        
        int srow =0, lrow=n-1;
        int scol=0, lcol=n-1;
        
        while(sval<=lval) {
            //first row
            for(int i=scol; i<=lcol; i++) {
                a[srow][i]=sval++;
                
            }
            srow++;
            
            //last column
            for(int i=srow; i<=lrow; i++) {
                a[i][lcol]=sval++;
            }
            lcol--;
            
            //last row
            for(int i=lcol; i>=scol; i--) {
                a[lrow][i] = sval++;
            }
            lrow--;
            
            //first col
            for(int i=lrow; i>=srow; i--) {
                a[i][scol] = sval++;
            }
            scol++;
            
        }
        for(int i=0; i<n; i++) {
            System.out.println();
            for(int j=0; j<n; j++)
                System.out.print(a[i][j]+" ");
        }
        return a;
    }
}
