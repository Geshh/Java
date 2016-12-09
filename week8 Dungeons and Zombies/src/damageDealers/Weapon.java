package damageDealers;

public class Weapon {
	
	private String name;
	private int damage;
	
	public Weapon(String name, int damage) {
		this.name=name;
		this.damage=damage;
	}
	
	public void getWeaponName() {
		System.out.println("Name: " + this.name);
	}
	
	public void getWeaponDamage() {
		System.out.println("Damage: " + this.damage);
	}

	public void getWeaponInfo() {
		getWeaponName();
		getWeaponDamage();
	}
}
