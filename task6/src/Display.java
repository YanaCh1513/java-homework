import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

// Все методы для работы с консолью.
public class Display {
    // просто добавляю в конец слово выход, чтобы было понятно, что программа
    // отработала
    public static void displayExitMessage() {
        System.out.println();
        System.out.println();
        System.out.println("Выход");
    }

    public static Boolean getConfirmationFromDisplay(Scanner scanner) {
        // подтверждение добавить еще один фильтр
        System.out.println();
        System.out.println("Добавлить еще фильтр y(да)/n(нет) ?");
        // scanner.nextLine();
        var confirmation = scanner.nextLine();
        return confirmation.equalsIgnoreCase("y");
    }

    public static void displayFilteredLaptops(HashSet<Laptop> laptops) {
        System.out.println();
        System.out.println("Ноутбуки походящие под фильтры:");
        displayLaptops(laptops);
    }

    public static void displayLaptopsAndFilters(HashSet<Laptop> laptops, ArrayList<Filter> filters) {
        // очистить экран
        clearScreen();
        // вывод ноутбуков
        System.out.println("Все доступные ноутубуки:");
        displayLaptops(laptops);
        System.out.println();
        // вывод фильтров
        displayFilters(filters);
    }

    private static void displayFilters(ArrayList<Filter> filters) {
        var i = 1;

        System.out.println("Фильтры:");
        System.out.println("--------");

        if (filters == null || filters.size() == 0) {
            System.out.println("<пусто>");

        }

        for (var filter : filters) {
            // https://javarush.com/en/groups/posts/en.1412.formatting-number-output-in-java
            System.out.printf(
                    "%d.  %-5s %-5s \n",
                    i,
                    String.valueOf(filter.getType()),
                    filter.getValue());
            i++;
        }
    }

    private static void displayLaptops(HashSet<Laptop> laptops) {
        var i = 1;

        System.out.println("------------------------------");

        System.out.printf("%-3s %-5s %-5s %-8s %-3s \n",
                "№", "RAM", "HDD", "OS", "COLOR");

        System.out.println("------------------------------");

        if (laptops.size() == 0) {
            System.out.println("<пусто>");
            return;
        }

        for (var laptop : laptops) {
            // https://javarush.com/en/groups/posts/en.1412.formatting-number-output-in-java
            System.out.printf(
                    // "%d. RAM:%-5s HDD:%-5s OS:%-8s COLOR:%s \n",
                    "%d.  %-5s %-5s %-8s %s \n",
                    i,
                    laptop.getRam(),
                    laptop.getHdd(),
                    laptop.getOs(),
                    laptop.getColor());
            i++;
        }
    }

    public static Filter getFilterFromDisplay(Scanner scanner) {
        var i = 1;
        System.out.println();
        System.out.println("Добавление фильтра");
        System.out.println("------------------");
        System.out.println("Введите цифру, соответствующую критерию:");
        System.out.println();
        for (FilterType filterType : FilterType.values()) {
            System.out.println(i + " - " + filterType);
            i++;
        }

        FilterType criteriaType = FilterType.parce(scanner.nextInt());
        System.out.println();

        scanner.nextLine(); // очистили буффер

        switch (criteriaType) {
            case HDD:
            case RAM:
                System.out.println("Введите значение " + criteriaType + " (число):");
                var intValue = scanner.nextInt();
                scanner.nextLine(); // очистили буффер
                return new Filter(criteriaType, intValue);
            case OS:
            case COLOR:
                System.out.println("Введите значение " + criteriaType + " (строка):");
                var strValue = scanner.nextLine();
                return new Filter(criteriaType, strValue);
        }

        System.out.println("Не  удалось распознать критерий.");
        return null;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
