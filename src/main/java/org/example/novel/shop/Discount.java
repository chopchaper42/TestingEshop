package org.example.novel.shop;

import java.util.Date;
import java.util.InvalidPropertiesFormatException;

public class Discount {
    private int percent;
    private Date dateFrom;
    private Date dateTo;

    public Discount(int percent, Date dateFrom, Date dateTo) {

        if (percent <= 0 || percent > 99)
            throw new IllegalArgumentException("Percent should be in between 0 and 99, but was " + percent);

        if (dateFrom.after(dateTo))
            throw new IllegalArgumentException("Date from discount is valid cannot be after the date it is valid to");

        this.percent = percent;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
