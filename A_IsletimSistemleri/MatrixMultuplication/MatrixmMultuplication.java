package A_IsletimSistemleri.MatrixMultuplication;

public class MatrixmMultuplication {
    static int M = 20;
    static int G = 20;
    static int N = 20;

    //int TN = 8;

    //int TN = M*N;

    static int matrix1[][] = new int[M][G];
    static int matrix2[][] = new int[G][N];
    static int result [][] = new int[M][N];

    

    static Thread threadArray [] = new Thread[M*N];



    public static void main(String[] args) throws InterruptedException {
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < G; j++) {
                matrix1[i][j] = (int)(Math.random()*10);
            }

            for (int j = 0; j < G; j++) {
                matrix2[j][i] = (int)(Math.random()*10);               
            }

        }

        long beg1 = System.nanoTime();
        multiplyV1();
        long end1 = System.nanoTime();

        printMatrix();



        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                threadArray[i*M+j]= new MatrixMultiplier(matrix1, matrix2, result, i, j);
            }
        }
        

        long beg2 = System.nanoTime();

        for (int i = 0; i < M*N; i++) {
            threadArray[i].start();
        }

        for (int i = 0; i < M*N; i++) {
            threadArray[i].join();
        }
        
        long end2 = System.nanoTime();
        System.out.println("\n\n");
        printMatrix();

        System.out.println("thredsiz süre  =" +  (end1 - beg1) );
        System.out.println("thredli süre =" +  (end2 - beg2) );

    }


    static void multiplyV1(){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < matrix1.length; j2++) {
                    result[i][j] += matrix1[i][j2] * matrix2[j2][j] ;
                }
            }
        }
    }

    static void printMatrix(){
        for ( int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.printf(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

        

    
}


