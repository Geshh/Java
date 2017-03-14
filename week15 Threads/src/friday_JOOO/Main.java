package friday_JOOO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {

	public static void main(String[] args) {

		List<String> l = Arrays.asList("one", "two");

		for (String s : l) {
			System.out.println(s);
		}

		l.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}

		});

		l.forEach(s -> System.out.println(s));

		l.forEach(System.out::println);

		l.stream().map(String::toUpperCase).forEach(System.out::println);
		
		Collections.sort(l , (a,b) -> Integer.compare(a.length(), b.length()));
		
		
		// ???????????????????????????????
		List<Long> numbers = LongStream.range(0,(long)1e7).boxed().collect(Collectors.toList());
		long result = numbers.parallelStream().reduce(0L, (x,y) -> x + y);
		System.out.println(result);
		
		
		
		
		
	}
}
