public class App {
    public static void main(String[] args) throws Exception {

        // Задание 1. Найти факториал.
        // var fact = factorial1(1);
        // System.out.println(fact);

        // Задание 2. Вывести все четные числа от 0 до 100.
        // printEventNums();

        // Задание 3. Найти сумму цифр.
        // var sum = subDigits(345);
        // System.out.println(sum);

        // Задание 4. Найти максимальное значение из 3-х.
        var result = findMaxOfTree(4, 7, 5);
        System.out.println(result);

        var a = 3;
        var b = 4;
        var c = 6;

    }

    // Задание 4. Найти максимальное значение из 3-х чисел.
    public static int findMaxOfTree(int a, int b, int c) {
        var ab = a > b ? a : b;
        var max = ab > c ? ab : c;
        return max;
    }

    public static int findMaxOfTree2(int a, int b, int c) {
        // положили наши числа в массив
        var arr = new int[] { a, b, c };

        // найти максимум в массиве
        var max = a;
        for (int number : arr) {
            if (number > max)
                max = number;
        }
        return max;
    }

    // не поняла это требование сделать две функции или нет.
    public int findMaxOfTwo(int a, int b) {
        var ab = (a > b) ? a : b;
        return ab;
    }

    public int findMaxOfThree(int a, int b, int c) {
        var ab = findMaxOfTwo(a, b);
        return findMaxOfTwo(ab, c);
    }

    // Задание 3. 2343 -> 2340 -> 234
    // Найти сумму цифр числа.
    public static int subDigits(int n) {
        var sum = 0;
        while (n > 0) {
            var ostatoc = n % 10;
            sum += ostatoc; // sum = sum + ostatok
            n = (n - ostatoc) / 10;
        }

        return sum;
    }

    // Задание 2.
    // Вывести все четные чсисла от 1 до 100. Каждое число на отдельной строке.
    public static void printEventNums() {
        for (var i = 1; i <= 100; i++) { // если делать шаг, i+=2, то условие не нужно.
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    // Задание 1.
    // Найти факториал.
    public static int factorial1(int n) {
        var result = n;

        if (n == 0) {
            result = -1;
        } else {
            for (var i = n - 1; i > 0; i--) {
                result *= i;
            }
        }

        return result;
    }

}
