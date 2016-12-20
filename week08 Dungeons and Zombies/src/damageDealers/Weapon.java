package damageDealers;

public class Weapon extends DamageDealers {

	public Weapon(String name, int damage) {
		super(name, damage);
	}

	public void getWeaponInfo() {
		System.out.println("Name: " + this.getName());
		System.out.println("Damage: " + this.getDamage());
	}

}
