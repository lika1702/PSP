package classPackage;

import java.util.ArrayList;
import java.util.List;

public class Assortment implements ReAccounting {
    private List<PObject> parfumCollection;
    private static int count = 0;

    public Assortment() {
        parfumCollection = new ArrayList<>();
        count++;
    }

    public void getColl(PObject obj) {
        parfumCollection.add(obj);
    }
    public void totalCount() {
        System.out.println("ОБЩЕЕ ЧИСЛО КОЛЛЕКЦИЙ ПАРФЮМЕРИИ, ИМЕЮЩЕЙСЯ В МАГАЗИНЕ: " + count);
    }
    public void totalCost() {
        float cost = 0;
        for(int i = 0; i < parfumCollection.size(); i++)
            cost += parfumCollection.get(i).cost;
        System.out.println("ОБЩАЯ СТОИМОСТЬ СОСТАВЛЯЕТ: " + cost);
    }
    public void print() {
        for(int i = 0; i < parfumCollection.size(); i++)
            System.out.println(parfumCollection.get(i).toString());
    }
}
