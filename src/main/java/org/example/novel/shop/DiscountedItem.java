package org.example.novel.shop;

public class DiscountedItem extends Item {

    private Discount discount;
    public DiscountedItem(int id, double price, String name, Category category, Discount discount) {
        super(id, name, category, price);
        this.discount = discount;
    }

    /*private DiscountedItem(int id, double price, String name, Category category) {
        super(id, name, category, price);
    }*/

    /*public static DiscountedItem fromDiscount(int id, double price, String name, Category category, Discount discount) {
        DiscountedItem item = new DiscountedItem(id, price, name, category);
        item.discount = discount;
        return item;
    }*/
}
