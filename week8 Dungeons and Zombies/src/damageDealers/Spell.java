package damageDealers;

public class Spell extends DamageDealers {

	private String name;
	private int damage;
	private int manaCost;
	private int castRange;

	public Spell(String name, int damage, int manaCost, int castRange) {
		super(name, damage);
		this.manaCost = manaCost;
		this.castRange = castRange;
	}

	public void getSpellInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Damage: " + this.damage);
		System.out.println("Mana Cost: " + this.manaCost);
		System.out.println("Cast Range: " + this.castRange);
	}

	public int getManaCost() {
		return manaCost;
	}

	public int getCastRange() {
		return castRange;
	}
}
