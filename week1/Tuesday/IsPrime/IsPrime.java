import java.lang.*;

class IsPrime {
	public static void main(String[] args) {
		System.out.println(isNumberPrime(17));
		System.out.println(isNumberPrime(15));
	}

	public static boolean isNumberPrime(int number) {
		for(int i=2;i<Math.sqrt(number);i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}