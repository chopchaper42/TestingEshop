package org.example.novel.storage;

import org.example.novel.shop.Category;
import org.example.novel.shop.Item;
import org.example.novel.shop.Order;
import org.example.novel.storage.ItemStock;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Storage {
    private HashMap<Integer, ItemStock> stock;
    public Storage(HashMap<Integer, ItemStock> stock) {
        this.stock = stock;
    }

    public Storage() { stock = new HashMap<Integer, ItemStock>(); }

    public void printStoredItems() {
        stock.values().forEach(System.out::println);
    }

    public void insertItems(Item item, int count) throws IllegalArgumentException {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");

        if (!stock.containsKey(item.id())) {
            stock.put(item.id(), new ItemStock(item, count));

        } else {
            stock.get(item.id()).increaseCount(count);

        }
    }

    public void removeItems(Item item, int count) throws IllegalArgumentException, RuntimeException {
        if (stock.containsKey(item.id()))
            removeFromStorage(item, count);
        else
            throw new RuntimeException("No such item in stock");
    }

    private void removeFromStorage(Item item, int count) throws IllegalArgumentException {
        ItemStock itemStock = stock.get(item.id());
        itemStock.decreaseCount(count);
    }

    public double wholeStockPrice() {
        return stock.values().stream()
                .mapToDouble(ItemStock::priceOfOneItem)
                .reduce(0, (a, b) -> a + b);
    }

    public void processOrder(Order order) throws IllegalArgumentException, RuntimeException {
        List<ItemStock> itemsStock = order.items();
        itemsStock.forEach(stock -> removeItems(stock.item(), stock.count()));
    }

    public int itemCount(Item item) {
        if (stock.containsKey(item.id()))
            return stock.get(item.id()).count();
        return 0;
    }

    public int itemCount(int itemId) {
        if (stock.containsKey(itemId))
            return stock.get(itemId).count();
        return 0;
    }

    public List<ItemStock> getItemStocksOfCategorySortedByPrice(Category category) {
        return stock.values().stream()
                .filter(itemStock -> itemStock.item().isOfCategory(category))
                .sorted(Comparator.comparing(ItemStock::priceOfOneItem))
                .collect(Collectors.toList());
    }

    public List<ItemStock> getItemsByCategory(Category category) {
        return stock.values().stream()
                .filter(itemStock -> itemStock.item().isOfCategory(category))
                .collect(Collectors.toList());
    }

    public void sortItemsByPrice(List<Item> items) {
        items = items.stream().sorted(Comparator.comparing(Item::price)).collect(Collectors.toList());
    }


}
