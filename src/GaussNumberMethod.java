public class GaussNumberMethod {

    public double[] getSolution(double[][] matrix) {

        double mainElement = Math.abs(matrix[0][0]);
        int mainElementRow = 1;
        int mainElementColumn = 1;

        for (int k = 0; k < matrix.length; k++) {


            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (mainElement < Math.abs(matrix[i][j])) {
                        mainElement = Math.abs(matrix[i][j]);
                        mainElementRow = i + 1;
                        mainElementColumn = j + 1;
                    }
                }
            }


        }

        return new double[0];
    }

    public static int getDeterminant() {
        return 0;
    }
}