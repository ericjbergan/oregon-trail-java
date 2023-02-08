package ericb.oregontrail;

public class Resource {
    private final String name;
    private int amount;

    public Resource(String name, int amountChange) {
        this.name = name;
        this.amount = amountChange;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (name.equals("ammunition")) {
            amount = amount * 50;
        }

        this.amount += amount;
    }
}