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
 *  - If we look for 'white rabbit' in 'Alice in Wonderland' we get 3 matches
 *
 *  As far as the author is concerned, the results are exactly equal to the Chrome's CTRL-F feature.
 *
 * @author Alex Angulo
 */
public final class PhraseMatches {
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
