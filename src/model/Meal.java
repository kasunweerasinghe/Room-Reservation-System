package model;

public class Meal {
    private String dishCode;
    private String name;
    private int qty;
    private int price;

    public Meal() {
    }

    public Meal(String dishCode, String name, int qty, int price) {
        this.dishCode = dishCode;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "dishCode='" + dishCode + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
