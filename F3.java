public class F3 {
    static int[] O = new int [] {3, 1, 5};
    static int[] P = new int [] {4, 6, 1};
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
        System.out.println("Resultant Matrix:");
        for (int[] row : matrixTemporaryResult) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matrixTemporaryResult.length; i++) {
            for (int j = i+1; j < matrixTemporaryResult.length; j++) {
                float temp = matrixTemporaryResult[i][j];
                matrixTemporaryResult[i][j] = matrixTemporaryResult[j][i];
                matrixTemporaryResult[j][i] = (int) temp;
            }
        }

        System.out.println("Transposed Matrix:");
        for (int[] row : matrixTemporaryResult) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
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

}
