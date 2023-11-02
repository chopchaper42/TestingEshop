package org.example.novel.shop;

import org.example.novel.storage.ItemStock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    List<ItemStock> items;

    public ShoppingCart(List<ItemStock> items) { this.items = items; }

    public ShoppingCart() { this.items = new ArrayList<ItemStock>(); }

    public void addItem(Item item) {
        items.add(new ItemStock(item, 1));
    }
    public void addItem(Item item, int count) {
        items.add(new ItemStock(item, count));
    }

    public void removeItem(Item item) {
        items = items.stream().filter(i -> i.id() != item.id()).collect(Collectors.toList());
    }

    public double totalPrice() {
        return items.stream().mapToDouble(item -> item.priceOfOneItem()).reduce(0, (a, b) -> a + b);
    }
    public boolean isEmpty() { return items.isEmpty(); }
}
