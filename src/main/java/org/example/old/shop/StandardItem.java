package org.example.old.shop;



/**
 * The class for standard item in the EShop.
 */


public class StandardItem extends Item {

    private int loyaltyPoints;

    public StandardItem(int id, String name, float price, String category, int loyaltyPoints) {
        super(id, name, price, category);
        this.loyaltyPoints = loyaltyPoints;
    }
    
    public String toString() {
        return super.toString()+"   PRICE "+getPrice()+"   LOYALTY POINTS "+loyaltyPoints;
    }
}
