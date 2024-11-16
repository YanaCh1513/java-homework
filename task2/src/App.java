import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Задание 1. Создать URL

        var baseUr1l = "https://example.com/search";
        var params = "query=java&sort=desc&filter=null";

        var urlExample = "https://example.com/search?query=java&sort=desc&filter=null";

        StringBuilder builder = new StringBuilder(baseUr1l + "?");

        // ["query=java", "sort=desc", "filter=null"]
        var paramArray = params.split("&");

        for (var param : paramArray) {
            var keyValue = param.split("=");
            var value = keyValue[1];
            if (!"null".equals(value)) {
                builder.append(param + "&");
            }
        }

        var url = builder.toString();
        url = url.substring(0, url.length() - 1);

        // System.out.println();
        // System.out.println(url);
        // System.out.println();

        // Задача 2. Создание CSV-строки из массива объектов

        String[] headers = new String[] { "Name", "Age", "City" };

        String[][] data = new String[][] {
                { "John", "30", "New York" },
                { "Alice", "25", "Los Angeles" },
                { "Bob", "35", "Chicago" }
        };

        var csvBuilder = new StringBuilder();
        for (String header : headers) {
            csvBuilder.append(header + ",");
        }
        csvBuilder.deleteCharAt(csvBuilder.length() - 1);
        csvBuilder.append('\n');

        for (String[] dataItem : data) {
            for (String value : dataItem) {
                csvBuilder.append(value + ",");
            }
            csvBuilder.deleteCharAt(csvBuilder.length() - 1);
            csvBuilder.append('\n');
        }

        // System.out.println(csvBuilder.toString());

        // Задача 3. Удаление пустых строк из текста.
        System.out.println(("Задача 3. Удаление пустых строк из текста."));
        var text = """
                        sdf


                        sdf

                        sdf

                        sdf
                """;

        var strs = text.split("\n");
        System.out.println(("результат    "));
        var sbCleanText = new StringBuilder();

        for (var str : strs) {
            if (str != "") {
                sbCleanText.append(str + "\n");
            }
        }

        // System.out.println((sbCleanText.toString()));

        // Задача 4. Запись в лог Минимального и Максимального значения массива.

        File file = new File("log.txt");
        file.createNewFile();
        var fileWriter = new FileWriter(file, true);

        var arr = new int[] { 12, 6, 31, 2, 8, 7 };

        var min = arr[0];
        var max = arr[0];

        for (var number : arr) {
            if (number < min)
                min = number;
            if (number > max)
                max = number;
            logStep(min, max, fileWriter);
        }

        fileWriter.close();
    }

    public static void logStep(int min, int max, FileWriter fileWriter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String timestamp = dateFormat.format(new Date());
        try {
            fileWriter.append(timestamp + " " + min + ", " + max + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            // System.out.println(e);
        }
    }
}

//
