package com.sbt.javaschool.rnd;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtParser {

    List<String> listText;

    public TxtParser(Path textFilePath) {
        try {
            Stream<String> fileLines = Files.lines(textFilePath, Charset.defaultCharset());
            listText = new ArrayList<String>(fileLines.collect(Collectors.toList()));
        } catch (
                IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public final long countWords() {
        long wordCount = listText.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .count();
        System.out.println("The numbers of words: " + wordCount);
        return wordCount;
    }

    public final void showWords() {
        List<String> sortedList = new ArrayList<String>();
        sortedList.addAll(listText.stream()
                .flatMap(line -> Arrays.stream(line.split("[,. +]+")))
                .collect(Collectors.toList()));
        Comparator<List<String>> compLenght = null;

        sortedList.sort((o1, o2) -> {
            return o1.length() - o2.length();
        });

        sortedList.forEach(System.out::println);
    }

    public final void countSimilarWords() {
        List<String> sortedList = new ArrayList<String>();
        sortedList.addAll(listText.stream()
                .flatMap(line -> Arrays.stream(line.split("[,. +]+")))
                .collect(Collectors.toList()));
        Comparator<List<String>> compLenght = null;

        sortedList.sort((o1, o2) -> {
            return o1.length() - o2.length();
        });

        sortedList.forEach(System.out::println);
    }


}
