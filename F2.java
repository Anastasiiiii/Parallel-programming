public class F2 {
    static int[][] matrixMG = new int[][] {
            {3, 5, 9},
            {4, 1, 6},
            {2, 3, 8}
    };

    static int[][] matrixMH = new int[][]{
            {4, 6, 7},
            {2, 9, 8},
            {4, 4, 1}
    };
    static int[][] matrixMK = new int[][] {
            {9, 3, 2},
            {2, 6, 2},
            {1, 7, 3}
    };

    static int[][] matrixML = new int[][]{
            {4, 1, 2},
            {9, 5, 3},
            {8, 2, 1}
    };

    public static void main(String[] args) {
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
