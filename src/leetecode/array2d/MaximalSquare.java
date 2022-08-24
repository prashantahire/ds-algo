package leetecode.array2d;

public class MaximalSquare {

    public static void main(String... args) {
        char a[][] = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},};

        char a1[][] = {{'0', '1'}};

        char a2[][] = {{'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '0'}};

        char a3[][] = {
                {'0','0','0','1','0','1','1','1'},
                {'0','1','1','0','0','1','0','1'},
                {'1','0','1','1','1','1','0','1'},
                {'0','0','0','1','0','0','0','0'},
                {'0','0','1','0','0','0','1','0'},
                {'1','1','1','0','0','1','1','1'},
                {'1','0','0','1','1','0','0','1'},
                {'0','1','0','0','1','1','0','0'},
                {'1','0','0','1','0','0','0','0'}};

        char a4[][] = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        MaximalSquare ms = new MaximalSquare();
        System.out.println(ms.maximalSquare(a1));
        System.out.println(ms.maximalSquare(a2));
        System.out.println(ms.maximalSquare(a3));
        System.out.println(ms.maximalSquare(a4));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxSize = 0;
        int rs = matrix.length;
        int cs = matrix[0].length;

        for (int i = 0; i < rs; i++) {
            for (int j = 0; j < cs; j++) {

                if (matrix[i][j] == '1') {
                    int qsize = sqsize(i, j, rs, cs, matrix);
                    if (maxSize < qsize)
                        maxSize = qsize;
                }
            }
        }
        return maxSize*maxSize;
    }

    private int sqsize(int i, int j, int rs, int cs, char a[][]) {
        int diagonalLen=1;
        boolean flag = true;
        while (i+diagonalLen < rs && j+diagonalLen<cs && flag){
            //digaonal index row - check
            for(int k=j; k<= j+diagonalLen; k++){
                if(a[i+diagonalLen][k] == '0'){
                    flag = false;
                    break;
                }
            }

            //diagonal index column check

            for(int k=i; k <= i+diagonalLen; k++){
                if(a[k][j+diagonalLen] == '0'){
                    flag = false;
                    break;
                }
            }
            if(flag)
            diagonalLen++;
        }
        return diagonalLen;
    }


    //DP
    public int maximalSquareDp(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxSize = 0;
        int rs = matrix.length;
        int cs = matrix[0].length;

        int a[][] = new int[rs+1][cs+1];
        for(int i=0; i<rs; i++){
            for(int j=0; j<cs; j++){
                if(matrix[i][j] == '1'){
                    int len = Math.min(Math.min(a[i][j-1], a[i-1][j]), a[i-1][j-1]+1);
                    maxSize = Math.max(maxSize, len);
                }
            }
        }
        return maxSize*maxSize;
    }
}
