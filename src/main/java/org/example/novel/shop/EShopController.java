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
        if (cart.isEmpty()) {
            System.out.println("Error: the shopping cart is empty!");
            return;
        }

        Order order = new Order(credentials, cart.items);
        try {
            storage.processOrder(order);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        archive.archiveOrder(order);
    }
}
