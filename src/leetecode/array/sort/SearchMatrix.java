package leetecode.array.sort;

public class SearchMatrix {

    public static void main(String ...args){
        int a[][] = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int b[][] = {{-1}, {-1}};
        System.out.println(new SearchMatrix().searchMatrix(b, 5));
    }
    //O(nlogn)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0)
            return false;
        int trow = bsCols(matrix, target);
        if(trow <0 || trow >= matrix.length)
            return false;
        if(matrix[trow][0] == target)
            return true;
        for(int i=trow; i>=0; i--){
            if(bsRows(matrix, target, i))
                return true;
        }
        return false;
    }

    private int bsCols(int a[][], int target){

        int i=0, j=a.length-1;
        while (j>=i){
            int m = (i+j)/2;
            if(a[m][0] == target)
                return m;
            if(target > a[m][0])
                i = m+1;
            else
                j=m-1;
        }
        return j;
    }
    private boolean bsRows(int a[][], int target, int r){
        int i=0, j=a[r].length-1;
        while (j>=i){
            int m= (i+j)/2;
            if(a[r][m] == target)
                return true;
            if(target > a[r][m])
                i = m+1;
            else
                j=m-1;
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0)
            return false;
        int row = 0; int col = matrix[0].length-1;

        while (row < matrix.length && col >=0){
            if(matrix[row][col] == target)
                return true;
            if(target > matrix[row][col])
                row++;
            else if(target < matrix[row][col])
                col--;
        }
        return false;
    }
}
