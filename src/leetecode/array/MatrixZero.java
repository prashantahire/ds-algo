package leetecode.array;

public class MatrixZero {

    public static void main(String ...aergs){
        int a[][] = {{1,1,1},{1,0,1},{1,1,1}};
        setZero(a);
        for(int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(" "+a[i][j]);
            System.out.println();
        }

    }

    public static void setZero(int a[][]){
        int row[] = new int[a.length];
        for(int i=0; i<a.length; i++)
            row[i] = 1;
        int col[] = new int[a[0].length];
        for(int j=0; j<a[0].length; j++)
            col[j] = 1;
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[i].length; j++){
                if(a[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[0].length; j++){
                if(row[i] == 0 || col[j] == 0){
                    a[i][j] = 0;
                }
            }
    }

    public static void setZeroes(int a[][]){
        boolean isFirstColZero = false;
        for(int i=0; i<a.length; i++){
            if(a[i][0] == 0){
                isFirstColZero = true;
            }
            for(int j=0; j<a[0].length; j++){
                if(a[i][j] == 0){
                    a[0][j] = 0;
                    a[i][0] = 0;
                }
            }
        }
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[0].length; j++){
                if(a[0][j] == 0 || a[i][0] == 0)
                    a[i][j] = 0;
            }
        if(a[0][0] == 0){
            for(int j=0; j<a[0].length; j++){
                a[0][j] = 0;
            }
        }
        if(isFirstColZero){
            for(int i=0; i<a.length;i++){
                a[i][0]=0;
            }
        }
    }
}
