package leetecode.graph.floodfillAlgo;
//https://leetcode.com/problems/number-of-islands/


//https://guide.freecodecamp.org/algorithms/flood-fill

public class NUmberOfIslandsDFS {

    public static void main(String ...args){
        char g[][] = {
                {'1', '1', '0', '0','0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        NUmberOfIslandsDFS nb = new NUmberOfIslandsDFS();
        System.out.println(nb.numIslands(g));
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int r = grid.length;
        int c = grid[0].length;

        int noOfIslands = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private void dfs(int i, int j,  char g[][]){
        if(i>=0 && j>=0 && i<g.length && j<g[0].length && g[i][j] == '1'){
            g[i][j] = '0';
            dfs(i-1, j, g);
            dfs(i+1, j, g);
            dfs(i, j-1, g);
            dfs(i, j+1, g);
        }
    }
}
