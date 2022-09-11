package com.aram.lists;

import com.aram.lists.cli.CommandLineApp;

public class Main {

    private static final String INVALID_ARGUMENTS_LENGTH =
            "Error. This program needs exactly 1 argument for the name of the file. Try again.";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(INVALID_ARGUMENTS_LENGTH);
            return;
        }
        String fileName = args[0];
        CommandLineApp app = new CommandLineApp();
        app.run(fileName);
    }
}