package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramsTest {

    ReverseString reverse;

    @BeforeEach
    void init() {
        reverse = new ReverseString();
    }

    @Test
    void testReverseCustomerProvidedString() {
        String input = "a1bcd efg!h";
        String actual = reverse.reverseString(input);
        String expected = "d1cba hgf!e";
        assertEquals(expected, actual);
    }

    @Test
    void testOneWordString() {
        String input = "a1bcd";
        String actual = reverse.reverseString(input);
        String expected = "d1cba";
        assertEquals(expected, actual);
    }

    @Test
    void testNonLettersOnlyInput() {
        String input = "345!3#45?345&^";
        String actual = reverse.reverseString(input);
        String expected = "345!3#45?345&^";
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyInput() {
        String input = "";
        String actual = reverse.reverseString(input);
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void testNullInput() {
        String expected = "Input cannot be null!";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> reverse.reverseString(null));
        assertEquals(expected, exception.getMessage());
    }

}
