import java.lang.*;

class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome(1221));
	}

	public static boolean isPalindrome(int number) {
		int len = (int)Math.log10(number)+1;
		
		int[] digits = new int[len];

		for(int i=0;i<len;i++) {
			digits[i]=number%10;
			number/=10;
		}

		for(int i=0,j=len-1;i<len/2;i++,j--) {
			if(digits[i]!=digits[j]) {
				return false;
			}
		}
		return true;
	}
}