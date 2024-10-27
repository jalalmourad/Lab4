//package com.example.lab4;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//@WebMvcTest(AddressBookRestController.class)
//class AddressBookTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private AddressBookRepository addressBookRepository;
//
//    @Test
//    public void testCreate() throws Exception {
//        AddressBook addressBook = new AddressBook();
//        addressBook.setId(1L);
//
//        when(addressBookRepository.save(any(AddressBook.class))).thenReturn(addressBook);
//
//        mockMvc.perform(post("/info/addressbook/create").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(addressBook)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists());
//    }
//}
