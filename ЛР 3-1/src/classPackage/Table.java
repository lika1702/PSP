package classPackage;

public class Table extends Furniture{
    private int quantityOfDrawer;
    private float areaOfSurface;

    //Constructors
    public Table() {
        super();
        quantityOfDrawer = 0;
        areaOfSurface = 0;
    }
    public Table(String material, String manufacturer, float cost, int quantityOfDrawer, float areaOfSurface) {
        super(material, manufacturer, cost);
        this.quantityOfDrawer = quantityOfDrawer;
        this.areaOfSurface = areaOfSurface;
    }
    public Table(String material, String manufacturer, int quantityOfDrawer, float areaOfSurface) {
        super(material, manufacturer);
        this.quantityOfDrawer = quantityOfDrawer;
        this.areaOfSurface = areaOfSurface;
    }

    //Getters
    public int getQuantityOfDrawer() { return  quantityOfDrawer; }
    public float getAreaOfSurface() { return  areaOfSurface; }

    @Override
    public void print() {
        System.out.println("ТИП: Стол" + '\n' + "ПЛОЩАДЬ СТОЛЕШНИЦЫ: " + areaOfSurface + "м кв." + '\n' +
                "КОЛИЧЕСТВО ВЫДВИЖНЫХ ЯЩИКОВ: " + quantityOfDrawer + "шт.");
        super.print();
    }

    @Override
    public void details(int batch) {
        System.out.println("ПРОИЗВОДИТЕЛЬ \"" + getManufacturer() + '\"');
        System.out.println("Для создания требуемой партии столов модели N (" + batch + " шт.) требуется "
                + batch * (areaOfSurface + quantityOfDrawer * 1.5) + " м кв. ЛДСП, в том числе\n" +
                "\tрабочая поверхность - " + areaOfSurface + " м кв. ЛДСП\n" +
                "\tвыдвижные ящики (" + quantityOfDrawer + " шт.) - 1.5 м кв. ЛДСП в расчете на один\n");
    }
}
