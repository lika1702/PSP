package furniturePackage;

public class BarStool extends Chair {
    private String material;
    private float height;

    //Constructors
    public BarStool() {
        super();
        material = "N/A";
        height = 0;
    }
    public BarStool(String manufacturer, float cost, String material, float height) {
        super(manufacturer, cost);
        this.material = material;
        this.height = height;
    }
    public BarStool(String manufacturer, String material, float height) {
        super(manufacturer);
        this.material = material;
        this.height = height;
    }

    //Getters
    public String getMaterial() { return material; }
    public float getHeight() { return height; }

    @Override
    public void printInformation() {
        System.out.println("_____БАРНЫЙ СТУЛ модель N_____\n" +
                "\tМатериал: " + material + "\n" +
                "\tЦена: " + getCost() + " BYN\n" +
                "\tПроизводитель: " + getManufacturer() + '\n');
    }
    @Override
    public void details(int batch) {
        System.out.println("ПРОИЗВОДИТЕЛЬ \"" + getManufacturer() + '\"');
        System.out.println("Для создания требуемой партии барных стульев модели N (" + batch +
                " шт.) требуется сиденье площадью 0.25м кв. материал - " + material + "\n" +
                "высота стула - " + height + " м\n");
    }
}
