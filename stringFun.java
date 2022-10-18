/*
	 * Author: Sarah Grady
	 * Date of Initialization: February 20, 2022
	 * Date of Completion: February 21, 2022
	 * Purpose: To learn about functions associated with strings and gain skill in manipulating them. 
	 */
public class stringFun {

	public static void main(String[] args) {
		//System.out.println(repeatLastN("Hi There!", 3));
		//System.out.println(titalizeString("Hi, my name is Krista, what is your name?"));
		//System.out.println(stringMixer("Hello", "Nobody!"));
	}

	public static String repeatLastN(String S, int n) {
		int length1 = S.length();
		String String2 = S.substring(length1 - n);
		String String3 = "";
		for (int i = 0; i < n; i++) {
			String3 = String2 + String3;
		}
		return String3;
	}

	public static String titalizeString(String S) {
		String[] words = S.split(" "); 
		String capitalLetter = "";
		int length = words.length;
		// Used for stringing words back together for return
		String allTheWords = "";
		for (int i = 0; i < length; i++) { // Substrings the first letter and changes to uppercase
			String currentWord = words[i];
			String firstLetter = currentWord.substring(0, 1);
			firstLetter = firstLetter.toUpperCase();	
			allTheWords = allTheWords + " " + firstLetter + currentWord.substring(1);
		}
		return allTheWords;
	}

	public static String stringMixer(String S1, String S2) {
        int temp =0;
        String bigger = S1;
        String smaller = S2;
        if (S1.length() < S2.length()) { // Determines which word is larger and where it's assigned
            bigger = S2;
            smaller = S1;
        }
        int length = S1.length() + S2.length();
        char[] word = new char[length];
        for( int i = 0, j = 0; j < smaller.length(); i+=2, j++) { // Loops each character and pairs them up according
            word[i] = S1.charAt(j);
            word[i + 1] = S2.charAt(j);
            temp = i+2;
        }
        for (int i = temp, j = smaller.length(); i < length; i++, j++) { // Insures the end of the larger word is accounted for
            word[i] = bigger.charAt(j);
        }
       
        return String.valueOf(word);
    }

}
