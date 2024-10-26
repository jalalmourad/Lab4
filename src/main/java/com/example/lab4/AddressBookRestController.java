package com.example.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info/addressbook")
public class AddressBookRestController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @PostMapping("/create")
    public AddressBook createAddressBook() {
        return addressBookRepository.save(new AddressBook());
    }
    @PostMapping("/{id}/addBuddy")
    public AddressBook addBuddyToAddressBook(@PathVariable Long id, @RequestBody BuddyInfo buddy) {

        if (addressBookRepository.findById(id).isPresent()) {
            AddressBook addressBook = addressBookRepository.findById(id).get();
            addressBook.addBuddy(buddy);
            return addressBookRepository.save(addressBook);
        }
        return null;
    }

    @PostMapping("/{id}/{buddyId}")
    public AddressBook removeBuddyFromAddressBook(@PathVariable Long id, @PathVariable Long buddyId) {

        if (addressBookRepository.findById(id).isPresent()) {
            AddressBook addressBook = addressBookRepository.findById(id).get();
            addressBook.removeBuddyById(buddyId);
            return addressBookRepository.save(addressBook);
        }
        return null;
    }
    @GetMapping("/all")
    public Iterable<AddressBook> getAllAddressBooks() {
        return addressBookRepository.findAll();
    }
}
