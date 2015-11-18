package shoshin.alex.tuturs.utils;

import shoshin.alex.tuturs.data.Currency;
import shoshin.alex.tuturs.data.Price;

public class TicketCalculator {
    public static Price getDefaultPrice() {
        return new Price(100, Currency.RUB);
    }
}