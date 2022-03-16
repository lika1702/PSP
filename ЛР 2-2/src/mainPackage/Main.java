package mainPackage;
import classPackage.Assortment;
import classPackage.Parfum;
import classPackage.ReAccounting;

public class Main {
    public static void main(String[] args) {
        ReAccounting intf = new Assortment();

        Parfum parfum = new Parfum();

        intf.getColl(new Parfum("Духи", "CAROLINA HERRERA", "ж", 125, "ваниль", 26, "Good Girl Dot Drama"));
        intf.print();
        intf.getColl(new Parfum("Духи", "Gucci Bloom", "ж", 145, "сандал", 28, " Acqua di Fiori"));
        intf.print();
        intf.getColl(parfum.get());
        intf.print();
        intf.totalCount();
        intf.totalCost();
    }
}
