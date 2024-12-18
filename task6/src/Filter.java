
public class Filter {

    private FilterType type;
    private String strValue;
    private int intValue;

    public Filter(FilterType type, int intValue) {
        this.type = type;
        this.intValue = intValue;
    }

    public Filter(FilterType type, String strValue) {
        this.type = type;
        this.strValue = strValue;
    }

    public FilterType getType() {
        return type;
    }

    public String getStrValue() {
        return strValue;
    }

    public int getIntValue() {
        return intValue;
    }

    // любое значение как строку
    public String getValue() {
        switch (type) {
            case RAM:
            case HDD:
                return String.valueOf(getIntValue());
            default:
                return getStrValue();
        }
    }
}
