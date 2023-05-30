package view.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String name;
    private String telNo;
    private String email;
    private String nicNo;
    private String address;
    private Button btn;

    public CustomerTM() {
    }

    public CustomerTM(String name, String telNo, String email, String nicNo, String address, Button btn) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.nicNo = nicNo;
        this.address = address;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }


    @Override
    public String toString() {
        return "CustomerTM{" +
                "name='" + name + '\'' +
                ", telNo='" + telNo + '\'' +
                ", email='" + email + '\'' +
                ", nicNo='" + nicNo + '\'' +
                ", address='" + address + '\'' +
                ", btn=" + btn +
                '}';
    }
}
