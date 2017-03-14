package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Language {

	private Map<String, Function> language;

	public Language() {
		language = new HashMap<>();
	}

	public void addFunction(Function fn) {
		if (language.containsKey(fn.getFnName())) {
			return;
		}
		language.put(fn.getFnName(), fn);
	}

	public boolean checkRecursive(Stack<String> comp) {
		if (comp.isEmpty()) {
			return true;
		
		} else if (!language.containsKey(comp.peek())) {
			return false;
		
		} else {

			Function cur = language.get(comp.pop());
			Function next = language.get(comp.peek());

			if(cur.getOutput().equals(next.getInput())) {
				return checkRecursive(comp);
			}
			
		}
		
		return false;
	}

	public boolean checkComposition(Stack<String> comp) {

		return checkRecursive(comp);

	}
}
