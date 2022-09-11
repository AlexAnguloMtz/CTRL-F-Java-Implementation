package com.aram.lists.model;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class whose single responsibility is to implement CTRL-F behaviour.
 * It can determine how many times a phrase (not a word, but an actual phrase)
 * is repeated in a Collection of String objects. It is guaranteed to ignore cases.
 *
 * The behaviour of this class mimics the Google Chrome's CTRL-F feature, so:
 * - Phrases CAN (and DO) include any character, including whitespaces.
 * - Phrases are searched in a LINE by LINE basis (in this case, String by String)
 *
 *  EXAMPLES:
 *  - If we look for 'Alice' in 'Alice in Wonderland', we get 399 matches
 *  - If we look for 'aLic' in 'Alice in Wonderland', we STILL get 399 matches (CTRL-F behaviour)
 *  - If we look for 'white rabbit' in 'Alice in Wonderland' we get 21 matches
 *
 *  As far as the author is concerned, the results are exactly equal to the Chrome's CTRL-F feature.
 *
 * @author Alex Angulo
 *
 */

public final class PhraseMatches {

    /**
     * Determines the number of matches for a phrase in a Collection of String objects
     * A match is defined as 'the exact same character sequence inside any other String object'
     * For example: 'green snake' has 2 matches in 'The green snake has green snake fever'
     *
     * @param phrase     the phrase to search
     * @param strings    the strings that might or not contain the phrase
     * @return the total number of matches for the phrase in the given Collection of String objects
     *
     */
    public int of(String phrase, Collection<String> strings) {
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
