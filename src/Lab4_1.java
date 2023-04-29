//Лабораторна робота №4
//Завдання 1
//Варіант 4

import java.io.*;
import java.util.*;

public class Lab4_1 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введіть шлях до вхідного файлу: ");
            String inputFilePath = scanner.nextLine();

            System.out.print("Введіть шлях до вихідного файлу з відсортованими числами: ");
            String sortedFilePath = scanner.nextLine();

            System.out.print("Введіть шлях до вихідного файлу з сумою і добутком: ");
            String resultFilePath = scanner.nextLine();

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(inputFilePath));
            } catch (FileNotFoundException e) {
                System.out.println("Файл не знайдено!");
                return;
            }

            ArrayList < Integer > integers = new ArrayList < > ();
            ArrayList < Double > doubles = new ArrayList < > ();

            String line;
            double sum = 0.0;
            int product = 1;
            try {
                while ((line = reader.readLine()) != null) {
                    try {
                        int integer = Integer.parseInt(line);
                        integers.add(integer);
                        product *= integer;
                    } catch (NumberFormatException e) {
                        try {
                            double doubleValue = Double.parseDouble(line);
                            doubles.add(doubleValue);
                            sum += doubleValue;
                        } catch (NumberFormatException ex) {
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Помилка зчитування з файлу!");
                return;
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття файлу!");
                    return;
                }
            }

            Collections.sort(integers);
            Collections.sort(doubles);

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(sortedFilePath));
                for (int integer: integers) {
                    writer.write(Integer.toString(integer));
                    writer.newLine();
                }
                for (double decimal: doubles) {
                    writer.write(Double.toString(decimal));
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Сума дробових чисел: " + sum);
            System.out.println("Добуток цілих чисел: " + product);
    }
}