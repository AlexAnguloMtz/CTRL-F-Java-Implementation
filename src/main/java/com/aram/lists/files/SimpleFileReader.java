package com.aram.lists.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleFileReader {
    public List<String> rawTokens(String fileName) {
        final List<String> allTokens = new ArrayList<>();
        try (var scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNext()) {
                allTokens.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return allTokens;
    }
}