package ua.com.foxminded.anagrams;

import static java.lang.Character.isLetter;

import java.util.StringJoiner;


public class ReverseString {

    final static String DELIMITER = " ";

    public static String reverseString(String input) {
        String[] inputWords = input.split(DELIMITER);
        return joinReversedWords(inputWords);
    }

    public static String joinReversedWords(String[] words) {
        StringJoiner reversedInput = new StringJoiner(DELIMITER);
        for (String word : words) {
            reversedInput.add(swapLetters(word));
        }
        return reversedInput.toString();
    }

    public static String swapLetters(String word) {
        char[] wordChars = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            wordChars = word.toCharArray();
            for (int j = 0, k = wordChars.length - 1; j <= (wordChars.length / 2); j++) {
                if (!isLetter(wordChars[k])) {
                    k--;
                }
                if (isLetter(wordChars[j]) && (j < k)) {
                    char[] swappedChars = swapChars(wordChars[j], wordChars[k]);
                    wordChars[k] = swappedChars[0];
                    wordChars[j] = swappedChars[1];
                    k--;
                }
            }
        }
        return String.valueOf(wordChars);
    }

    public static char[] swapChars(char j, char k) {
        char[] swappedChars = new char[2];
        swappedChars[0] = j;
        swappedChars[1] = k;
        return swappedChars;
    }

}
