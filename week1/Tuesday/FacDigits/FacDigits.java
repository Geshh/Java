import java.lang.*;

class FacDigits {
	public static void main(String[] args) {
		System.out.println(factorialDigits(123));
	}

	public static int factoriel(int facNum) {
		int finalFac=1;
		for(int i=facNum;i>1;i--) {
			finalFac*=i;
		}
		return finalFac;
	}

	public static int factorialDigits(int number) {
		int len=(int)Math.log10(number)+1;

		int finalSum=0;

		for(int i=0;i<len;i++) {
			finalSum+=factoriel(number%10);
			number/=10;
		}

		return finalSum;
	}
}