package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramsTest {

    private ReverseString reverse;

    private static final String EMPTY_INPUT = "";
    private static final String NO_SPACE = "abcdefgh";
    private static final String LETTERS_ONLY = "abcd efgh";
    private static final String NUMBERS_ONLY = "1234 5678";
    private static final String SPECIAL_CHARS_ONLY = "!@#$ %^&*";
    private static final String LETTERS_AND_NUMBERS = "a1234bcd efg8h";
    private static final String LETTER_AND_SPECIAL_CHARS = "ab#cd ef%g!h";
    private static final String NUMBERS_AND_SPECIAL_CHARS = "12#34 56%7!8";
    private static final String LETTERS_AND_NUMBERS_AND_SPECIAL_CHARS = "ab12#34cd ef56%7g!8h";

    @BeforeEach
    void init() {
        reverse = new ReverseString();
    }

    @Test
    void reverseString_ShouldThrowIllegalArgumentException_IfInputIsNull() {
        String expected = "Input cannot be null!";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> reverse.reverseString(null));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void reverseString_ShouldReturnEmpty_IfEmptyInput() {
        String actual = reverse.reverseString(EMPTY_INPUT);
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldReverse_IfNoSpace() {
        String actual = reverse.reverseString(NO_SPACE);
        String expected = "hgfedcba";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldReverse_IfLettersOnly() {
        String actual = reverse.reverseString(LETTERS_ONLY);
        String expected = "dcba hgfe";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldNotReverse_IfNumbersOnly() {
        String actual = reverse.reverseString(NUMBERS_ONLY);
        String expected = "1234 5678";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldNotReverse_IfSpecialCharsOnly() {
        String actual = reverse.reverseString(SPECIAL_CHARS_ONLY);
        String expected = "!@#$ %^&*";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldReverseLettersOnly_IfLettersAndNumbers() {
        String actual = reverse.reverseString(LETTERS_AND_NUMBERS);
        String expected = "d1234cba hgf8e";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldReverseLettersOnly_IfLettersAndSpecialChars() {
        String actual = reverse.reverseString(LETTER_AND_SPECIAL_CHARS);
        String expected = "dc#ba hg%f!e";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldNotReverse_IfNumbersAndSpecialChars() {
        String actual = reverse.reverseString(NUMBERS_AND_SPECIAL_CHARS);
        String expected = "12#34 56%7!8";
        assertEquals(expected, actual);
    }

    @Test
    void reverseString_ShouldReverseLettersOnly_IfLettersAndNumbersAndNonLetters() {
        String actual = reverse.reverseString(LETTERS_AND_NUMBERS_AND_SPECIAL_CHARS);
        String expected = "dc12#34ba hg56%7f!8e";
        assertEquals(expected, actual);
    }

}
