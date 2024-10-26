package com.example.lab4;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressBookRepository extends CrudRepository<AddressBook,Long> {

    AddressBook findById(long id);


}
