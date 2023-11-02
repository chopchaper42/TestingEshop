package org.example.novel.storage;

import org.example.novel.shop.Item;

public class ItemStock {

    private Item item;
    private int count;

    public ItemStock(Item item, int count) {
        if (count < 0)
            throw new IllegalArgumentException("Count cannot be less than zero");

        this.count = count;
        this.item = item;
    }

    public int id() { return item.id(); }

    public void increaseCount(int count) throws IllegalArgumentException {
        if (count < 1)
            throw new IllegalArgumentException("Cannot increase count on less than 1 item");

        this.count += count;
    }

//    public boolean canDecrease(int x) { return count - x >= 0; }

    public void decreaseCount(int count) {
        if (count < 1)
            throw new IllegalArgumentException("Cannot decrease count on less than 1 item");

        if (this.count - count < 0)
            throw new IllegalArgumentException("There are less than " + count + " items left, cannot decrease");

        this.count -= count;
    }

    public double priceOfOneItem() { return item.price(); }
    public Item item() { return item; }
    public int count() { return count; }

    @Override
    public String toString() {
        return "Item: " + item.name() + ", Count: " + count;
    }
}
