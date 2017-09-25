import java.io.*;
import java.util.ArrayList;

public class Lab1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите способ ввода матрицы: \n 1 - ввод из файла \n 2 - ввод вручную \n 3 - ввод случайных чисел");
        int inputWay = Integer.parseInt(reader.readLine());
        System.out.println("Введите размер матрицы:");
        int matrixSize = Integer.parseInt(reader.readLine());

        switch (inputWay) {
            case 1:
                readFromInput();


        }

        String fileName = "E:\\t.txt";

    }

    private static void readFromInput(){

    }

    private void readFromFile(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (
                FileReader read = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(read);
        )

        {
            while (reader.ready()) {
                list.add(reader.readLine());
            }

            int[][] matrix = new int[list.size()][list.size()];
            for (int i = 0; i < list.size(); i++) {
                String[] splittedLine = list.get(i).split(" ");

                if (splittedLine.length != list.size()) {
                    throw new IllegalArgumentException();
                }

                for (int j = 0; j < splittedLine.length; j++) {
                    matrix[i][j] = Integer.parseInt(splittedLine[j]);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("В файле лежат не числа.");
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильный размер матрицы во входном файле");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден");
        } catch (IOException e) {
            System.out.println("Не удалось открыть файл");
        }

    }




    }

