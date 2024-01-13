import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class MatrixMultiplication {
    public static void main(String[] args) {
        // Set parameters
        int n = 3000; // Adjust based on the size of matrices

        // Create matrix A
        double[][] AData = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AData[i][j] = 1.0;
            }
        }
        RealMatrix A = new Array2DRowRealMatrix(AData);

        // Measure running time for matrix multiplication
        long startTime = System.currentTimeMillis();
        RealMatrix B = compute(A);
        long elapsedTime = System.currentTimeMillis() - startTime;
    }

    private static RealMatrix compute(RealMatrix A) {
        long startTime = System.currentTimeMillis();
        RealMatrix B = A;
        RealMatrix C = null;
        for (int i = 0; i < 100; i++) {
            C = B.multiply(A);
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Matrix Multiplication Time: " + (double) elapsedTime / 1000 + " seconds.");
        return C;
    }

    private static void printMatrix(RealMatrix matrix) {
        int numRows = matrix.getRowDimension();
        int numCols = matrix.getColumnDimension();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix.getEntry(i, j) + " ");
            }
            System.out.println();
        }
    }
}
