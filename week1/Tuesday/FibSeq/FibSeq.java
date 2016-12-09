

class FibSeq {
	public static void main(String[] args) {
		fibonacciSequence(5);
		System.out.println();
	}

	public static void fibonacciSequence(int number) {

		if(number==1) {
			System.out.println(1);
		}else if(number==2) {
			System.out.println(11);
		} else {
			int[] digits = new int[number];
			digits[0]=1;
			digits[1]=1;
			System.out.print(11);
		
			for(int i=2;i<number;i++) {
				digits[i]=digits[i-1] + digits[i-2];
				System.out.print(digits[i]);
			}
		}
	}
}