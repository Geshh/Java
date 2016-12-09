package hash;

public class BulgarianPerson extends Person {

	private String ucn;
	
	public String getUcn() {
		return ucn;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}

		if(obj instanceof BulgarianPerson) {
			BulgarianPerson other = (BulgarianPerson)obj;
			if(this.getFirstName().equals(other.getFirstName()) && this.getUcn().equals(other.getUcn())) {
				return true;
			}
		}
		
		if (obj instanceof Person) {
			Person other = (BulgarianPerson)obj;
			if(this.getFirstName().equals(other.getFirstName())) {
				return true;
			}
		}
		return false;

	}
}
