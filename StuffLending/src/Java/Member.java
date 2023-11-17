package Java;

import Java.item;

import java.util.ArrayList;
public class Member {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private int credits;
    public String date;
    public ArrayList<item> ownedItems = new ArrayList<>();

    public Member(int id,String name,String surname,String email,String number,int credit,String date) {
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phoneNumber=number;
        this.credits=credit;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
}