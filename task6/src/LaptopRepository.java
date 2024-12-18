import java.util.HashSet;
import java.util.ArrayList;

public class LaptopRepository {
    private HashSet<Laptop> laptops; // = new HashSet<Laptop>();

    public LaptopRepository() {
        laptops = new HashSet<>();
        init();
    }

    // conditiona by filter
    private Boolean isLaptopFiltered(Laptop laptop, ArrayList<Filter> filters) {
        for (Filter filter : filters) {
            Boolean result;
            switch (filter.getType()) {
                case RAM:
                    result = laptop.getRam() == filter.getIntValue();
                    break;
                case HDD:
                    result = laptop.getHdd() == filter.getIntValue();
                    break;
                case OS:
                    result = laptop.getOs().equalsIgnoreCase(filter.getStrValue());
                    break;
                case COLOR:
                    result = laptop.getColor().equalsIgnoreCase(filter.getStrValue());
                    break;
                default:
                    result = false;
            }
            if (!result)
                return false;
        }
        return true;
    }

    public HashSet<Laptop> get() {
        return get(null);
    }

    public HashSet<Laptop> get(ArrayList<Filter> filters) {
        HashSet<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (filters == null || isLaptopFiltered(laptop, filters)) {
                result.add(laptop);
            }
        }
        return result;
    }

    private void init() {
        laptops.add(new Laptop(1024, 256, "windows", "black"));
        laptops.add(new Laptop(1024, 256, "windows", "black"));
        laptops.add(new Laptop(2048, 512, "linux", "white"));
        laptops.add(new Laptop(1024, 512, "linux", "black"));
        laptops.add(new Laptop(256, 512, "linux", "white"));
    }
}
