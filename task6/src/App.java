import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        var laptops = new LaptopRepository();
        ArrayList<Filter> filters = new ArrayList<>();

        boolean continueFiltering = true;
        while (continueFiltering) {
            Display.displayLaptopsAndFilters(laptops.get(), filters);

            continueFiltering = Display.getConfirmationFromDisplay(scanner);

            if (!continueFiltering)
                continue;

            Filter filter = Display.getFilterFromDisplay(scanner);
            if (filter != null) {
                filters.add(filter);
            }
        }

        Display.displayLaptopsAndFilters(laptops.get(), filters);

        Display.displayFilteredLaptops(laptops.get(filters));

        Display.displayExitMessage();
    }
}
