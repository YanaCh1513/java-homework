import java.util.ArrayList;
import java.util.HashMap;

class StudentDirectory {
    private HashMap<String, ArrayList<Integer>> studentMap = new HashMap<>();

    // Добавляет или обновляет запись о студенте
    public void addStudent(String name, Integer grade) {
        // Напишите свое решение ниже
        // ArrayList<Integer> grades = studentMap.computeIfAbsent(name, x -> new ArrayList<>());
        // grades.add(grade);

        var studentGrades = studentMap.get(name);
        if (studentGrades == null) {
            studentGrades = new ArrayList<>();
        }
        studentGrades.add(grade);
        studentMap.put(name, studentGrades);
    }

    // Находит оценки студента по имени
    public ArrayList<Integer> findStudent(String name) {
        // Напишите свое решение ниже
        var grades = studentMap.get(name);
        return grades == null ? new ArrayList<Integer>() : grades;
    }

    // Возвращает весь справочник студентов
    public HashMap<String, ArrayList<Integer>> getAllStudents() {
        // Напишите 11свое решение ниже
        return studentMap;
    }

    // Удаляет запись о студенте по имени
    public void removeStudent(String name) {
        // Напишите свое решение ниже
        studentMap.remove(name);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки

public class Task1 {
    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        directory.addStudent("Alice", 90);
        directory.addStudent("Bob", 85);
        directory.addStudent("Alice", 95);
        System.out.println("Before removal:");
        System.out.println(directory.findStudent("Alice")); // [90, 95]
        System.out.println(directory.getAllStudents()); // {Bob=[85], Alice=[90, 95]}
        directory.removeStudent("Alice");
        System.out.println("After removal:");
        System.out.println(directory.findStudent("Alice")); // []
        System.out.println(directory.getAllStudents()); // {Bob=[85]}
    }
}
