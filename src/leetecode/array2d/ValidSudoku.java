package leetecode.array2d;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.') {
                    if (!set.add(board[i][j] + "in row" + i)
                            || !set.add(board[i][j] + "in col" + j)
                            || !set.add(board[i][j] + "in cube"+i/3+""+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
