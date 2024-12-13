import java.util.Arrays;

class MergeSort {
    public static void merge(int[] left, int[] right, int[] result) {
        // Введите свое решение ниже
        int i = 0, j = 0, k = 0;
        // Объединение элементов из массива left и right в массив result
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        // Копирование оставшихся элементов из массива left (если есть)
        while (i < left.length) {
            result[k++] = left[i++];
        }
        // Копирование оставшихся элементов из массива right (если есть)
        while (j < right.length) {
            result[k++] = right[j++];
        }

    }

    public static void mergeSort(int[] array) {
        // Введите свое решение ниже
        if (array.length < 2) {
            return; // Массив с одним элементом уже отсортирован
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        // Рекурсивная сортировка двух половин
        mergeSort(left);
        mergeSort(right);
        // Объединение отсортированных половин
        merge(left, right, array);
    }

    // Не удаляйте и не меняйте метод Main!
    public class Task4 {
        public static void main(String[] args) {
            int[] initArray;
            if (args.length == 0) {
                initArray = new int[] { 38, 27, 43, 3, 9, 82, 10 };
            } else {
                initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            System.out.println("Initial array:");
            System.out.println(Arrays.toString(initArray));
            MergeSort.mergeSort(initArray);
            System.out.println("Sorted array:");
            System.out.println(Arrays.toString(initArray));
        }
    }
}