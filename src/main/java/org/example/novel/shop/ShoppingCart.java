package org.example.novel.shop;

import org.example.novel.storage.ItemStock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    List<ItemStock> items;

    public ShoppingCart(List<ItemStock> items) { this.items = items; }

    public ShoppingCart() { this.items = new ArrayList<ItemStock>(); }

    public void addItem(Item item, int count) {
        items.add(new ItemStock(item, count));
    }
    public void removeItem(Item item, int count) {
        items = items.stream().peek(i -> {
            if (i.id() == item.id())
                i.decreaseCount(count);
        }).collect(Collectors.toList());
    }

    public double totalPrice() {
        return items.stream().mapToDouble(item -> item.priceOfOneItem()).reduce(0, (a, b) -> a + b);
    }
    public boolean isEmpty() { return items.isEmpty(); }

    public int itemsCount() {
        return items.stream().mapToInt(i -> i.count()).reduce(0, (a, b) -> a + b);
    }
}
