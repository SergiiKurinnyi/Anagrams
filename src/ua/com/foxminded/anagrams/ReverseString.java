package ua.com.foxminded.anagrams;

import static java.lang.Character.isLetter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;


public class ReverseString {

    private static final String DELIMITER = " ";

    public String reverseString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null!");
        }
        String[] inputWords = input.split(DELIMITER);
        StringJoiner reversedInput = new StringJoiner(DELIMITER);
        for (String word : inputWords) {
            reversedInput.add(reverseWord(word));
        }
        return reversedInput.toString();
    }

    private String reverseWord(String word) {
        char[] wordChars = word.toCharArray();
        List<Character> charsOnly = new ArrayList<>();

        for (char symbol : wordChars) {
            if (isLetter(symbol)) {
                charsOnly.add(symbol);
            }
        }
        Collections.reverse(charsOnly);

        for (int i = 0, k = 0; i < wordChars.length; i++) {
            if (isLetter(wordChars[i])) {
                wordChars[i] = charsOnly.get(k);
                k++;
            }
        }
        return String.valueOf(wordChars);
    }

}

