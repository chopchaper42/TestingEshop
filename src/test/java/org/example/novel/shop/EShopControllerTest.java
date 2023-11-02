package org.example.novel.shop;

import org.example.novel.archive.OrdersArchive;
import org.example.novel.storage.ItemStock;
import org.example.novel.storage.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EShopControllerTest {

    Storage mockStorage;
    OrdersArchive mockArchive;
    ShoppingCart mockCart;
    CustomerCredentials mockCredentials;

    EShopController controller;

    @BeforeEach
    public void init() {
        mockStorage = mock(Storage.class);
        mockArchive = mock(OrdersArchive.class);
        mockCart = mock(ShoppingCart.class);
        mockCredentials = mock(CustomerCredentials.class);
    }

    @Test
    public void testOrderCreation_cartIsEmpty_ExceptionThrown() {
        when(mockCart.isEmpty()).thenReturn(true);

        controller = new EShopController(mockStorage, mockArchive);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> controller.createOrder(mockCart, mockCredentials));

    }
//    new StandardItem(1, "Dancing Panda v.2", 5000, Category.TOY, new LoyaltyPoints(5)), 4
    @Test
    public void testOrderCreation_NoItemsInStorage_ExceptionThrown() {
        Storage realStorage = new Storage();
        List<ItemStock> items = new ArrayList<>();
        items.add(new ItemStock(new StandardItem(1, "Dancing Panda v.2", 5000, Category.TOY, new LoyaltyPoints(5)), 4));

        when(mockCart.isEmpty()).thenReturn(false);
        when(mockCart.items()).thenReturn(items);

        controller = new EShopController(realStorage, mockArchive);

        Assertions.assertThrows(RuntimeException.class,
                () -> controller.createOrder(mockCart, mockCredentials));

    }

    @Test
    public void testOrderCreation_OrderIsArchived() {
        List<ItemStock> items = new ArrayList<>();
        OrdersArchive archive = new OrdersArchive();
        items.add(new ItemStock(new StandardItem(1, "Dancing Panda v.2", 5000, Category.TOY, new LoyaltyPoints(5)), 4));
        Order order = new Order(mockCredentials, null);

        when(mockCart.isEmpty()).thenReturn(false);
        when(mockCart.items()).thenReturn(items);
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                controller.getArchive().archiveOrder(order);
                return null;
            }
        }).when(mockStorage).processOrder(order);

        controller = new EShopController(mockStorage, archive);

        Assertions.assertTrue(archive.getArchive().contains(order));

    }
}