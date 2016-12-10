package damageDealers;

public class Spell extends DamageDealers {

	private int manaCost;
	private int castRange;

	public Spell(String name, int damage, int manaCost, int castRange) {
		super(name, damage);
		this.manaCost = manaCost;
		this.castRange = castRange;
	}

	public void getSpellInfo() {
		System.out.println("Name: " + this.getName());
		System.out.println("Damage: " + this.getDamage());
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
