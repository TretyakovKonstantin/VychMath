import java.io.*;
import java.util.ArrayList;

public class Lab1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите способ ввода матрицы: \n 1 - ввод из файла \n 2 - ввод вручную \n 3 - ввод случайных чисел");
        int inputWay = Integer.parseInt(reader.readLine());
        System.out.println("Введите размер матрицы:");
        int matrixSize = Integer.parseInt(reader.readLine());
        
        double[][] matrix = new double[matrixSize][matrixSize];

        switch (inputWay) {
            case 1:
                System.out.println("Введите полное имя файла");
                matrix = readFromFile(reader.readLine());
                break;
            case 2:
                System.out.println("Введите матрицу");
                matrix = readFromInput(matrixSize);
            case 3:
                System.out.println("Генерирование значений");
                matrix = readRandomMatrix(matrixSize);
        }
        GaussNumberMethod.getDeterminant(matrix);
    }

    private static double[][] readRandomMatrix(int matrixSize) {
        double[][] matrix = new double[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = (Math.random() - 0.5) * 10000;
            }
        }
        return matrix;
    }

    private static double[][] readFromInput(int size){
        System.out.println("Введите матрицу, числа идут через пробелы, строки через перевод строки");
        double[][] matrix = new double[size][size];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < size; i++) {
            try {
                String[] nums = reader.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Double.parseDouble(nums[j]);
                }
            } catch (Exception e) {
                System.out.println("Неправильный ввод");
            }
        }
        return matrix;
    }

    private static double[][] readFromFile(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (
                FileReader read = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(read);
        )

        {
            while (reader.ready()) {
                list.add(reader.readLine());
            }

            double[][] matrix = new double[list.size()][list.size()];
            for (int i = 0; i < list.size(); i++) {
                String[] splittedLine = list.get(i).split(" ");

                if (splittedLine.length != list.size()) {
                    throw new IllegalArgumentException();
                }

                for (int j = 0; j < splittedLine.length; j++) {
                    matrix[i][j] = Double.parseDouble(splittedLine[j]);
                }
            }
            return matrix;

        } catch (NumberFormatException e) {
            System.out.println("В файле лежат не числа.");
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильный размер матрицы во входном файле");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден");
        } catch (IOException e) {
            System.out.println("Не удалось открыть файл");
        }

        return new double[0][0];

    }




    }

