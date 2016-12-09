package damageDealers;

public class Weapon extends DamageDealers {

	private String name;
	private int damage;

	public Weapon(String name, int damage) {
		super(name, damage);
	}

	public void getWeaponInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Damage: " + this.damage);
	}

}
