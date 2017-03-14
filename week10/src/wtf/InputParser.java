package wtf;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputParser {

	
	interface Command {
		void run(String x);
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Map<String,Command> commands = new HashMap<>();
		
		commands.put("show movies",new Command() {
			public void run(String x) {
				System.out.println("WTF");
			}
		});
	
		commands.put("help", (z)-> System.out.println(commands.keySet()));
		
		String command = input.nextLine();
		commands.get(command).run(command);
		
		

	}
}
