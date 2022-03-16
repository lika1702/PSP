package furniturePackage;

public class Table implements Printer, Furniture {
    private int quantityOfDrawer;
    private float areaOfSurface;
    private float areaSide;
    private String manufacturer;
    private float cost;

    //Constructors
    public Table() {
        manufacturer = "N/A";
        cost = 0;
        quantityOfDrawer = 0;
        areaOfSurface = 0;
        areaSide = 0;
    }
    public Table(String manufacturer, float cost, int quantityOfDrawer, float areaOfSurface, float areaSide) {
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.quantityOfDrawer = quantityOfDrawer;
        this.areaOfSurface = areaOfSurface;
        this.areaSide = areaSide;
    }
    public Table(String manufacturer, int quantityOfDrawer, float areaOfSurface, float areaSide) {
        this.manufacturer = manufacturer;
        this.quantityOfDrawer = quantityOfDrawer;
        this.areaOfSurface = areaOfSurface;
        this.areaSide = areaSide;
    }

    //Getters
    public int getQuantityOfDrawer() { return  quantityOfDrawer; }
    public float getAreaOfSurface() { return  areaOfSurface; }
    public float getAreaSide() { return  areaSide; }
    public String getManufacturer() { return manufacturer; }
    public float getCost() { return cost; }

    @Override
    public void details(int batch) {
        System.out.println("ПРОИЗВОДИТЕЛЬ \"" + manufacturer + '\"');
        System.out.println("Для создания требуемой партии столов модели N (" + batch + " шт.) требуется "
                + batch * (areaOfSurface + quantityOfDrawer * 1.5) + " м кв. ЛДСП, в том числе\n" +
                "\tрабочая поверхность - " + areaOfSurface + " м кв. ЛДСП\n" +
                "\tвыдвижные ящики (" + quantityOfDrawer + " шт.) - 1.5 м кв. ЛДСП в расчете на один\n" +
                "\tбоковые части (2 шт.) - " + areaSide + " м кв. ЛДСП в расчете на одну\n");
    }

    @Override
    public void printInformation() {
        System.out.println("_____СТОЛ модель N_____" + '\n' +
                "\tПлощадь рабочей поверхности: " + areaOfSurface + "м кв.\n" +
                "\tЦена: " + cost + " BYN\n" +
                "\tПроизводитель: " + manufacturer + '\n');
    }
}
