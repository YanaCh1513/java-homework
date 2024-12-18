import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.PrintStream;

// Все методы для работы с консолью.
public class Display {
    public Display(InputStream in, PrintStream out) {
        this.scanner = new Scanner(System.in);
        this.out = out;
    }

    private Scanner scanner;
    private PrintStream out;

    // просто добавляю в конец слово выход, чтобы было понятно, что программа
    // отработала
    public void displayExitMessage() {
        out.println();
        out.println();
        out.println("Выход");
    }

    public Boolean getConfirmationFromDisplay() {
        // подтверждение добавить еще один фильтр
        out.println();
        out.println("Добавлить еще фильтр y(да)/n(нет) ?");
        // scanner.nextLine();
        var confirmation = scanner.nextLine();
        return confirmation.equalsIgnoreCase("y");
    }

    public void displayFilteredLaptops(HashSet<Laptop> laptops) {
        out.println();
        out.println("Ноутбуки походящие под фильтры:");
        displayLaptops(laptops);
    }

    public void displayLaptopsAndFilters(HashSet<Laptop> laptops, ArrayList<Filter> filters) {
        // очистить экран
        clearScreen();
        // вывод ноутбуков
        out.println("Все доступные ноутубуки:");
        displayLaptops(laptops);
        out.println();
        // вывод фильтров
        displayFilters(filters);
    }

    private void displayFilters(ArrayList<Filter> filters) {
        var i = 1;

        out.println("Фильтры:");
        out.println("--------");

        if (filters == null || filters.size() == 0) {
            out.println("<пусто>");

        }

        for (var filter : filters) {
            // https://javarush.com/en/groups/posts/en.1412.formatting-number-output-in-java
            out.printf(
                    "%d.  %-5s %-5s \n",
                    i,
                    String.valueOf(filter.getType()),
                    filter.getValue());
            i++;
        }
    }

    private void displayLaptops(HashSet<Laptop> laptops) {
        var i = 1;

        out.println("------------------------------");

        out.printf("%-3s %-5s %-5s %-8s %-3s \n",
                "№", "RAM", "HDD", "OS", "COLOR");

        out.println("------------------------------");

        if (laptops.size() == 0) {
            out.println("<пусто>");
            return;
        }

        for (var laptop : laptops) {
            // https://javarush.com/en/groups/posts/en.1412.formatting-number-output-in-java
            out.printf(
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

    public Filter getFilterFromDisplay() {
        var i = 1;
        out.println();
        out.println("Добавление фильтра");
        out.println("------------------");
        out.println("Введите цифру, соответствующую критерию:");
        out.println();
        for (FilterType filterType : FilterType.values()) {
            out.println(i + " - " + filterType);
            i++;
        }

        FilterType criteriaType = FilterType.parce(scanner.nextInt());
        out.println();

        scanner.nextLine(); // очистили буффер

        switch (criteriaType) {
            case HDD:
            case RAM:
                out.println("Введите значение " + criteriaType + " (число):");
                var intValue = scanner.nextInt();
                scanner.nextLine(); // очистили буффер
                return new Filter(criteriaType, intValue);
            case OS:
            case COLOR:
                out.println("Введите значение " + criteriaType + " (строка):");
                var strValue = scanner.nextLine();
                return new Filter(criteriaType, strValue);
        }

        out.println("Не  удалось распознать критерий.");
        return null;
    }

    public void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }
}
