import java.util.Arrays;
import java.util.OptionalInt;

public class F1 {
    static int[] B = new int [] {4, 7, 1};
    static int[] C = new int [] {2, 6, 3};

    static int[][] matrixMA = new int[][] {
            {1, 3, 6},
            {4, 2, 8},
            {5, 7, 2}
    };

    static int[][] matrixMD = new int[][]{
            {2, 2, 3},
            {3, 4, 6},
            {1, 5, 9}
    };


    public static void main(String[] args) {
        int[][] matrixTemporaryResult = multiplyMatrices(matrixMA, matrixMD);
        int[][] matrixTemporaryResult2 = addMatrices(matrixTemporaryResult, matrixMD);
        OptionalInt min = Arrays.stream(C).min();
        int[][] matrixTemporaryResult3 = multiplyMatricsOnScalar(matrixTemporaryResult2, min);
        int[] resultMatrix = multiplyMatricsOnVector(matrixTemporaryResult3, B);

        System.out.println("Resultant Matrix:");
        for (int value : resultMatrix) {
            System.out.println(value);
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                int sum = 0;
                for (int k = 0; k < cols1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    public static int[][] multiplyMatricsOnScalar(int[][] matrix, OptionalInt p) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum;
                {
                    sum = matrix[i][j] * p.getAsInt();
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
    public static int[] multiplyMatricsOnVector(int[][] matrix, int[] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] finalresult = new int[rows];

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j] * vector[j];
            }
            finalresult[i] = sum;
        }
        return finalresult;
    }

}
