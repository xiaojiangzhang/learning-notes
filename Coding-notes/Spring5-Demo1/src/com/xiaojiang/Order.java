package com.xiaojiang;

public class Order {
    private String oname;
    private String oaddress;

    public Order(String oname, String oaddress) {
        this.oname = oname;
        this.oaddress = oaddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oname='" + oname + '\'' +
                ", oaddress='" + oaddress + '\'' +
                '}';
    }
}
