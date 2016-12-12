package characters;

import damageDealers.Weapon;

public class Warrior extends Hero {

	Weapon secondaryWeapon;

	public Warrior(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
		secondaryWeapon = new Weapon("Throwable axe", 50);
	}

	@Override
	public void usePassiveAbility() {
		System.out.println("Bloodthirsty");
	}

	@Override
	public void attack(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getHeroClass() {
		return "Warrior";
	}

	@Override
	public void getAvailableMoves() {
		if (this.secondaryWeapon != null) {
			System.out.println("-Throw secondary wep at enemy.");
		}
		if (this.getMana() >= this.primarySpell.getManaCost()) {
			System.out.println("-Use primary spell.");
		}
		System.out.println("-Smash with primary weapon.");
		System.out.println("-Use potion.");
	}

}
