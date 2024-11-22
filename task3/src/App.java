import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // Задание 1. Найти все неотризацтельные чсисла в массиве.
        var inputArr = new int[] { -1, 2, -3, 4, -5, 6 };
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int num : inputArr) {
            if (num >= 0) {
                resultList.add(num);
            }
        }

        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        System.out.println("Result: ");
        printArray(resultArr);

        // Задание 2. Уникальные числа.

        var inputArray = new int[] { 1, 2, 2, 3, 4, 5, 5 };
        var uniqueArray = getUniqueArray(inputArray);
        System.out.println("Task 2 result: ");
        printArray(inputArray);
        printArray(uniqueArray);

        // Задание 3. Написать метод, который возвращает массив строк, которые больше
        // 3-х символов.

        var inputStringArray = new String[] { "Привет", "Я", "Снеговичок!" };
        var arrayLess3 = getArrayLess3(inputStringArray);
        printArray(inputStringArray);
        printArray(arrayLess3);

    }

    // Задание 3. Написать метод, который возвращает массив строк, которые больше
    public static String[] getArrayLess3(String[] inputArray) {
        var result = new ArrayList<String>();

        for (String text : inputArray) {
            if (text.length() > 3) {
                result.add(text);
            }
        }

        var resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    // Задание 2. Создание массива уникальных чисел из входного массива.
    public static int[] getUniqueArray(int[] inputArray) {
        var result = new ArrayList<Integer>();
        for (int num : inputArray) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void printArray(int[] arr) {
        var sb = new StringBuilder();
        for (var num : arr) {
            sb.append(num + " ");
        }
        System.out.println(sb.toString());
    }

    public static void printArray(String[] arr) {
        var sb = new StringBuilder();
        for (var num : arr) {
            sb.append(num + " ");
        }
        System.out.println(sb.toString());
    }
}
