package com.example.mohammad_es_faz4_gui.BackEnd;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
    private final String name, family, placeOfBirth, yearOfBirth, gender, occupation;
    private boolean isEmployee = false;
    private static int IDBuilder = 1;
    private final int ID;
    private final double salary;
    public Person(String name, String family,  String gender, String placeOfBirth, String occupation, String yearOfBirth, double salary) {
        this(name, family, gender, placeOfBirth, occupation, yearOfBirth, salary, IDBuilder);
    }
    public Person(String name, String family,  String gender, String placeOfBirth, String occupation, String yearOfBirth, double salary, int ID) {
        this.name = name;
        this.family = family;
        this.gender = gender;
        this.placeOfBirth = placeOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.occupation = occupation;
        this.salary = salary;
        this.ID = ID;
        IDBuilder++;
    }


        @Override
    public String toString(){
        return this.name + " " + this.family +
                "\nGender : " + this.gender +
                "\nPlace of birth : " + this.placeOfBirth +
                "\nYear of birth : " + this.yearOfBirth +
                "\nSalary : " + this.salary;
    }

    @Override
    public int compareTo(Person that) {
        return this.ID > that.ID ? 1 : -1;
    }

    public String getFullName(){
        return name+" "+family;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public double getSalary() {
        return salary;
    }

    public int getID() {
        return ID;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }
}