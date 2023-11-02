package org.example.novel.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    public void addOneItemWorks() {
        StandardItem item = new StandardItem(1, "Dancing Panda v.2", 5000, Category.TOY, new LoyaltyPoints(5));
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(item, 1);

        Assertions.assertEquals(1, cart.itemsCount());
        Assertions.assertFalse(cart.isEmpty());
    }
    @Test
    public void addMultipleItemsWorks() {
        StandardItem item = new StandardItem(1, "Dancing Panda v.2", 5000, Category.TOY, new LoyaltyPoints(5));
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(item, 12);

        Assertions.assertEquals(12, cart.itemsCount());
        Assertions.assertFalse(cart.isEmpty());
    }
    @Test
    public void removeItemsWorks() {
        StandardItem item = new StandardItem(1, "Dancing Panda v.2", 5000, Category.TOY, new LoyaltyPoints(5));
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(item, 12);

        Assertions.assertEquals(12, cart.itemsCount());
        Assertions.assertFalse(cart.isEmpty());

        cart.removeItem(item, 2);

        Assertions.assertEquals(10, cart.itemsCount());
        Assertions.assertFalse(cart.isEmpty());
    }
}