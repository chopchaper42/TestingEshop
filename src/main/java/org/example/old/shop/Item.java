package org.example.old.shop;



/**
 * The basic class for item in the EShop.
 */


public abstract class Item {
    private int id;
    private String name;
    private float price;
    private String category;

    public double price() {
        return price;
    }

    public Item(int id, String name, float price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "Item   ID "+id+"   NAME "+name+"   CATEGORY "+category;
    }
}

