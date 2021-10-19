package A_IsletimSistemleri.MatrixMultuplication;

public class MatrixMultiplier extends Thread{
    private int matrix1[][];
    private int matrix2[][];
    private int result[][];
    private int row;
    private int column;

    public MatrixMultiplier(int[][] matrix1, int[][] matrix2, int[][] result, int row, int column) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.row = row;
        this.column = column;
    }


    public void run(){
        int res = 0;
        for (int i = 0; i < matrix1[row].length; i++) {
            res += matrix1[row][i]*matrix2[i][column];
        }

        result [row][column] = res;
    }


    

}
