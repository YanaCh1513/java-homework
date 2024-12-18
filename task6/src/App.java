import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        var display = new Display(System.in, System.out);
        var laptops = new LaptopRepository();
        var filters = new ArrayList<Filter>();

        // filling filters
        var continueFiltering = true;
        while (continueFiltering) {
            display.displayLaptopsAndFilters(laptops.get(), filters);

            continueFiltering = display.getConfirmationFromDisplay();
            if (continueFiltering) {
                var filter = display.getFilterFromDisplay();
                if (filter != null) {
                    filters.add(filter);
                }
            }
        }

        display.displayLaptopsAndFilters(laptops.get(), filters);
        display.displayFilteredLaptops(laptops.get(filters));

        display.displayExitMessage();
    }
}
