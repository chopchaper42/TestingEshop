package org.example.novel.shop;

public class StandardItem extends Item {
    LoyaltyPoints loyaltyPoints;
    public StandardItem(int id, String name, double price, Category category, LoyaltyPoints points) {
        super(id, name, category, price);
        this.loyaltyPoints = points;
    }
}
