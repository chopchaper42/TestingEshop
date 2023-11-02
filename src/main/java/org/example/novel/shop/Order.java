package org.example.novel.shop;

import org.example.novel.storage.ItemStock;

import java.util.List;

public class Order {
    private OrderState state;
    private CustomerCredentials credentials;

    private List<ItemStock> items;

    public List<ItemStock> items() { return items; }

    public Order(CustomerCredentials credentials, List<ItemStock> items) {
        this.credentials = credentials;
        this.items = items;
        this.state = OrderState.IN_PROCESS;
    }

}
