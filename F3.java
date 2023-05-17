import java.util.Arrays;

public class F3 {
    static int[] O = new int [] {3, 1, 5};
    static int[] P = new int [] {4, 2, 1};
    static int[][] matrixMR = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    static int[][] matrixMS = new int[][]{
            {2, 1, 4},
            {3, 6, 5},
            {8, 7, 1}
    };

    public static void main(String[] args) {
        int[][] matrixTemporaryResult = multiplyMatrices(matrixMR, matrixMS);
        for (int i = 0; i < matrixTemporaryResult.length; i++) {
            for (int j = i+1; j < matrixTemporaryResult.length; j++) {
                float temp = matrixTemporaryResult[i][j];
                matrixTemporaryResult[i][j] = matrixTemporaryResult[j][i];
                matrixTemporaryResult[j][i] = (int) temp;
            }
        }
        int[] vectorTemporaryResult = addVectors(O, P);
        Arrays.sort(vectorTemporaryResult);
        int[] vectorT = multiplyMatricsOnVector(vectorTemporaryResult, matrixTemporaryResult);

        System.out.println("Resultant Vector:");
        for (int value : vectorT) {
            System.out.println(value);
        }

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

    public static int[] addVectors(int[] vector1, int[] vector2) {

        int[] result = new int[vector1.length];

        if (vector1.length != vector2.length) {
            System.out.println("Error! Vectors have to have equal length");
        }

        for (int i = 0; i < vector1.length; i++) {
                result[i] = vector1[i] + vector2[i];
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
