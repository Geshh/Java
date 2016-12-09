
class NumVowConDig {

	public static void main(String[] args) {
		counter("It is 18th of Oct 2016");
	}

	public static void counter(String str) {
		int vowelsNum=0;
		int consonantsNum=0;
		int digitsNum=0;
		String vowels = "aeiuoyAEIUOY";
		for(int i=0;i<str.length();i++) {
			char current = str.charAt(i);
			if(vowels.indexOf(current)!=-1) {
				vowelsNum+=1;
			} else if(Character.isDigit(current)) {
				digitsNum+=1;
			} else if(current!=' ') {
				consonantsNum+=1;
			}
		}

		System.out.println("Vowels : " + vowelsNum);
		System.out.println("Consonants : " + consonantsNum);
		System.out.println("Digits ; " + digitsNum);
	}
}