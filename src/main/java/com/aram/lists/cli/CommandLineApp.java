package com.aram.lists.cli;

import com.aram.lists.files.SimpleFileReader;
import com.aram.lists.model.PhraseMatches;
import java.util.List;
import java.util.Scanner;

import static com.aram.lists.cli.Messages.ASK_FOR_PHRASE_TEMPLATE;
import static com.aram.lists.cli.Messages.FINAL_MESSAGE_TEMPLATE;
import static java.lang.String.format;

public class CommandLineApp {

    private final SimpleFileReader fileReader;
    private final Scanner scanner;
    private final PhraseMatches phraseMatches;

    public CommandLineApp() {
        this.fileReader = new SimpleFileReader();
        this.phraseMatches = new PhraseMatches();
        this.scanner = new Scanner(System.in);
    }

    public void run(String fileName) {
        final List<String> lines = fileReader.readLines(fileName);
        while (true) {
            final String phrase = askPhrase(fileName);
            final int matches = phraseMatches.of(phrase, lines);
            display(format(FINAL_MESSAGE_TEMPLATE, phrase, matches, fileName));
        }
    }

    private String askPhrase(String fileName) {
        return input(format(ASK_FOR_PHRASE_TEMPLATE, fileName));
    }

    private String input(String message) {
        display(message);
        return scanner.nextLine();
    }

    private void display(String message) {
        System.out.println(message);
    }


}
