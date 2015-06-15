package example_03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task_01_string_by_delimiter {
    // Краткая подсказка  CRUD File ->  http://devcolibri.com/1141
    public static File file = new File("price_product.txt");

    public static void main(String[] args) {

        //1. Записать в файл (создание файла) продукты
        createPrice(file);

        //2. Читаем файл и выводим в заданном формате на экран
        readAndViewFile(file);

    }


    public static void createPrice(File file) {

        List<String> products = new ArrayList<String>();
        products.add("1| 3.29| mkyong");
        products.add("2| 4.21| Samsung");
        products.add("3| 67.20| Nokia");
        products.add("4| 0.09| LG");


        //проверяем, что если файл не существует то создаем его
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(">>>>  IOException() -> file.createNewFile()");
            }
        }

        try (FileWriter fw = new FileWriter(file)) {

            for (String iter : products) {
                fw.write(iter);
                // разделитель строк или исппользовать System.getProperty("\r\n");
                fw.write(System.getProperty("line.separator"));
            }

        } catch (IOException e) {
            System.err.println(">>>>  IOException() -> FileWriter fw = new FileWriter(file)");
        }
    }


    public static void readAndViewFile(File file) {
        if (!file.exists()) {
            System.out.println("Прайс лист не обнаружен");
            return;
        }

    }

}
