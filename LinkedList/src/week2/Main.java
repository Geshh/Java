package week2;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		
		for(int i=0;i<10;i++) {
			l.add(i);
		}

		//Iterator<Integer> it = l.iterator();
		
		for(Integer i : l) {
			System.out.println(i);
		}
		

		HashMap<Integer,String> h = new HashMap<>();
		h.put(1, "Hello");
		h.get(1);
		
		
		
	}
}
