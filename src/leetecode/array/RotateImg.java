

package leetecode.array;


public class RotateImg {


    public static void main(String... args) {
        int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        RotateImg r = new RotateImg();
        r.rotate(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println();
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("   " + a[i][j]);
            }
        }
    }

    public void rotate(int[][] matrix) {

        // transpose matrix -> row to col and col to row

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse
        for (int i = 0; i < matrix.length; i++) {
            int k = matrix[i].length - 1;
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                k--;
            }
        }
    }
}
