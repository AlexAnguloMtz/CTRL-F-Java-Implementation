package com.aram.lists.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class's single responsibility is to extract
 * all the real English words from a Collection of
 * String objects that might - or might not - contain real words.
 *
 * @author Alex Angulo
 */

public final class WordExtractor {
    private static final String REAL_ENGLISH_WORDS_REGEX = "[A-Za-z]+";
    private static Pattern wordPattern = Pattern.compile(REAL_ENGLISH_WORDS_REGEX);

    public List<String> extractRealWords(Collection<String> potentialWords) {
        final List<String> realWords = new ArrayList<>();
        for (String string : potentialWords) {
            var matcher = wordPattern.matcher(string);
            while (matcher.find()) {
                realWords.add(matcher.group());
            }
        }
        return realWords;
    }
}
