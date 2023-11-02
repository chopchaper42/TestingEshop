package org.example.novel.shop;

public class CustomerCredentials {
    String name;
    Address address;

    public CustomerCredentials(String name, Address address) {
        if (name.length() < 3)
            throw new IllegalArgumentException("Name cannot be less than 3 characters long");

        this.name = name;
        this.address = address;
    }
}
