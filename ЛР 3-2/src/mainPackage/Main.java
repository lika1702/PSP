package mainPackage;

import furniturePackage.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bTable = 0, bWardrobe = 0, bStool = 0, bBarStool = 0;
        Table table = new Table("ООО ЗаСтрой", 65.15F, 4, 1, 1);
        Wardrobe wardrobe = new Wardrobe("ОAО WOOD", 100.35F, 2, 3, 1);
        Stool stool = new Stool("ООО РАСПИЛ", 20, 0.25F);
        BarStool barStool = new BarStool("ООО ЗаСтрой", 28.8F, "пластик", 1.2F);

        System.out.println("Оформить заявку на партию мебели в количестве...");
        System.out.print("столов: "); bTable = in.nextInt();
        System.out.print("барных стульев: "); bBarStool = in.nextInt();
        System.out.print("табуретов: "); bStool = in.nextInt();
        System.out.print("шкафов: "); bWardrobe = in.nextInt();

        Furniture furniture = table;
        furniture.details(bTable);

        furniture = stool;
        furniture.details(bStool);

        furniture = barStool;
        furniture.details(bBarStool);

        furniture = wardrobe;
        furniture.details(bWardrobe);
    }
}
