package org.example.novel.shop;

import org.example.novel.archive.OrdersArchive;
import org.example.novel.storage.Storage;

public class EShopController {
    private Storage storage;
    private OrdersArchive archive;

    public EShopController(Storage storage, OrdersArchive archive) {
        this.storage = storage;
        this.archive = archive;
    }

    public void createOrder(ShoppingCart cart, CustomerCredentials credentials) {
        if (cart.isEmpty())
            throw new IllegalArgumentException("The cart is empty");

        Order order = new Order(credentials, cart.items());
        try {
            storage.processOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        archive.archiveOrder(order);
    }

    public OrdersArchive getArchive() { return this.archive; }
}
