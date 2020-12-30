package ua.com.foxminded.anagrams;

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(reverseWords("a1bcd efg!h"));
	}
	
	public static String reverseWords(String input) {
		String[] words = input.split(" ");
		StringBuilder reversedInput = new StringBuilder();
		
		for (int i = 0; i < words.length; i++) {
			char[] wordChars = words[i].toCharArray();
			for (int j = 0, k = wordChars.length - 1; j <= (wordChars.length / 2); j++) {
				if (!Character.isLetter(wordChars[k])) {
					k--;
				}
				if (Character.isLetter(wordChars[j]) && (j < k)) {
					char tempChar;
					tempChar = wordChars[k];
					wordChars[k] = wordChars[j];
					wordChars[j] = tempChar;
					k--;
				}
			}
			reversedInput.append(wordChars);
			reversedInput.append(" ");
		}
		return reversedInput.toString().trim();
	}
}
