package model;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String id, String name, double price, String category, double weight) {
        super(id, name, price, category);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
}