package model;

public class Customer {

    private String name;
    private String telNo;
    private String email;
    private String nicNo;
    private String address;


    public Customer(String text, String txtTelNoText, String txtEmailText, String txtNicNoText, String txtAddressText, String txtRoomNoText, int i, int parseInt) {
    }

    public Customer(String name, String telNo, String email, String nicNo, String address) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.nicNo = nicNo;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", telNo='" + telNo + '\'' +
                ", email='" + email + '\'' +
                ", nicNo='" + nicNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
