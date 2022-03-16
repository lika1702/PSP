package mainPackage;

import classPackage.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Furniture> order = new ArrayList<>();
        Printer printer = new Printer();

        order.add(new Chair("Дерево", "ООО РасПил", true));
        order.add(new Table("Дерево", "ООО ИмПорт", 51.7F, 2, 120));
        order.add(new Wardrobe("ДВП", "OАO Wood", 84.4F, 1.5F, 3, 1));
        order.add(new Wardrobe("ДВП", "OАO Wood", 35.4F, 1.5F, 2.5F, 1));
        order.add(new Table("ЛДСП", "OАO Wood", 65.4F, 3, 1));

        printer.printer(order);
        System.out.println("Заказ партии мебели на 20 экземпляров каждого вида");
        for(int i = 0; i < order.size(); i++) order.get(i).details(20);
    }
}
