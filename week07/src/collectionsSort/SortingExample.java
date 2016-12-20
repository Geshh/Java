package collectionsSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		
		students.add(new Student("aloo", "mi6ka", 1));
		students.add(new Student("Ivan", "Gei", 5));
		students.add(new Student("Ivan", "Mangal", 1));
		students.add(new Student("Ivan", "Mazen", 3));
		students.add(new Student("Ivan", "Akam", 9));

		// I
		Collections.sort(students);

		// II
		// reverse sort with comparator
		// Collections.sort(students, new Comparator<Student>() {
		//
		// @Override
		// public int compare(Student first, Student second) {
		// // return first.getFirstName().compareTo(second.getFirstName());
		// return second.getFirstName().compareTo(first.getFirstName());
		// }
		// });

		// sort by grade with comparator
		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student first, Student second) {
				return ((Integer) first.getGrade()).compareTo((Integer) second.getGrade());
			}

		});

		for (Student s : students) {
			System.out.print(s.getFirstName() + " ");
			System.out.println(s.getSecondName());
		}

	}
}
