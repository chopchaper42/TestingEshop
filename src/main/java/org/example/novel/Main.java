package org.example.novel;

import org.example.novel.archive.OrdersArchive;
import org.example.novel.shop.Category;
import org.example.novel.shop.EShopController;
import org.example.novel.shop.LoyaltyPoints;
import org.example.novel.shop.StandardItem;
import org.example.novel.storage.Storage;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        OrdersArchive archive = new OrdersArchive();
        EShopController controller = new EShopController(storage, archive);

        storage.insertItems(
                new StandardItem(1, "Dancing Panda v.2", 5000, Category.TOY, new LoyaltyPoints(5)), 4
        );
        storage.insertItems(
                new StandardItem(2, "Star Wars Jedi buzzer", 7500, Category.TOY, new LoyaltyPoints(10)), 5
        );
        storage.insertItems(
                new StandardItem(3, "Milk", 45, Category.GROCERIES, new LoyaltyPoints(5)), 10
        );

        storage.printStoredItems();
    }


}
