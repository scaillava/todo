package com.scaillava.todolist.model;

import com.scaillava.todolist.TODOListApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {
    private static final Logger log = LoggerFactory.getLogger(TODOListApplication.class);
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext appContext;

    //Correct case with 1 verticals GGGG, 1 horizontal CCCC & 1 indiagol LR AAAA


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.appContext).build();
    }

//    @Test
//    public void correctCaseExample() {
//
//        try {
//            String[] dna = {
//                    "ATGCGA",
//                    "CAGTGC",
//                    "TTATGT",
//                    "AGAAGG",
//                    "CCCCTA",
//                    "TCACTG"};
//            MvcResult result = mockMvc.perform(
//                    post("/mutant/")
//                            .contentType(MediaType.APPLICATION_JSON_UTF8)
//                            .content(getDNAPOJO(dna).getBytes()))
//                    .andExpect(status().isOk()).andReturn();
//
//            String content = result.getResponse().getContentAsString();
//            assertEquals(Boolean.toString(true), content);
//        } catch (Exception ex) {
//            log.error(ex.getMessage());
//        }
//    }
//
//    //Correct case with 2 verticals lines  AAAA & CCCC
//    @Test
//    public void correctCase2VerticalLines() {
//
//        try {
//            String[] dna = {
//                    "ATGCGT",
//                    "ACGTAC",
//                    "ATCTGC",
//                    "AGAAGC",
//                    "CTCCTC",
//                    "TCACTG"};
//            MvcResult result = mockMvc.perform(
//                    post("/mutant/")
//                            .contentType(MediaType.APPLICATION_JSON_UTF8)
//                            .content(getDNAPOJO(dna).getBytes()))
//                    .andExpect(status().isOk()).andReturn();
//
//            String content = result.getResponse().getContentAsString();
//            assertEquals(Boolean.toString(true), content);
//        } catch (Exception ex) {
//            log.error(ex.getMessage());
//        }
//    }

 }

