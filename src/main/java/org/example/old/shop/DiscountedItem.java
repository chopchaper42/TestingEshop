package org.example.old.shop;

import org.example.novel.shop.Discount;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * The class for discounted item in the EShopController, as the handling of discounted items differs form the standard items.
 */


public class DiscountedItem extends Item {
    private Discount discount;
    private Date discountFrom;
    private Date discountTo;
    
    public DiscountedItem(int id, String name, float price, String category, Discount discount, Date discountFrom, Date discountTo) {
        super(id, name, price, category);
        this.discount = discount;
        this.discountFrom = discountFrom;
        this.discountTo = discountTo;
    }

    private Date parseDate(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return simpleDate.parse(date);
        } catch (Exception e) {
            System.out.println("Error in DiscountedItem.parseDate() - wrong date format" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public String toString() {
        return super.toString()+"   ORIGINAL PRICE "+getOriginalPrice()+"    DISCOUNTED PRICE "+getDiscountedPrice()+"  DISCOUNT FROM "+discountFrom.toString()+"    DISCOUNT TO "+discountTo.toString();
    }
}
