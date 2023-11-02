package org.example.novel.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    public void createAddressWithBadPostcodeThrowsException() {
        String country = "Canada";
        String city = "Montreal";
        String street = "Royal st.";
        int houseNumber = 3;
        int apartment = 5;
        String postCode = "123d42";

        Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new Address(country, city, street, houseNumber, apartment, postCode));
    }
    @Test
    public void createAddressWithBadApartmentNumberThrowsException() {
        String country = "Canada";
        String city = "Montreal";
        String street = "Royal st.";
        int houseNumber = 3;
        int apartment = -12;
        String postCode = "123942";

        Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new Address(country, city, street, houseNumber, apartment, postCode));
    }
    @Test
    public void createAddressWithBadHouseNumberThrowsException() {
        String country = "Canada";
        String city = "Montreal";
        String street = "Royal st.";
        int houseNumber = -1;
        int apartment = 3;
        String postCode = "123942";

        Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new Address(country, city, street, houseNumber, apartment, postCode));
    }

}