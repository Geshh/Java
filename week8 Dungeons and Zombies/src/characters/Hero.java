package characters;

import damageDealers.DamageDealers;
import damageDealers.Spell;
import damageDealers.Weapon;

public abstract class Hero extends Unit {

	private String name;
	private String title;
	private int manaRegen;
	Weapon primaryWeapon;
	Spell primarySpell;

	public Hero(String name, String title, int health, int mana, int manaRegen) {
		super(health, mana);
		this.name = name;
		this.title = title;
		this.manaRegen = manaRegen;
	}

	public String knownAs() {
		return this.name + " the " + this.title;
	}

	public int getManaRegen() {
		return manaRegen;
	}

	public void equip(Weapon weapon) {
		this.primaryWeapon = weapon;
	}

	public void learn(Spell spell) {
		this.primarySpell = spell;
	}

	public Spell getPrimarySpell() {
		return primarySpell;
	}

	public Weapon getPrimaryWeapon() {
		return primaryWeapon;
	}

	public abstract DamageDealers getSecondaryDmgDealer();

	public abstract void getAvailableMoves();

	public abstract String getHeroClass();

	public abstract void usePassiveAbility(int points, Enemy enemy);

}
