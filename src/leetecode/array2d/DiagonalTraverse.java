package leetecode.array2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {
    // failed
    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int totEle = r*c;
        int ans[] = new int[totEle];

        int i=0,j=0;
        int k = 0;
        boolean up = true;
        while(k < totEle) {
            if(up){
                while(i>=0&& j<c){
                    ans[k] = mat[i][j];
                    i--;
                    j++;
                    k++;
                }
                i=0;
                j--;
            } else {
                while(i<r && j>=0){
                    ans[k] = mat[i][j];
                    i++;
                    j--;
                    k++;
                }
                i--;
                j=0;
            }
//            int temp = i;
//            i = j;
//            j = temp;
            if(i==r-1 || j==c-1){
                i=1;
                j=c-1;
                continue;
            }
            if(up)
                j++;
            else
                i++;
            up = !up;
        }
        return ans;
    }

    public int[] findDiagonalOrder2(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        List<Integer> updiagonalEles = new ArrayList<>();
        int ans[] = new int[rows*cols];
        int k=0;
        for(int d=0; d<rows+cols-1; d++){

            int r = d < cols ? 0 : d-cols+1;
            int c = d < cols ? d : cols-1;
            updiagonalEles.clear();
            while (r < rows && c > -1){
                updiagonalEles.add(mat[r][c]);
                r++;
                c--;
            }
            if(d%2==0){
                Collections.reverse(updiagonalEles);
            }
            for(int e: updiagonalEles){
                ans[k] = e;
                k++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        DiagonalTraverse d = new DiagonalTraverse();
        int a[][] = {{3}, {2}};
        d.findDiagonalOrder2(a);
    }
}
