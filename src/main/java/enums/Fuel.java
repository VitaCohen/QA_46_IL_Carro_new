package enums;

public enum Fuel {
    DIESEL("Diesel"),
    PERTOL("Petrol"),
    HYBIRD("Hybrid"),
    ELECTRIC("Electric"),
    GAS("Gas");
    private final String fuel;

    Fuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }
}
