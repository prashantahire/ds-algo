package leetecode.array;

import java.util.LinkedHashSet;
import java.util.Set;

public class WordSearch2DArray {

    public static void main(String ...args){
        char[][] a = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//        System.out.println(new WordSearch2DArray().exist(a, "ABCCED"));
//        System.out.println(new WordSearch2DArray().exist(a, "SEE"));
//        System.out.println(new WordSearch2DArray().exist(a, "ABCB"));

        char[][] b = {{'a', 'b'}, {'c', 'd'}};
        System.out.println(new WordSearch2DArray().exist2(b, "acdb"));

        char c[][]={{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b'}};
        System.out.println(new WordSearch2DArray().exist2(c, "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
    public boolean exist(char[][] board, String word) {
        Set<String> letterConsidered = new LinkedHashSet<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    letterConsidered.add(i+""+j);
                    if(validWord(i, j, 1, board, word, letterConsidered))
                        return true;
                    letterConsidered.remove(i+""+j);
                }
            }
        }
        return false;
    }

    private boolean validWord(int i, int j, int k, char[][]a, String word, Set<String> lc){
        if(k == word.length())
            return true;
        int rowLen = a.length-1;
        int colLen = a[0].length-1;
        boolean isValid = false;
        if(j<colLen && !lc.contains(i+""+(j+1))&& word.charAt(k) == a[i][j+1]) {
            lc.add(i+""+(j+1));
            isValid = validWord(i, j + 1, k + 1, a, word, lc);
            if(!isValid)
                lc.remove(i+""+(j+1));
        }
        if(i<rowLen && !isValid && !lc.contains((i+1)+""+j)&& word.charAt(k) == a[i+1][j]) {
            lc.add((i + 1) + "" + j);
            isValid = validWord(i + 1, j, k + 1, a, word, lc);
            if (!isValid)
                lc.remove((i + 1) + "" + j);
        }
        if(j>0 && !isValid &&!lc.contains(i+""+(j-1))&& word.charAt(k) == a[i][j-1]) {
            lc.add(i + "" + (j - 1));
            isValid = validWord(i, j - 1, k + 1, a, word, lc);
            if (!isValid)
                lc.remove(i + "" + (j - 1));
        }
        if(i>0 && !isValid && !lc.contains((i-1)+""+j) && word.charAt(k) == a[i-1][j]) {
            lc.add((i - 1) + "" + j);
            isValid = validWord(i - 1, j, k+1, a, word, lc);
            if (!isValid)
                lc.remove((i - 1) + "" + j);
        }
        return isValid;
    }

    public boolean exist2(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(wordBt(i, j, 0, word, board))
                    return true;
            }
        }
        return false;
    }

    public boolean wordBt(int i, int j, int k, String word, char[][] board){
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j] == '.' || word.charAt(k) != board[i][j])
            return false;
        if(k == word.length()-1)
            return true;
        boolean res = false;
        char c = board[i][j];
        board[i][j] = '.';
        res = wordBt(i, j+1, k+1, word, board) || wordBt(i, j-1, k+1, word, board)
                || wordBt(i+1, j, k+1, word, board) || wordBt(i-1, j, k+1, word, board);
        board[i][j] = c;
        return res;
    }
}
