package com.aram.lists.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseMatches {
    public int of(String phrase, List<String> strings) {
        // We DON'T need to do String.trim() because
        // a space is a valid character in a phrase. That is valid CTRL-F behaviour.
        final String phraseInLowerCase = phrase.toLowerCase();
        final Pattern pattern = Pattern.compile(phraseInLowerCase);
        int counter = 0;
        for (String each : strings) {
            counter += matches(pattern, each);
        }
        return counter;
    }

    private int matches(Pattern pattern, String each) {
        final String inLowerCase = each.toLowerCase();
        final Matcher matcher = pattern.matcher(inLowerCase);
        int counter = 0;
        while (matcher.find()) {
            counter += 1;
        }
        return counter;
    }
}
