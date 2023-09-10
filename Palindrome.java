import java.util.*;

/**
 * This program accepts a String input and will tell you whether it's a palindrome or not,
 * provided it doesn't contain any special characters.
 * @author Patrick Valsted
 *
 */

public class Palindrome {

	public static void main(String[] args) {
		
		//the first 2 Strings will work because they are the same forwards and back,
		//but the 3rd will not since it is not
		new Palindrome().isPalindrome("racecar");
		new Palindrome().isPalindrome("A man a plan a canal Panama");
		new Palindrome().isPalindrome("This sentence will not work");

	}//end main
	
	/**
	 * This method will take the input word and reverse it to test
	 * if a String is a palindrome or not.
	 * @param word you want to test, spaces accepted but not special characters
	 */
	public void isPalindrome (String word) {
		String originalWord, tempWord, newWord="";
		char tempChar;
		int stringLength;
		Stack<Character> stringStack=new Stack<>();
		
		originalWord=word.toLowerCase(); //converts String to lowercase so case doesn't matter
		stringLength=originalWord.length(); //stores the length of the String to use in the for loop
		
		tempWord=originalWord; //the value of originalWord is temporarily stored
		originalWord=""; //the value is reset so the word can be reconstructed
		
		for (int i=0;i<stringLength;i++) { //loop takes place as many times as there are characters in the string
			if (tempWord.charAt(i) != ' ') {
				originalWord=originalWord+tempWord.charAt(i); //the original word is reconstructed without spaces
			};
		}//end for loop
		
		stringLength=originalWord.length(); //updates the length of the String without spaces to use in the next for loop
		
		for (int i=0;i<stringLength;i++) { //loop takes place as many times as there are characters in the string
			if (originalWord.charAt(i) != ' ') stringStack.push(originalWord.charAt(i)); //at each location in the String, the character is pushed onto the stack as long as it isn't a space
		} //end for loop
	
		int stackSize=stringStack.size(); //the stack size is stored to use in the next for loop
		
		for (int i=0;i<stackSize;i++) { //loop takes place as many times as there are entries in the stack
			tempChar=stringStack.pop(); //each character is stored in a temporary variable
			newWord=newWord+tempChar; //newWord is constructed by adding the character previously stored to the characters added so far until the String is fully constructed in reverse order
		}//end for loop
		
		if (originalWord.equals(newWord)==true) System.out.println("This String is a palindrome!"); //if the original and new words match, this will print
		else System.out.println("This String is not a palindrome!"); //otherwise, a message will let the user know they aren't palindromes.
	}//end isPalindrome

}//end class
