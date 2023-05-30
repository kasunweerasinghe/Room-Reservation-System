package view.tm;

import javafx.scene.control.Button;

public class RoomTM {
    private String roomNo;
    private int capacity;
    private String status;
    private int price;
    private Button btn1;
    private Button btn2;


    public RoomTM() {
    }

    public RoomTM(String roomNo, int capacity, String status, int price, Button btn1, Button btn2) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.status = status;
        this.price = price;
        this.btn1 = btn1;
        this.btn2 = btn2;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "RoomTM{" +
                "roomNo='" + roomNo + '\'' +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", btn1=" + btn1 +
                ", btn2=" + btn2 +
                '}';
    }
}
