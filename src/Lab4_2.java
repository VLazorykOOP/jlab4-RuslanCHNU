//Лабораторна робота №4
//Завдання 2
//Варіант 4

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lab4_2 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            System.out.print("Введіть шлях до файлу: ");
            Scanner scanner = new Scanner(System.in);
            String filePath = scanner.nextLine();

            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("Файл не існує!");
                return;
            }

            reader = new BufferedReader(new FileReader(file));
            int charCount = 0;
            int c = reader.read();
            while (c != -1) {
                if (Character.isLetterOrDigit(c)) {
                    charCount++;
                }
                c = reader.read();
            }

            System.out.println("Кількість символів у файлі " + file.getName() + ": " + charCount);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
