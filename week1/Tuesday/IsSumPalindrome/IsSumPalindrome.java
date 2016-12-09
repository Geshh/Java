import java.lang.*;

class IsSumPalindrome {

	public static void main(String[] args) {

		System.out.println(isSumPal(123));
	}

	public static boolean isSumPal(int number) {

		int sum = number;
		int reversed=0;

		while(number!=0) {
			reversed*=10;
			reversed+=number%10;
			number/=10;
		}

		sum+=reversed;

		int len = (int)Math.log10(sum) + 1;

		int[] digits = new int[len];

		for(int i=0;i<len;i++) {
			digits[i]=sum%10;
			sum/=10;
		}

		for(int i=0,j=len-1;i<len/2;i++,j--) {
			if(digits[i]!=digits[j]) {
				return false;
			}
		}
		return true;
	}
}