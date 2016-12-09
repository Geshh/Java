package week2;

import java.util.HashMap;
import java.util.Scanner;

public class FunctionCallsExtension {
	
	private static int calculateFunctionInsideFunction(String fn , HashMap<String,String[]> hm , int argument) {
		int whereToSplit = fn.indexOf('(');
		int result = 0;
		fn = fn.substring(0,whereToSplit);
		fn = fn.trim();
		
		if(hm.containsKey(fn)) {
			result = calculateFunction(hm  , hm.get(fn).clone() , argument);
		} else {
			return 0;
		}		
		return result;
	}
	
	private static String[] splitFnBody(String body) {
		String[] fnBody = body.split(" ");
		return fnBody;
	}
	
	public static int calculateFunction(HashMap<String, String[]> hm , String[] fnBody , int x) {
		int result = x;
		
		String current = "";
		for(int i=0;i<fnBody.length;i++) {
			current = fnBody[i];
			if(current.charAt(0) == '+' || current.charAt(0) == '-' || Character.isDigit(current.charAt(0))) {
			} else if(current.contains("(") && current.contains(")")) {
				fnBody[i] = Integer.toString(calculateFunctionInsideFunction(current,hm,x));
			} else {
				fnBody[i] = Integer.toString(x);
				
			}
		}
		result = CALCULATEPLS(fnBody);
		return result;
	}
	
	private static int CALCULATEPLS(String[] function) {
		
		int result = Integer.parseInt(function[0]);
		
		for(int i=1;i<function.length;i++) {
			String current = function[i];
			
			if(current.equals("+")) {
				result+=Integer.parseInt(function[i+1]);
			} else if(current.equals("-")) {
				result-=Integer.parseInt(function[i+1]);
			}			
		}
		
		return result;
	}
		
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Num of Fn: ");
		int numberOfFn = scanner.nextInt();
		scanner.nextLine();
		
		
		HashMap<String,String[]> hm = new HashMap<>();
		
		String fnName = "";
		String fnBody = "";
		String input = "";
		for(int i=0;i<numberOfFn;i++) {
			System.out.println("Fn" + (i+1) + " : ");
			input=scanner.nextLine();
			
			int whereToSplit = input.indexOf("=");
			fnName = input.substring(0, whereToSplit - 1);
			fnName = fnName.trim();
			fnName = fnName.split(" ")[0];
			
			fnBody = input.split("=")[1];
			fnBody = fnBody.trim();
			
			hm.put(fnName, splitFnBody(fnBody));
		}
		
		
		
		System.out.println("What to calculate : ");
		input = scanner.nextLine();
		
		System.out.println("Argument needed");
		int x = scanner.nextInt();
		
		input=input.trim();
		input=input.replaceAll(" ", "");
		String[] parts = input.split("\\.");
		
		int result = x;
		for(int i=parts.length-1;i>=0;i--) {
			if(hm.containsKey(parts[i])) {
				result = calculateFunction(hm , hm.get(parts[i]).clone(), result );
			} else {
				System.out.println("Error");
				break;
			}
		}
		System.out.println(result);
		
		
	}
}
