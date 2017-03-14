package main;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Language language = new Language();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Number of fn:");
		int numOfFn = scanner.nextInt();

		String name;
		String input;
		String output;

		Function current = new Function();

		for (int i = 0; i < numOfFn; i++) {
			System.out.println("Fn number " + (i + 1));

			System.out.print("Name :");
			name = scanner.next();
			current.setFnName(name);

			System.out.print("Input :");
			input = scanner.next();
			current.setInput(input);

			System.out.print("Output :");
			output = scanner.next();
			current.setOutput(output);

			language.addFunction(current);
		}

		String composition = "";
		scanner.nextLine();
		composition = scanner.nextLine();
		String[] parts = composition.split(" . ");
		
		Stack<String> compStack = new Stack<>();
		for(int i=0;i<parts.length;i++) {
			compStack.push(parts[i].trim());
		}
		
		
		System.out.println(language.checkComposition(compStack));

	}

}
