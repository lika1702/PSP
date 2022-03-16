package gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Product {
    private String name;
    private double weight;
    private double price;
    private GregorianCalendar date;
    private String description;
    public Product() {
        name = "";
        weight = 0.0;
        price = 0.0;
        date = new GregorianCalendar();
        date.setTime(new Date());
        description = "";
    }
    public Product(String name, double weight, double price, int year, int month, int date, String description) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.date = new GregorianCalendar();
        this.date.set(year, month, date);
        this.description = description;
    }
    public Product(String name, double weight, double price, Date date, String description) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.date = new GregorianCalendar();
        this.date.setTime(date);
        this.description = description;
    }

    public String print() {
        return name + " " + weight + " " + price + " " + format(date) + ":" + description + "";
    }

    public static String format(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.YYYY");
        fmt.setCalendar(calendar);
        String dateFormatted = fmt.format(calendar.getTime());
        return dateFormatted;
    }

    @Override
    public String toString() {
        return name + " " + weight + "г " + price + "BYN " + format(date);
    }
}
