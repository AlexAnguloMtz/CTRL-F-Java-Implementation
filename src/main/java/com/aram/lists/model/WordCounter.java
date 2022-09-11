package com.aram.lists.model;

import java.util.Collection;

/**
 * Class whose single responsibility is to count
 * the repetitions of a word in a given Collection of words
 *
 * @author Alex Angulo
 */
public final class WordCounter {
    public long repetitions(final String searchedWord, final Collection<String> allWords) {
        // Some Java 8...
        final String processedWord = searchedWord.toLowerCase().trim();
        return allWords.stream()
                .map(String::toLowerCase)
                .map(String::trim)
                .filter(word -> word.equals(processedWord))
                .count();
    }
}