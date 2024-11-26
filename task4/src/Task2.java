import java.util.LinkedList;

class MyStack {

    LinkedList<String> ll = new LinkedList<String>();

    // Напишите свое решение ниже
    public void push(String element) {
        // Напишите свое решение ниже
        ll.addFirst(element);
    }

    public String pop() {
        // Напишите свое решение ниже
        return ll.removeFirst();
    }

    public String peek() {
        // Напишите свое решение ниже
        return ll.peekFirst();
    }

    public LinkedList<String> getElements() {
        // Напишите свое решение ниже
        return new LinkedList<>(ll);
    }
}

public class Task2 {

    // Задача 2. Реализация стека
    // Реализуйте MyStack с использованием LinkedList с методами:
    // ● push(String element) - добавляет элемент на вершину стека
    // ● pop() - возвращает элемент с вершины и удаляет его
    // ● peek() - возвращает элемент с вершины, не удаляя
    // ● getElements() - возвращает все элементы стека
    public static void main(String[] args) {

        MyStack stack = new MyStack();

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            stack.push("apple");
            stack.push("banana");
            stack.push("pear");
            stack.push("grape");
        } else {
            for (String arg : args) {
                stack.push(arg);
            }
        }
        System.out.println(stack.getElements());
        System.out.println(stack.pop());
        System.out.println(stack.getElements());
        System.out.println(stack.peek());
    }
}
