package liftoff;

public class PrintArrayDiagonal {

    public static void main(String ...args){
        int a[][] = {
                {1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        printArrayDiagoanUpperRightToLowerLeft(a);
    }
    public static void printArrayDiagoanUpperRightToLowerLeft(int a[][]){

        int row = a.length;
        int col = a[0].length;

        for(int i=0; i<col; i++){
            int rowi=0;
            int j=i;
            while (rowi < row && j>=0){
                System.out.print(" "+a[rowi][j]);
                rowi ++;
                j --;
            }
            System.out.println();
        }

        for(int j=1; j<row; j++){
            int rowi = j;
            int colj = col-1;
            while (rowi < row && colj>=0){
                System.out.print(" "+a[rowi][colj]);
                rowi++;
                colj--;
            }
            System.out.println();
        }
    }
}
