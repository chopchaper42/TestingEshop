package org.example.novel.shop;

public abstract class Item {

    private int id;
    private String name;
    private Category category;
    private double price;

    public Item(int id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int id() { return id; }
    public double price() { return price; }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
