package org.example.novel.shop;

public class Address {
    String country;
    String city;
    String street;
    int houseNumber;
    int apartmentNumber;
    String postCode;

    public Address(String country, String city, String street, int houseNumber, int apartmentNumber, String postCode) {
        if (postCode.length() < 5 || postCode.length() > 7)
            throw new IllegalArgumentException("Invalid postcode, should be from 5 to 7 numbers long");

        try {
            Integer.parseInt(postCode);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Postcode should contain only digits");
        }

        this.postCode = postCode;

        if (apartmentNumber < 1)
            throw new IllegalArgumentException("Apartment number cannot be less than 1");

        this.apartmentNumber = apartmentNumber;

        if (houseNumber < 1)
            throw new IllegalArgumentException("House number cannot be less than 1");

        this.houseNumber = houseNumber;

        this.country = country;
        this.city = city;
        this.street = street;
    }
}
