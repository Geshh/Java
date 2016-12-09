class OddNumber {
	public static void main(String[] args) {
		System.out.println(isNumberOdd(8));
		System.out.println(isNumberOdd(15));
	}

	public static boolean isNumberOdd(int number) {
		if(number%2==0)
			return false;
		return true;
	}
}