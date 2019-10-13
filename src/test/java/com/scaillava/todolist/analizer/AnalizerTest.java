package com.scaillava.todolist.analizer;

import com.scaillava.todolist.analizer.impl.DNAAnalizerImpl;
import com.scaillava.todolist.exception.TodoRequired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalizerTest {
    private static final Logger log = LoggerFactory.getLogger(AnalizerTest.class);
    DNAAnalizer dnaAnalizer;


    //Correct case with 1 verticals GGGG, 1 horizontal CCCC & 1 indiagol LR AAAA
    @Test
    public void correctCaseExample() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Correct case with 2 verticals lines  AAAA & CCCC
    @Test
    public void correctCase2VerticalLines() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGT",
                "ACGTAC",
                "ATCTGC",
                "AGAAGC",
                "CTCCTC",
                "TCACTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Correct case with 2 horizontal lines TTTT & CCCC
    @Test
    public void correctCase2HorizontalLines() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TGTTTT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Correct case with 2 indiagonals lines LR AAAA & CCCC
    @Test
    public void correctCase2IndiagonalLR() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TCATCT",
                "AGCAGG",
                "CTCCTA",
                "TCACTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Correct case with 2 indiagonals lines RL TTTT & GGGG
    @Test
    public void correctCase2IndiagonalRL() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGGAC",
                "TTGTGT",
                "AGAATG",
                "CACTTA",
                "TCTCTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }


    //Incorrect case with 1 verticals lines  AAAA
    @Test
    public void incorrectCase1VerticalLines() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGT",
                "ACGTAC",
                "ATCTGA",
                "AGAAGC",
                "CTCCTC",
                "TCACTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }

    //Incorrect case with 1 horizontal lines TTTT
    @Test
    public void incorrectCase1HorizontalLines() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TGTTTT",
                "AGAAGG",
                "CGCCTA",
                "TCACTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }

    //Incorrect case with 1 indiagonals lines LR AAAA
    @Test
    public void incorrectCase1IndiagonalLR() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TCATCT",
                "AGGAGG",
                "CTCCTA",
                "TCACTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }

    //Incorrect case with 1 indiagonals lines RL TTTT
    @Test
    public void incorrectCase1IndiagonalRL() throws DNAStructureException, TodoRequired, InvalidCharException {

        String[] dna = {
                "ATCCGA",
                "CATCAC",
                "TTGTGT",
                "AGAATG",
                "CACGTA",
                "TCTCTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertFalse(dnaAnalizer.isMutant(dna));

    }


    //Incorrect case without lines
    @Test
    public void incorrectCaseAnyLine() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTAC",
                "TTGTGT",
                "AGAATG",
                "CACGTA",
                "TCTCTG"};
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }

    //Empty dna
    @Test
    public void incorrectCaseRequiredDNAException() {
        try {
            String[] dna = {
            };
            dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
            dnaAnalizer.isMutant(dna);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            assertEquals("DNA is requiered.", ex.getMessage());
        }
    }

    //Null dna
    @Test
    public void incorrectCaseRequiredDNAException2() {
        try {
            dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 6);
            dnaAnalizer.isMutant(null);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            assertEquals("DNA is requiered.", ex.getMessage());
        }
    }

    //Incorrect structure
    @Test
    public void incorrectCaseStructure() {
        int r = 6;
        int c = 6;
        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", r, c);
        try {
            String[] dna = {
                    "ATGCG",
                    "CAGTAC",
                    "TTGTGT",
                    "AGAATG",
                    "CACGTA",
                    "TCTCTG"};
            dnaAnalizer.isMutant(dna);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            assertEquals("The structure of the dna is not correct. Must be " + c + "x" + r + ".", ex.getMessage());
        }
    }

    /////////////////////////
    //(consecutiveDNACharacter > (dnaLine.length() / 2))

    //Correct case with 2 seq in one line "AAAAAA"
    @Test
    public void correctCaseTwoSeqOneLine() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTCC",
                "TTATGT",
                "AGAAGG",
                "CGCCAA",
                "TCACTA"};

        dnaAnalizer = new DNAAnalizerImpl(3, 2, "[atcg]+", 6, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Incorrect case with 1 seq in one line "AAA"
    @Test
    public void IncorrectCaseOneSeqOneLine() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGA",
                "CAGTCC",
                "TTATGT",
                "AGAAGG",
                "CGCCTA",
                "TCACTA"};

        dnaAnalizer = new DNAAnalizerImpl(3, 2, "[atcg]+", 6, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }

    //Correct case with 3 seq in one line "AAAAAA" with different regex =[atcgxzy]+ and consecutiveDNAcharacter = 2 and mutantSeqAmout = 3
    @Test
    public void correctCaseThreeSeqOneLine() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGTGA",
                "CACYCX",
                "TXATGT",
                "AGZAYC",
                "CYCTAX",
                "TGAYGA"};

        dnaAnalizer = new DNAAnalizerImpl(2, 3, "[atcgxzy]+", 6, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Incorrect case with 2 seq in one line "AAAA" with different regex =[atcgxzy]+ and consecutiveDNAcharacter = 2 and mutantSeqAmout = 3
    @Test
    public void incorrectCaseTwoSeqOneLine() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGTGA",
                "CACYCX",
                "TXATGT",
                "AGZAYC",
                "CYCTAX",
                "TGAYGC"};

        dnaAnalizer = new DNAAnalizerImpl(2, 3, "[atcgxzy]+", 6, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }


    /////////////////////////
    //Rectangular Cases

    //Correct case with Rectangular matrix case "AAAA" & "CCCC" 5x6
    @Test
    public void correctCaseRectangularM5x6Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "TTGCG",
                "CACTC",
                "TCATG",
                "CGAAG",
                "CTCCA",
                "TGACT"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 5, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Incorrect case with Rectangular matrix case with one seq line "AAAA" 5x6
    @Test
    public void incorrectCaseRectangularM5x6Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "TTGCG",
                "CAGTC",
                "TTATG",
                "AGAAG",
                "CTCCA",
                "TGACT"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 5, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }

    //Correct case with Rectangular matrix case "AAAA" & "CCCC" 6x5
    @Test
    public void correctCaseRectangularM6x5Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGC",
                "CAGTCC",
                "TTACGT",
                "AGCAGG",
                "CTCCAA"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 5);
        assertTrue(dnaAnalizer.isMutant(dna));
    }

    //Incorrect case with Rectangular matrix case with one seq line "CCCC" 6x5
    @Test
    public void incorrectCaseRectangularM6x5Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGC",
                "CAGTCC",
                "TTTCGT",
                "AGCAGG",
                "CTCCAA"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 5);
        assertFalse(dnaAnalizer.isMutant(dna));
    }
    //Correct case with Rectangular matrix case with two seq line"AAAA" & "CCCC" 4x6
    @Test
    public void correctCaseRectangularM4x6Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGC",
                "CACT",
                "TCAT",
                "CGAA",
                "CTCC",
                "TGAC"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 4, 6);
        assertTrue(dnaAnalizer.isMutant(dna));
    }
    //Incorrect case with Rectangular matrix case with one sec line "CCCC" 4x6
    @Test
    public void incorrectCaseRectangularM4x6Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGC",
                "CTCT",
                "TCAT",
                "CGAA",
                "CTCC",
                "TGAC"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 4, 6);
        assertFalse(dnaAnalizer.isMutant(dna));
    }


    //Correct case with Rectangular matrix case with two seq line"AAAA" & "CCCC" 6x4
    @Test
    public void correctCaseRectangularM6x4Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGC",
                "CAGTCC",
                "TTACGT",
                "AGCAGG"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 4);
        assertTrue(dnaAnalizer.isMutant(dna));
    }
    //Incorrect case with Rectangular matrix case with one sec line "CCCC" 6x4
    @Test
    public void incorrectCaseRectangularM6x4Example() throws DNAStructureException, TodoRequired, InvalidCharException {
        String[] dna = {
                "ATGCGC",
                "CAGTCC",
                "TTTCGT",
                "AGCAGG"};

        dnaAnalizer = new DNAAnalizerImpl(4, 2, "[atcg]+", 6, 4);
        assertFalse(dnaAnalizer.isMutant(dna));
    }



}