public enum FilterType {
    RAM,
    HDD,
    OS,
    COLOR;

    // Какой же JAVA стремный после C# :)
    public static FilterType parce(int x) {
        switch (x) {
            case 1:
                return RAM;
            case 2:
                return HDD;
            case 3:
                return OS;
            case 4:
                return COLOR;
        }
        return null;
    }
}