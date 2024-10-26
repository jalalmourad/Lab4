package com.example.lab4;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int phoneNumber;

//    @ManyToOne
//    public AddressBook addressBook;


    public BuddyInfo() {}

    public BuddyInfo(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

//    public AddressBook getAddressBook(){
//        return addressBook;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String toString() {
        return "Name: "+ name + ", Phone number:  " + phoneNumber;
    }

}
