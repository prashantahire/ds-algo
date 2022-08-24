package leetecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {

    public static void main(String ...args){
        System.out.println(new PascalTriangle2().getRow(4));
    }
    public List<Integer> getRow(int rowIndex) {
        Integer a[] = new Integer[rowIndex+1];
        int temp=1;
        for(int i=0; i<=rowIndex; i++)
        {
            for(int j=0; j<=i; j++){
                if(j==0||j == i) {
                    a[j] = 1;
                    temp = 1;
                }
                else {
                    int temp1 = a[j];
                    a[j] = temp+a[j];
                    temp = temp1;
                }
            }
        }
        return Arrays.asList(a);
    }
}
