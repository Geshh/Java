
class Reverse {
	public static void main(String[] args) {

		reverseOddWords("This is the first lecture for Programming 101 with Java");
	}

	public static String reverseOddWords(String sentence) {

		//skipping the even words
		for(int i=0;i<sentence.length();i++) {
			if(sentence.charAt(i)==' ') {
				findAndReverseOdd(sentence,i);
			}
		}
		return sentence;
	}

	public static void findAndReverseOdd(String str , int beg) {

		while(str.charAt(beg)==' ') {
			beg+=1;
		}

		int end = beg;

		String originalWord="";
		String reversedWord = "";

		while(str.charAt(end)!=' ') {
			originalWord+=Character.toString(str.charAt(end));
			end+=1;
		}
		end-=1;

		while(end>=beg) {
			reversedWord += Character.toString(str.charAt(end));
			end-=1;
		}

		str = str.replace(originalWord,reversedWord);

	}










}