import java.util.LinkedList;
import java.util.ListIterator;

class LLTasks {
    public static void removeOddLengthStrings(LinkedList<String> ll) {
        // Напишите свое решение ниже
        // https://javarush.com/quests/lectures/questsyntaxpro.level13.lecture04
        // использовали итераторы для максимально произовдительности

        ListIterator<String> iterator = ll.listIterator();
        while (iterator.hasNext()) {
            var element = iterator.next();
            if (element.length() % 2 != 0) {
                iterator.remove(); // операции удаления внутри итератора выполняются очень быстро для LinkedList
            }
        }
    }
}

// Задание 1. Удаление нечетных строк
// Дан LinkedList с несколькими элементами. В методе
// removeOddLengthStrings класса LLTasks реализуйте удаление строк, длина
// которых нечетная. Используйте LinkedList и стандартные методы.

public class Task1 {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            ll.add("apple");
            ll.add("banana");
            ll.add("pear");
            ll.add("grape");
        } else {
            for (String arg : args) {
                ll.add(arg);
            }
        }
        LLTasks answer = new LLTasks();
        System.out.println(ll);
        answer.removeOddLengthStrings(ll);
        System.out.println(ll);
    }
}
