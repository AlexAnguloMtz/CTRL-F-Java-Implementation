package com.aram.lists.cli;

import com.aram.lists.files.SimpleFileReader;
import com.aram.lists.model.WordCounter;
import com.aram.lists.model.WordExtractor;

import java.util.List;
import java.util.Scanner;

import static com.aram.lists.cli.Messages.ASK_FOR_WORD_TEMPLATE;
import static com.aram.lists.cli.Messages.FINAL_MESSAGE_TEMPLATE;
import static java.lang.String.format;

public class CommandLineApp {

    private final SimpleFileReader fileReader;
    private final WordExtractor wordExtractor;
    private final WordCounter wordCounter;
    private final Scanner scanner;

    public CommandLineApp() {
        this.fileReader = new SimpleFileReader();
        this.wordExtractor = new WordExtractor();
        this.wordCounter = new WordCounter();
        this.scanner = new Scanner(System.in);
    }

    public void run(String fileName) {
        final List<String> wordsInFile = readWords(fileName);
        while (true) {
            final String searchedWord = askSearchedWord(fileName);
            final long repetitions = wordCounter.repetitions(searchedWord, wordsInFile);
            display(format(FINAL_MESSAGE_TEMPLATE, searchedWord, repetitions, fileName));
        }
    }

    private List<String> readWords(String fileName) {
        final List<String> rawTokens = fileReader.rawTokens(fileName);
        return wordExtractor.extractRealWords(rawTokens);
    }

    private String askSearchedWord(String fileName) {
        return input(format(ASK_FOR_WORD_TEMPLATE, fileName));
    }

    private String input(String message) {
        display(message);
        return scanner.nextLine();
    }

    private void display(String message) {
        System.out.println(message);
    }


}
