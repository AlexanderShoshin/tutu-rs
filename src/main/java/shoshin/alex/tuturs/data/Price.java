package shoshin.alex.tuturs.data;

public class Price {
    private int count;
    private Currency currency;
    
    public Price(int count, Currency currency) {
        this.count = count;
        this.currency = currency;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}