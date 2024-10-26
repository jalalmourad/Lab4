package com.example.lab4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(BuddyRepository repository) {
		return (args) -> {

			// save a few buddies
			repository.save(new BuddyInfo("Jack", 111));
			repository.save(new BuddyInfo("Chloe", 222));
			repository.save(new BuddyInfo("Kim", 333));
			repository.save(new BuddyInfo("David", 444));
			repository.save(new BuddyInfo("Michelle", 555));




			// fetch all customers
			log.info("Buddies found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			BuddyInfo buddy = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(buddy.toString());
			log.info("");

			// fetch customers by  name
			log.info("Customer found with findByName('Jack'):");
			log.info("--------------------------------------------");
			repository.findByName("Jack").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}



	@Bean
	public CommandLineRunner demo1(AddressBookRepository repository) {
		return (args) -> {
			BuddyInfo buddyInfo = new BuddyInfo("Buddy1",0000);
			AddressBook addressBook = new AddressBook();


			BuddyInfo buddyInfo2 = new BuddyInfo("Buddy2",1111);
			AddressBook addressBook2 = new AddressBook();

			addressBook.addBuddy(buddyInfo);

			addressBook2.addBuddy(buddyInfo2);



			// save an addressbook
			repository.save(addressBook);
			repository.save(addressBook2);

			log.info("Address Books:         ");


			// fetch all customers
			log.info("AddressBooks found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			AddressBook ab = repository.findById(1L);
			System.out.println(ab);
			log.info("AddressBook found with findById(1L):");
			log.info("--------------------------------");
			log.info(ab.toString());
			//log.info(ab.printBuddies());
			log.info("");


		};
	}

}