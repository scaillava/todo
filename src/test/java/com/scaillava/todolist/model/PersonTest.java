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

    @Test
    public void correctCaseExample() {

        try {
            String[] dna = {
                    "ATGCGA",
                    "CAGTGC",
                    "TTATGT",
                    "AGAAGG",
                    "CCCCTA",
                    "TCACTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isOk()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(true), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Correct case with 2 verticals lines  AAAA & CCCC
    @Test
    public void correctCase2VerticalLines() {

        try {
            String[] dna = {
                    "ATGCGT",
                    "ACGTAC",
                    "ATCTGC",
                    "AGAAGC",
                    "CTCCTC",
                    "TCACTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isOk()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(true), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Correct case with 2 horizontal lines TTTT & CCCC
    @Test
    public void correctCase2HorizontalLines() {

        try {
            String[] dna = {
                    "ATGCGA",
                    "CAGTGC",
                    "TGTTTT",
                    "AGAAGG",
                    "CCCCTA",
                    "TCACTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isOk()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(true), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Correct case with 2 indiagonals lines LR AAAA & CCCC
    @Test
    public void correctCase2IndiagonalLR() {

        try {
            String[] dna = {
                    "ATGCGA",
                    "CAGTGC",
                    "TCATCT",
                    "AGCAGG",
                    "CTCCTA",
                    "TCACTG"};

            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isOk()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(true), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Correct case with 2 indiagonals lines RL TTTT & GGGG
    @Test
    public void correctCase2IndiagonalRL() {

        try {
            String[] dna = {
                    "ATGCGA",
                    "CAGGAC",
                    "TTGTGT",
                    "AGAATG",
                    "CACTTA",
                    "TCTCTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isOk()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(true), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }


    //Incorrect case with 1 verticals lines  AAAA
    @Test
    public void incorrectCase1VerticalLines() {

        try {
            String[] dna = {
                    "ATGCGT",
                    "ACGTAC",
                    "ATCTGA",
                    "AGAAGC",
                    "CTCCTC",
                    "TCACTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isForbidden()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(false), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Incorrect case with 1 horizontal lines TTTT
    @Test
    public void incorrectCase1HorizontalLines() {

        try {
            String[] dna = {
                    "ATGCGA",
                    "CAGTGC",
                    "TGTTTT",
                    "AGAAGG",
                    "CGCCTA",
                    "TCACTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isForbidden()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(false), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Incorrect case with 1 indiagonals lines LR AAAA
    @Test
    public void incorrectCase1IndiagonalLR() {

        try {
            String[] dna = {
                    "ATGCGA",
                    "CAGTGC",
                    "TCATCT",
                    "AGGAGG",
                    "CTCCTA",
                    "TCACTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isForbidden()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(false), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Incorrect case with 1 indiagonals lines RL TTTT
    @Test
    public void incorrectCase1IndiagonalRL() {

        try {
            String[] dna = {
                    "ATCCGA",
                    "CATCAC",
                    "TTGTGT",
                    "AGAATG",
                    "CACGTA",
                    "TCTCTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isForbidden()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(false), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }


    //Incorrect case without lines
    @Test
    public void incorrectCaseAnyLine() {

        try {
            String[] dna = {
                    "ATGCGA",
                    "CAGTAC",
                    "TTGTGT",
                    "AGAATG",
                    "CACGTA",
                    "TCTCTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isForbidden()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals(Boolean.toString(false), content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Empty dna
    @Test
    public void incorrectCaseRequiredDNAException() {
        try {
            String[] dna = {
            };
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isBadRequest()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals("DNA is requiered.", content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Empty dna
    @Test
    public void incorrectCaseInvalidChar() {
        try {
            String[] dna = {
                    "ZTGCGA",
                    "CAGTAC",
                    "TTGTGT",
                    "AGAATG",
                    "CACGTA",
                    "TCTCTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isBadRequest()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals("The row has invalids characters, only characters available are [atcg]+.", content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Null dna
    @Test
    public void incorrectCaseRequiredDNAException2() {
        try {

            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content("".getBytes()))
                    .andExpect(status().isBadRequest()).andReturn();

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    //Incorrect structure
    @Test
    public void incorrectCaseStructure() {

        try {
            String[] dna = {
                    "ATGCG",
                    "CAGTAC",
                    "TTGTGT",
                    "AGAATG",
                    "CACGTA",
                    "TCTCTG"};
            MvcResult result = mockMvc.perform(
                    post("/mutant/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isBadRequest()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals("The structure of the dna is not correct. Must be 6x6.", content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }


    @Test
    public void statsTest() {

        try {
            correctCaseExample();
            incorrectCase1HorizontalLines();
            incorrectCase1IndiagonalLR();
            String[] dna = {
                    "ATGCG",
                    "CAGTAC",
                    "TTGTGT",
                    "AGAATG",
                    "CACGTA",
                    "TCTCTG"};
            MvcResult result = mockMvc.perform(
                    get("/stats/")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(getDNAPOJO(dna).getBytes()))
                    .andExpect(status().isOk()).andReturn();

            String content = result.getResponse().getContentAsString();
            assertEquals("{\"count_mutant_dna\":1,\"count_human_dna\":2,\"ratio\":0.5}", content);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }


    private String getDNAPOJO(String[] dna) {
        String dnaResult = "{\"dna\": [";

        for (String dnaItem : dna) {
            dnaResult += "\"" + dnaItem + "\"" + ",";
        }
        //remove last ","
        if (dna.length > 0)
            dnaResult = dnaResult.substring(0, dnaResult.length() - 1);

        dnaResult += "]}";
        return dnaResult;
    }
}

