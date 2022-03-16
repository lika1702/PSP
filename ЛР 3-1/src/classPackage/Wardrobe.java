package classPackage;

public class Wardrobe extends Furniture {
    private float width;
    private float height;
    private float depth;

    //Constructors
    public Wardrobe() {
        super();
        width = 0;
        height = 0;
        depth = 0;
    }
    public Wardrobe(String material, String manufacturer, float cost, float width, float height, float depth) {
        super(material, manufacturer, cost);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public Wardrobe(String material, String manufacturer, float width, float height, float depth) {
        super(material, manufacturer);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    //Getters
    public float getWidth() { return width; }
    public float getHeight() { return height; }
    public float getDepth() { return depth; }

    @Override
    public void print() {
        System.out.println("ТИП: Шкаф" + '\n' + "ПАРАМЕТРЫ: " + width + "mx" + height + "mx" + depth + 'm');
        super.print();
    }

    @Override
    public void details(int batch) {
        float shelves = depth * width;
        float sideWalls = 2 * depth * (width + height) + height * width;
        float doors = height * width / 2;
        System.out.println("ПРОИЗВОДИТЕЛЬ \"" + getManufacturer() + '\"');
        System.out.println("Для создания требуемой партии шкафов модели N (" + batch + " шт.) требуется "
                + batch * (sideWalls + 2 * doors + 5 * shelves) + " м кв. ЛДСП, в том числе\n" +
                "\tбоковые стенки - " + sideWalls + " м кв. ЛДСП\n" +
                "\tдверки (2 шт.) - " + doors + " м кв. ЛДСП в расчете на одну\n" +
                "\tполки (5 шт.) - " + shelves + " м кв. ЛДСП в расчете на одну\n");
    }
}
