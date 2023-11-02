package org.example.novel.storage;

public class ItemCount {
    int count;

    public ItemCount(int count) throws IllegalArgumentException {
        if (count < 0)
            throw new IllegalArgumentException("Item count cannot be less than zero");

        this.count = count;
    }
}
