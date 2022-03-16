package classPackage;

import java.util.ArrayList;
import java.util.List;

import classPackage.Intface;

public class Order implements Intface {
    private List<Toy> order;

    public Order() {
        order = new ArrayList<Toy>();
    }

    @Override
    public void add(Toy obj) { order.add(obj); }

    @Override
    public float orderPrice() {
        float totalCost = 0.0F;
        for (int i = 0; i < order.size(); i++) {
            totalCost += order.get(i).getCost();
        }
        return totalCost;
    }

    @Override
    public void printCheck() {
        for (int i = 0; i < order.size(); i++) {
            System.out.print((i + 1) + ". ");
            order.get(i).printInf();
        }
    }
}
