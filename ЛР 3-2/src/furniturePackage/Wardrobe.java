package furniturePackage;

public class Wardrobe implements Printer, Furniture {
    private float width;
    private float height;
    private float depth;
    private String manufacturer;
    private float cost;

    //Constructors
    public Wardrobe() {
        width = 0;
        height = 0;
        depth = 0;
        manufacturer = "N/A";
        cost = 0;
    }
    public Wardrobe(String manufacturer, float cost, float width, float height, float depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.manufacturer = manufacturer;
        this.cost = cost;
    }
    public Wardrobe(String manufacturer, float width, float height, float depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.manufacturer = manufacturer;
    }

    //Getters
    public float getWidth() { return width; }
    public float getHeight() { return height; }
    public float getDepth() { return depth; }
    public String getManufacturer() { return manufacturer; }
    public float getCost() { return cost; }

    @Override
    public void printInformation() {
        System.out.println("_____ШКАФ модель N_____" + '\n' +
                "\tПараметры (w/h/d): " + width + "м x " + height + "м x " + depth + "м\n" +
                "\tЦена: " + cost + " BYN\n" +
                "\tПроизводитель: " + manufacturer + '\n');
    }
    @Override
    public void details(int batch) {
        float shelves = depth * width;
        float sideWalls = 2 * depth * (width + height) + height * width;
        float doors = height * width / 2;
        System.out.println("ПРОИЗВОДИТЕЛЬ \"" + manufacturer + '\"');
        System.out.println("Для создания требуемой партии шкафов модели N (" + batch + " шт.) требуется "
                + batch * (sideWalls + 2 * doors + 5 * shelves) + " м кв. ЛДСП, в том числе\n" +
                "\tбоковые стенки - " + sideWalls + " м кв. ЛДСП\n" +
                "\tдверки (2 шт.) - " + doors + " м кв. ЛДСП в расчете на одну\n" +
                "\tполки (5 шт.) - " + shelves + " м кв. ЛДСП в расчете на одну\n");
    }
}
