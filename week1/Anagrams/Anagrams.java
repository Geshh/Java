import java.util.Scanner;

class Anagrams {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter first word: ");
		String one = input.nextLine();
		System.out.print("Enter second word: ");
		String two = input.nextLine();


	 if (areAnagrams(one,two)) {
	      System.out.println("ANAGRAMS");
 	    } else {
	      System.out.println("NOT ANAGRAMS");
  	 	  }
}

	public static boolean areAnagrams(String firstWord , String secondWord ) {
		firstWord = firstWord.toLowerCase();
		secondWord = secondWord.toLowerCase();

		char curChar;

		if(firstWord.length() != secondWord.length()) {
			return false;
		} else {
			int size = firstWord.length();

			for(int i=0;i<size;i++) {

				curChar = firstWord.charAt(i);

				if(secondWord.indexOf(curChar)>=0) {
					char[] toArray = secondWord.toCharArray();
					toArray[secondWord.indexOf(curChar)] = ' ';
					secondWord = String.valueOf(toArray);
				} else {
					return false;
				}
			}
			return true;
		}
	}
}