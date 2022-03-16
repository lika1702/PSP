package mainPackage;
import classPackage.ConstructionKit;
import classPackage.Intface;
import classPackage.Order;
import classPackage.SoftToy;

public class Main {
    public static void main(String[] args) {
        Intface orderToys = new Order();

        orderToys.add(new ConstructionKit("LEGO", "конструктор", 14.35F, 520));
        orderToys.add(new SoftToy("Neko", "мягкая игрушка", 1.8F, "синтепон"));
        orderToys.add(new SoftToy("Плюшевый  медведь", "мягкая игрушка", 11.25F, "поролон"));
        orderToys.add(new ConstructionKit("LEGO", "конструктор", 4.8F, 260));
        orderToys.add(new SoftToy("Кролик", "мягкая игрушка", 3.0F, "синтепон"));
        orderToys.printCheck();
        System.out.println("ИТОГО ********** " + orderToys.orderPrice());
    }
}
