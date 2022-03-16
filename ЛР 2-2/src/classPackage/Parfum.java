package classPackage;

import java.util.Objects;
import java.util.Scanner;

public class Parfum extends Parfumery{
    private float concentration;
    private String title;

    public Parfum() {
        super();
        concentration = 0;
        title = new String();
    }
    public Parfum(String name, String marque, String gender, float cost, String flavour, float concentration, String title) {
        super(name, marque, gender, cost, flavour);
        this.concentration = concentration;
        this.title = title;
    }

    @Override
    public PObject get() {
        Scanner in = new Scanner(System.in);
        System.out.println("ЗАПОЛНИТЕ СЛЕДУЮЩИЕ ДАННЫЕ:");
        System.out.print("ИМЯ: "); String name = in.nextLine();
        System.out.print("НАЗВАНИЕ: "); String title = in.nextLine();
        System.out.print("БРЕНД: "); String marque  = in.nextLine();
        System.out.print("ПОЛ: "); String gender  = in.nextLine();
        System.out.print("ТИП АРОМАТА: ");  String flavour  = in.nextLine();
        System.out.print("КОНЦЕНТРАЦИЯ ВЕЩЕСТВА: "); float concentration  = in.nextFloat();
        System.out.print("СТОИМОСТЬ: "); float cost  = in.nextFloat();

        this.name = name;
        this.marque = marque;
        this.gender = gender;
        this.cost = cost;
        this.flavour = flavour;
        this.concentration = concentration;
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        if (gender == "м") return name + " \"" + title + "\" от " + marque + " for men. Цена: " + cost + "$";
        if (gender == "ж") return name + " \"" + title + "\" от " + marque + " for women. Цена: " + cost + "$";
        if (gender == "у") return name + " \"" + title + "\" от " + marque + " for men and for women. Цена: " + cost + "$";
        else return name + " \"" + title + "\" от " + marque + " Цена: " + cost + "$";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Parfum p = (Parfum) obj;
        return cost == p.cost && concentration == p.concentration && name == p.name && marque == p.marque &&
                gender == p.gender && title == p.title && flavour == p.flavour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
