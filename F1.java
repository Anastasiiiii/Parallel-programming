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
        int[] vectorTemporaryResult3 = multiplyVectorOnScalar(B, min);
        int[] resultMatrix = multiplyMatricsOnVector(vectorTemporaryResult3, matrixTemporaryResult2);


        System.out.println("Resultant Vector:");
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
    public static int[] multiplyVectorOnScalar(int[] vector, OptionalInt p) {

        int[] result = new int[vector.length];

        for (int i = 0; i < vector.length; i++) {
                int sum;
                    sum = vector[i] * p.getAsInt();

                result[i] = sum;
            }
        return result;
        }

    public static int[] multiplyMatricsOnVector( int[] vector, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] finalresult = new int[rows];

        for (int j = 0; j < rows; j++) {
            int sum = 0;
            for (int i = 0; i < cols; i++) {
                sum += vector[i] * matrix[i][j];
            }
            finalresult[j] = sum;
        }
        return finalresult;
    }

}
