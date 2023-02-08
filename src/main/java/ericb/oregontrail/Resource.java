package ericb.oregontrail;

public class Resource {
    private String name;
    private int amount;

    public Resource(String name, int amountChange) {
        this.name = name;
        this.amount = amountChange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount += amount;
    }
}
