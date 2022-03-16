package classPackage;

public class Furniture {
    private String material;
    private String manufacturer;
    private float cost;

    //Constructors
    public Furniture() {
        material = new String();
        manufacturer = new String();
        cost = 0.0F;
    }
    public Furniture(String material, String manufacturer, float cost) {
        this.material = material;
        this.manufacturer = manufacturer;
        this.cost = cost;
    }
    public Furniture(String material, String manufacturer) {
        this.material = material;
        this.manufacturer = manufacturer;
        cost = 0.0F;
    }

    //Getters
    public String getMaterial() { return material; }
    public String getManufacturer() { return manufacturer; }
    public float getCost() { return cost; }

    //Methods
    public void print() {
        System.out.println("МАТЕРИАЛ: " + material + '\n' +
                "ПРОИЗВОДИТЕЛЬ: " + manufacturer + '\n' +
                "СТОИМОСТЬ: " + cost + " BYN");
    }
    public void details(int batch) {}
}
