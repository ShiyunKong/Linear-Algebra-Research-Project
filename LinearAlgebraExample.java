import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import java.util.Random;

public class LinearAlgebraExample {

    // Function to solve a least-squares system Ax = b
    private static double solveLeastSquares(RealMatrix A, RealVector b) {
        long startTime = System.currentTimeMillis();

        // Use Apache Commons Math's LUDecomposition for least squares solution
        RealVector x = new LUDecomposition(A).getSolver().solve(b);

        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0; // Convert milliseconds to seconds
    }

    // Function to compute eigenvalues/vectors of a matrix A
    private static double computeEigenvaluesVectors(RealMatrix A) {
        long startTime = System.currentTimeMillis();

        // Use Apache Commons Math's EigenDecomposition for eigenvalues/vectors
        EigenDecomposition eigenDecomposition = new EigenDecomposition(A);
        double[] eigenvalues = eigenDecomposition.getRealEigenvalues();
        RealMatrix eigenvectors = eigenDecomposition.getV();

        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0; // Convert milliseconds to seconds
    }

    public static void main(String[] args) {
        int m = 4000;  // Number of rows
        int n = m;

        // Generate random matrices A and b
        double[][] AArray = new double[m][n];
        double[] bArray = new double[m];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                AArray[i][j] = random.nextDouble();
            }
            bArray[i] = random.nextDouble();
        }

        RealMatrix A = new Array2DRowRealMatrix(AArray);
        RealVector b = new ArrayRealVector(bArray);

        // Time the least-squares system solution
        double timeLeastSquares = solveLeastSquares(A, b);
        System.out.println("Time taken to solve least-squares system: " + timeLeastSquares + " seconds");

        // Time the eigenvalues/vectors computation
        double timeEigenvaluesVectors = computeEigenvaluesVectors(A);
        System.out.println("Time taken to compute eigenvalues/vectors: " + timeEigenvaluesVectors + " seconds");
    }
}
