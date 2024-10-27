package com.example.lab4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressBookControllerTest {

    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private BuddyRepository buddyRepository;


    @Test
    void testCreateAddressBook(){

        AddressBook addressBook = new AddressBook();
        HttpEntity<AddressBook> request = new HttpEntity<>(addressBook);
        ResponseEntity<AddressBook> response = restTemplate.postForEntity("/info/addressbook/create",request, AddressBook.class);

       assertEquals(response.getStatusCode(), HttpStatus.OK);
       assertEquals(addressBookRepository.findAll().iterator().next().getId(),1);
       assertNotNull(response.getBody());

    }

    @Test
    void testAddBuddyToAddressBook(){

        BuddyInfo buddy1 = new BuddyInfo("Jalal",123);
        BuddyInfo savedBuddy = buddyRepository.save(buddy1);

        AddressBook addressBook = new AddressBook();
        AddressBook savedAddressBook = addressBookRepository.save(addressBook);

        HttpEntity<BuddyInfo> request = new HttpEntity<>(buddy1);

       ResponseEntity<AddressBook> response = restTemplate.postForEntity("/info/addressbook/"+ savedAddressBook.getId() +"/addBuddy",request,AddressBook.class);
        assertEquals(response.getStatusCode(),HttpStatus.OK);

        ArrayList<AddressBook>emptyList = (ArrayList<AddressBook>) addressBookRepository.findAll();
       assertEquals(emptyList.size(),1);

    }

    @Test
    void getAddressBooks(){


        ResponseEntity<AddressBook[]> response = restTemplate.getForEntity("/info/addressbook/all",AddressBook[].class);

        assertEquals(response.getStatusCode(),HttpStatus.OK);

        ArrayList<AddressBook> abList =(ArrayList<AddressBook>) addressBookRepository.findAll();
        assertEquals(abList.size(),2);

    }






}
