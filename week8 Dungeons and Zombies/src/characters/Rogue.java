package characters;

import damageDealers.Weapon;

public class Rogue extends Hero {

	Weapon secondaryWeapon;

	public Rogue(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
		secondaryWeapon = new Weapon("Dagger", 15);
	}

	@Override
	public void usePassiveAbility() {
		System.out.println("Stealth attack");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getHeroClass() {
		return "Rogue";
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
		System.out.println("-Step back.");
		System.out.println("-Use potion.");
	}

}
