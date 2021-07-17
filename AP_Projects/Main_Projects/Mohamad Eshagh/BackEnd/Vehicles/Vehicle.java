package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import java.io.Serializable;

abstract public class Vehicle implements Comparable<Vehicle>, Serializable {

    protected double price;
    protected int capacity;
    protected String company;
    protected static int numberOFCreatedVehicle = 1;
    protected int ID = 1;

    public int getOrderNumber() {
        return orderNumber;
    }

    protected int orderNumber;

    Vehicle(int ID, int orderNumber){
        this.orderNumber = orderNumber;
        this.ID = ID;
    }

    abstract public int discountPercent();

    public String getClassName(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.reverse();
        sb.delete(sb.indexOf("."),sb.length());
        sb.reverse();
        return sb.toString();
    }

    @Override
    public String toString(){
        return "Company : " + this.company +
                "\nID : #" + this.ID +
                "\nCapacity : " + this.capacity;
    }

    @Override
    public int compareTo(Vehicle that) {
        return this.ID > that.ID ? 1 : -1;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getID() {
        return ID;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}