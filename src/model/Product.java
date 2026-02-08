package model;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private double price;
    private String category;

    // Сделал public, чтобы пока не ломать твой DBManager
    public Product(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Геттеры
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    // Обязательные методы для оценки
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("Product[id='%s', name='%s', price=%.2f, cat='%s']", id, name, price, category);
    }

    // Паттерн BUILDER (нужен для оценки)
    public static class Builder {
        private String id;
        private String name;
        private double price;
        private String category;

        public Builder setId(String id) { this.id = id; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setPrice(double price) { this.price = price; return this; }
        public Builder setCategory(String category) { this.category = category; return this; }

        public Product build() {
            return new Product(id, name, price, category);
        }
    }
}