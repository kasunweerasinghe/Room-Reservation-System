package model;

public class Room {
    private String roomNo;
    private int capacity;
    private String status;
    private int price;

    public Room() {
    }

    public Room(String roomNo, int capacity, String status, int price) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.status = status;
        this.price = price;
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

    @Override
    public String toString() {
        return "Room{" +
                "roomNo='" + roomNo + '\'' +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
