package org.example.novel.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    List<Item> items;

    public ShoppingCart(List<Item> items) { this.items = items; }

    public ShoppingCart() { this.items = new ArrayList<Item>(); }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items = items.stream().filter(i -> i.id() != item.id()).collect(Collectors.toList());
    }

    public double totalPrice() {
        return items.stream().mapToDouble(item -> item.price()).reduce(0, (a, b) -> a + b);
    }
}
