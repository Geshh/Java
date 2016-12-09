
class FindDivisorsSum {

	public static void main(String[] args) {

		System.out.println(sumOfDivisors(4,7));
	}

	public static int sumOfDivisors(int beg , int end ) {

		int sum = 0;
		for(int i=beg ; i<=end ; i++) {
			sum+= divisorsOf(i);
		}

		return sum;
	}

	public static int divisorsOf(int number) {

		int divisor=1;
		int divSum=0;

		while(divisor<=number) {
			if(number%divisor==0) {
				divSum+=divisor;
			}
			divisor+=1;
		}

		return divSum;
	}
}