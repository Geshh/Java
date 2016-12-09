package hash;

public class Person {

	private final String firstName = "Geshh";
	private String secondName;

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		if (this.secondName == null) {
			this.secondName = "D0ubleN";
		}
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public int hashCode() {
		return getFirstName().hashCode();
	}

	// a.equals(a) -> true
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (obj instanceof Person) {
			Person other = (Person) obj;
			if (this.getFirstName().equals(other.getFirstName())
					&& this.getSecondName().equals(other.getSecondName())) {
				return true;
			}
		}
		return false;
	}

}
