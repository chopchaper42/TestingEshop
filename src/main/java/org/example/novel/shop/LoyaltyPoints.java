package org.example.novel.shop;

public class LoyaltyPoints {
    int points;

    public LoyaltyPoints(int points) {
        if (points < 0 || points > 100)
            throw new IllegalArgumentException("Loyalty points should be in between 0 and 100.");

        this.points = points;
    }


}
