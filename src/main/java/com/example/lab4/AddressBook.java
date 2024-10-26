package com.example.lab4;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;


@Entity
public class AddressBook {


    @Id
    @GeneratedValue
    private Long id;


    @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Collection<BuddyInfo> buddiesList;

    public AddressBook() {
        buddiesList = new ArrayList<>();
    }


    //Removes a buddy from the list of buddies
    public void removeBuddy(BuddyInfo buddy) {
        buddiesList.remove(buddy);
    }

    public void removeBuddyById(Long id){

        buddiesList.removeIf(buddy -> buddy.getId().equals(id));

    }


    //Adds a buddy to the list of buddies
    public void addBuddy(BuddyInfo buddy){
        buddiesList.add(buddy);
    }

    public void printBuddies(){
        for(BuddyInfo buddy : buddiesList){
            System.out.println(buddy);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BuddyInfo> getBuddiesList() {
        return buddiesList;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Jalal",613111111);
        BuddyInfo buddy2 = new BuddyInfo("Lynn",819222222);

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        addressBook.printBuddies();
    }
}
