package org.example.novel.shop;

public class StandardItem extends Item {
    LoyaltyPoints loyaltyPoints;
    public StandardItem(int id, String name, Category category, double price, LoyaltyPoints points) {
        super(id, name, category, price);
        this.loyaltyPoints = points;
    }
}
