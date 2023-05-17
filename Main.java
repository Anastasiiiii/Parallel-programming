import java.util.Arrays;
import java.util.OptionalInt;

//мій варіант: 1.10, 2.21, 3.11

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
    }
}
//The first Function
class MyThread extends Thread {

    static int[] B = new int[]{4, 7, 1};
    static int[] C = new int[]{2, 6, 3};

    static int[][] matrixMA = new int[][]{
            {1, 3, 6},
            {4, 2, 8},
            {5, 7, 2}
    };

    static int[][] matrixMD = new int[][]{
            {2, 2, 3},
            {3, 4, 6},
            {1, 5, 9}
    };

    public void run() {
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

    public static int[] multiplyMatricsOnVector(int[] vector, int[][] matrix) {
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

//The second function
class MyThread2 extends Thread {

    static int[][] matrixMG = new int[][]{
            {3, 5, 9},
            {4, 1, 6},
            {2, 3, 8}
    };

    static int[][] matrixMH = new int[][]{
            {4, 6, 7},
            {2, 9, 8},
            {4, 4, 1}
    };
    static int[][] matrixMK = new int[][]{
            {9, 3, 2},
            {2, 6, 2},
            {1, 7, 3}
    };

    static int[][] matrixML = new int[][]{
            {4, 1, 2},
            {9, 5, 3},
            {8, 2, 1}
    };

    public void run() {
        int[][] matrixTemporaryResult = multiplyMatrices(matrixMH, matrixMK);
        int[][] matrixTemporaryResult2 = addMatrices(matrixMG, matrixTemporaryResult);
        int[][] matrixMF = addMatrices(matrixTemporaryResult2, matrixML);

        System.out.println("Resultant Matrix:");
        for (int[] row : matrixMF) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
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
}

//The third Function
class MyThread3 extends Thread {

    static int[] O = new int[]{3, 1, 5};
    static int[] P = new int[]{4, 2, 1};
    static int[][] matrixMR = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    static int[][] matrixMS = new int[][]{
            {2, 1, 4},
            {3, 6, 5},
            {8, 7, 1}
    };

    public void run() {
        int[][] matrixTemporaryResult = multiplyMatrices(matrixMR, matrixMS);
        for (int i = 0; i < matrixTemporaryResult.length; i++) {
            for (int j = i + 1; j < matrixTemporaryResult.length; j++) {
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

    public static int[] multiplyMatricsOnVector(int[] vector, int[][] matrix) {
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
