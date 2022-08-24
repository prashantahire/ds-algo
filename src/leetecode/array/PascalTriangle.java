package leetecode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String ...args){
        System.out.println(new PascalTriangle().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list;
        for(int i=0; i<numRows; i++){
            list = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j== i)
                    list.add(1);
                else{
                    list.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
