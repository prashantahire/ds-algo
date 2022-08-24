package leetecode.sorting;

public class Search2DArray {

    public static void main(String ...args){
        int a[][] = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(searchMatrix(a, 5));
        System.out.println(searchMatrix(a, 30));
        System.out.println(searchMatrix(a, 0));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0)
            return false;
        int i=0, j=matrix.length-1;
        while(i<=j){
            int m = (i+j)/2;
            if(matrix[m][0] == target)
                return true;
            else if(target < matrix[m][0])
                j=m-1;
            else
                i=m+1;
        }
        if(j<0 || j>=matrix.length)
            return false;
        int f=0, l=matrix[0].length-1;
        while(f<=l){
            int m = (f+l)/2;
            if(matrix[j][m] == target)
                return true;
            else if(target < matrix[j][m])
                l = m-1;
            else
                f=m+1;
        }
        return false;
    }
}
