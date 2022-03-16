package classPackage;

public class Chair extends Furniture {
    boolean isAdjustBackrest;

    //Constructors
    public Chair() {
        super();
        isAdjustBackrest = false;
    }
    public Chair(String material, String manufacturer, float cost, boolean isAdjustBackrest) {
        super(material, manufacturer, cost);
        this.isAdjustBackrest = isAdjustBackrest;
    }
    public Chair(String material, String manufacturer, boolean isAdjustBackrest) {
        super(material, manufacturer);
        this.isAdjustBackrest = isAdjustBackrest;
    }

    //Getters
    public boolean isAdjustBackrest() { return isAdjustBackrest; }

    @Override
    public void print() {
        if (isAdjustBackrest) System.out.println("ТИП: Стул" + '\n' + "РЕГУЛИРОВКА СПИНКИ: " + "да");
        else System.out.println("ТИП: Стул" + '\n' + "РЕГУЛИРОВКА СПИНКИ: " + "нет");
        super.print();
    }
    @Override
    public void details(int batch) {
        if (isAdjustBackrest) {
            System.out.println("ПРОИЗВОДИТЕЛЬ \"" + getManufacturer() + '\"');
            System.out.println("Для создания требуемой партии офисных кресел модели N (" + batch +
                    " шт.) требуется регулировочные винты в количестве " + batch + " шт.\n");
        }
        else System.out.println("Для изготовления данной модели регулировочные винты не требуются");
    }
}
