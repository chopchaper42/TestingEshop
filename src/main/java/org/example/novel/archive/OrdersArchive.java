package org.example.novel.archive;

import org.example.novel.shop.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersArchive {

    private List<Order> ordersArchive;

    public OrdersArchive(List<Order> archive) {
        this.ordersArchive = archive;
    }

    public OrdersArchive() {
        ordersArchive = new ArrayList<>();
    }

    public void archiveOrder(Order order) {
        ordersArchive.add(order);
    }

    public List<Order> getArchive() { return ordersArchive; }
}
