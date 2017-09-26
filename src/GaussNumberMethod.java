import java.util.Arrays;

public class GaussNumberMethod {

    public double[] getSolution(double[][] oldMatrix) {
        double[][] matrix = new double[oldMatrix.length][oldMatrix.length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = oldMatrix[i][j];
            }
        }

        double[] solution = new double[matrix.length];
        double determinant = getDeterminant(matrix);

        System.out.println("Определитель матрицы: " + determinant);
        if (determinant != 0) {
            for (int i = 0; i < matrix.length - 1; i++) {
                double sum = 0;
                for (int j = 0; j < matrix.length - 1; j++) {
                    sum += solution[j] * matrix[i][j];
                }
                solution[i] = (matrix[i][matrix.length] - sum) / matrix[i][i];
            }
        } else {
            System.out.println("Система имеет бесчисленное множество решений");
        }
        return solution;

//        double mainElement = Math.abs(matrix[0][0]);
//        int mainElementRow = 1;
//        int mainElementColumn = 1;
//
//        for (int k = 0; k < matrix.length; k++) {
//
//
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[i].length; j++) {
//                    if (mainElement < Math.abs(matrix[i][j])) {
//                        mainElement = Math.abs(matrix[i][j]);
//                        mainElementRow = i + 1;
//                        mainElementColumn = j + 1;
//                    }
//                }
//            }
//
//
//        }
//        return new double[0];
    }

    public static double getDeterminant(double[][] matrix) {
        double det = 0;
        int n = matrix.length;
        if (n == 1)
            det = matrix[0][0];
        else if (n == 2)
            det = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        return 0;
    }

    public static double[] getDiscrepancy(double[][] matrix, double[] rightPart, double[] answer) {
        double[] result = new double[answer.length];
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j] * answer[j];
            }
            result[i] = rightPart[i] - sum;
        }
        return result;
    }
}