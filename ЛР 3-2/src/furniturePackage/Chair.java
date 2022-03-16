package furniturePackage;

abstract public class Chair implements Printer, Furniture {
    private String manufacturer;
    private float cost;

    //Constructors
    public Chair() {
        manufacturer = "N/A";
        cost = 0;
    }
    public Chair(String manufacturer, float cost) {
        this.manufacturer = manufacturer;
        this.cost = cost;
    }
    public Chair(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    //Getters
    public String getManufacturer() { return manufacturer; }
    public float getCost() { return cost; }
}
