package collectionsSort;

public class Student implements Comparable<Student> {

	private final String firstName;
	private final String secondName;
	private final int grade;

	public Student(String firstName, String secondName, int grade) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.grade = grade;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public int getGrade() {
		return grade;
	}


	@Override
	public int compareTo(Student other) {
		int cmp = this.getFirstName().compareToIgnoreCase(other.getFirstName());

		if (cmp == 0) {
			cmp = this.getSecondName().compareToIgnoreCase(other.getSecondName());
		}
		
		return cmp;
	}

}
