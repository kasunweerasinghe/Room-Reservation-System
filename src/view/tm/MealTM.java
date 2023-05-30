package view.tm;

import javafx.scene.control.Button;

public class MealTM {
    private String dishCode;
    private String name;
    private int qty;
    private int price;
    private Button btn1;
    private Button btn2;

    public MealTM() {
    }

    public MealTM(String dishCode, String name, int qty, int price, Button btn1, Button btn2) {
        this.dishCode = dishCode;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.btn1 = btn1;
        this.btn2 = btn2;
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

    public Button getBtn1() {
        return btn1;
    }

    public void setBtn1(Button btn1) {
        this.btn1 = btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

    public void setBtn2(Button btn2) {
        this.btn2 = btn2;
    }

    @Override
    public String toString() {
        return "MealTM{" +
                "dishCode='" + dishCode + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", btn1=" + btn1 +
                ", btn2=" + btn2 +
                '}';
    }
}
