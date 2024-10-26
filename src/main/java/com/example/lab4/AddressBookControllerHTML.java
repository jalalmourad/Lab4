package com.example.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html/addressbook")
public class AddressBookControllerHTML {

    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/all")
    public String getAllAddressBooks(Model model) {
        model.addAttribute("addressbook",addressBookRepository.findAll());
        return "AddressBooks";
    }

    @GetMapping("/{id}")
    public String getAddressBookById(@PathVariable Long id, Model model){

        model.addAttribute("AddressBookInformation",addressBookRepository.findById(id));

        return "AddressBookInfo";
    }

}
