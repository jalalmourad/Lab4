package com.example.lab4;
import org.junit.jupiter.api.Assertions;
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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BuddyRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BuddyRepository buddyRepository;

    @Test
    void testAddBuddy() {

        BuddyInfo buddy = new BuddyInfo("Jalal", 123);
        HttpEntity<BuddyInfo> request = new HttpEntity<>(buddy);

        ResponseEntity<Void> response = restTemplate.postForEntity("/info/buddies/addBuddy", request, Void.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(buddyRepository.findByName("Jalal"));

        //List<BuddyInfo> BuddyRepoSize = (List<BuddyInfo>) buddyRepository.findAll();
        //Assertions.assertEquals(BuddyRepoSize.size(),1);
    }
    @Test
    void testGetBuddies() {
        BuddyInfo buddy1 = new BuddyInfo("Jalal", 123);
        BuddyInfo buddy2 = new BuddyInfo("Alex", 1234);
        buddyRepository.save(buddy1);
        buddyRepository.save(buddy2);

        ResponseEntity<BuddyInfo[]> response = restTemplate.getForEntity("/info/buddies/getBuddies", BuddyInfo[].class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//        List<BuddyInfo> BuddyRepoSize = (List<BuddyInfo>) buddyRepository.findAll();
//        Assertions.assertEquals(BuddyRepoSize.size(),3);
        assertThat(response.getBody()).isNotNull();

    }

    @Test
    void testRemoveBuddy() {
        BuddyInfo buddy = new BuddyInfo("Jalal", 123);
        BuddyInfo savedBuddy = buddyRepository.save(buddy);

        ResponseEntity<Void> response = restTemplate.exchange("/info/buddies/" + savedBuddy.getId() + "/removeBuddy", HttpMethod.POST, null, Void.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(buddyRepository.findById(savedBuddy.getId())).isEmpty();

        ArrayList<Object> emptyList = new ArrayList<>();
        Assertions.assertEquals(buddyRepository.findByName("Jalal"),emptyList);
    }
}
