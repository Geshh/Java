package damageDealers;

public abstract class DamageDealers {

	private String name;
	private int damage;

	public DamageDealers(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

}
