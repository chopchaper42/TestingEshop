package org.example.novel.shop;

public class Address {
    String country;
    String city;
    String street;
    String houseNumber;
    int apartmentNumber;
    String postCode;

    public Address(String country, String city, String street, String houseNumber, int apartmentNumber, String postCode) {
        if (postCode.length() < 5 || postCode.length() > 7)
            throw new IllegalArgumentException("Invalid postcode, should be from 5 to 7 numbers long");

        try {
            Integer.parseInt(postCode);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Postcode should contain only digits");
        }

        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.postCode = postCode;
    }
}
