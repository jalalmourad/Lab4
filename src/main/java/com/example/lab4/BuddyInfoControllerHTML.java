package com.example.lab4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/html/buddy")
public class BuddyInfoControllerHTML {

    @Autowired
    BuddyRepository buddyRepository;

    @GetMapping("/getBuddies")
    public String getBuddies(Model model){
        model.addAttribute("buddies", buddyRepository.findAll());
        return "AllBuddies";
    }


}
