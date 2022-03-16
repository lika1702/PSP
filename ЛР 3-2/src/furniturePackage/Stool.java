package furniturePackage;

public class Stool extends Chair {
     private float areaSeating;

     //Constructors
    public Stool() {
        super();
        areaSeating = 0;
    }
    public Stool(String manufacturer, float cost, float areaSeating) {
        super(manufacturer, cost);
        this.areaSeating = areaSeating;
    }
    public Stool(String manufacturer, float areaSeating) {
        super(manufacturer);
        this.areaSeating = areaSeating;
    }

    //Getters
    public float getAreaSeating() { return areaSeating; }

    @Override
    public void printInformation() {
        System.out.println("_____ТАБУРЕТ модель N_____\n" +
                "\tПлощадь сидения: " + areaSeating + "м кв.\n" +
                "\tЦена: " + getCost() + " BYN\n" +
                "\tПроизводитель: " + getManufacturer() + '\n');
    }
    @Override
    public void details(int batch) {
        System.out.println("ПРОИЗВОДИТЕЛЬ \"" + getManufacturer() + '\"');
        System.out.println("Для создания требуемой партии табуретов модели N (" + batch +
                " шт.) требуется обрезная доска для сидения общей площадью" + batch * areaSeating + " м кв.\n" +
                "\tповерхность сидения - " + areaSeating + " м кв.\n" +
                "\tножки (4 шт.) - 4 деревянных бруса по 0.5м\n");
    }
}
