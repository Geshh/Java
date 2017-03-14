package functionalProgramming;

public class Main {

	public static void main(String[] args) {

		LinkedList<String> l = new LinkedList<>();
		l.add("fdsfds");
		l.add("ddddddddddddddddd");
		l.add("asdfdsZZ");
		l.add("Wdd");
		
		System.out.println(l);

		System.out.println(l.filter(x -> false));

		System.out.println(l.map((x -> x.length())));

		System.out.println(l.map(String::length));

		System.out.println(l.map(String::length).reduce(0, (x, y) -> x + y));

		System.out.println(l.reduce("", (x, y) -> x + " :: " + y));
		
		
		//From java
		
//		List<String> list = new LinkedList<>();
//		list.add("fdsfds");
//		list.add("df");
//		System.out.println(list.stream().filter(x -> x.length() > 5).collect(Collectors.toList()));

	}
}
