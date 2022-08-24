package leetecode.array2d;

public class SurroundedRegions {

    public static void main(String ...args){
        char a[][] = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new SurroundedRegions().solve(a);
        for(int i=0; i<a.length; i++){
            System.out.println("");
            for(int j=0; j<a[0].length; j++)
                System.out.print(a[i][j]+" ");
        }
    }
    public void solve(char[][] board) {

        if(board == null || board.length==0)
            return;
        int boardRow = board.length-1;
        int boardCol = board[0].length-1;

        for(int i=0; i<=boardCol; i++){
            if(board[0][i] == 'O'){
                dfs(1, i, board);
            }
            if(board[boardRow][i] == 'O'){
                dfs(boardRow-1, i, board);
            }
        }

        for(int i=0; i<=boardRow; i++){
            if(board[i][0] == 'O')
                dfs(i, 1, board);
            if(board[i][boardCol] == 'O')
                dfs(i, boardCol-1, board);
        }

        for(int i=1; i<boardRow; i++){
            for(int j=1; j<boardCol; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board){

        if(i==0 || j==0 || i == board.length-1 || j == board[0].length-1)
            return;
        if(board[i][j] == 'O')
            board[i][j] = 'Y';
        else
            return;
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }
}
