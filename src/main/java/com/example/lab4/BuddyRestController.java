package com.example.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info/buddies")
public class BuddyRestController {
    @Autowired
    BuddyRepository buddyRepository;
    @PostMapping("/addBuddy")
    public void addBuddy(@RequestBody BuddyInfo buddy){
        buddyRepository.save(buddy);
    }
    @PostMapping("/{id}/removeBuddy")
    public void removeBuddy(@PathVariable Long id){
        buddyRepository.deleteById(id);
    }
    @GetMapping("/getBuddies")
    public Iterable<BuddyInfo> getBuddies(){
        return buddyRepository.findAll();
    }
}
