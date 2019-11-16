package com.sbt.javaschool.rnd;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

public class TxtParserTest {
    TxtParser txtParser = new TxtParser(Paths.get("E:\\projects\\IntelliJIDEA\\JavaHomeWorks\\Lesson3\\src\\test\\resources\\com\\sbt\\javaschool\\rnd\\test"));

    @Test
    public void countWords() {

        assertEquals(27,txtParser.countWords());
    }

    @Test
    public void showWords() {
        //txtParser.showWords();
       // txtParser.countSimilarWords();
    }

    @Test
    public void printTextReverse() {
        txtParser.printTextReverse();
    }
}