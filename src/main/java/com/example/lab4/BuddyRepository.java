package com.example.lab4;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BuddyRepository extends CrudRepository<BuddyInfo,Long> {

    List<BuddyInfo> findByName(String name);

    BuddyInfo findById(long id);


}
