package pandaSocialNetwork;

public class Panda {

	private String name;
	private String email;
	private String gender;

	public Panda() {
		name = "";
		email = "";
		gender = "";
	}

	public Panda(String name, String email, String gender) {
		setName(name);
		if (isEmailValid(email)) {
			setEmail(email);
		} else {
			setEmail("userIs@Retarded.com");
		}
		setGender(gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		String result = "";

		result += "Panda name: " + this.getName() + "\n";
		result += "Panda email: " + this.getEmail() + "\n";
		result += "Panda gender: " + this.getGender() + "\n";

		return result;
	}

	public boolean equals(Panda other) {
		return this.getName().equals(other.getName()) && this.getGender().equals(other.getGender())
				&& this.getEmail().equals(other.getEmail());
	}

	public boolean isMale() {
		return this.getGender() == "male";
	}

	public boolean isFemale() {
		return !this.isMale();
	}

	private boolean isEmailValid(String email) {
		return (email.length() >= 5 && email.contains("@") && email.substring(email.indexOf('@')).contains("."));
	}

}
