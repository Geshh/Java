package week2;

import java.util.Scanner;

public class FunctionCalls {

	public static int f1(int x) {		
		return f2(x) + f3(x);
	}
	public static int f2(int x) {		
		return x*2;
	}
	public static int f3(int x) {		
		return x+1;
	}
	public static int f4(int x) {		
		return f1(x)*2;
	}
	
	public static int evaluate(String formula , int x) {
		formula=formula.replaceAll(" ", "");
		String[] parts = formula.split("\\.");
		
		int result = x;
		for(int i=parts.length-1;i>=0;i--) {
			switch(parts[i]) {
			case "f1":
				result=f1(result);
				break;
			case "f2":
				result=f2(result);
				break;				
			case "f3":
				result=f3(result);
				break;
			case "f4":
				result=f4(result);
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
	    @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

	    String input = scanner.nextLine();
	    int x = scanner.nextInt();

	    System.out.println(evaluate(input, x));
	    
	}
}
