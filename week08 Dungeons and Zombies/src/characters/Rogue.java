package characters;

import damageDealers.DamageDealers;
import damageDealers.Weapon;

public class Rogue extends Hero {

	private Weapon secondaryWeapon;

	public Rogue(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
		secondaryWeapon = new Weapon("Dagger", 15);
	}

	@Override
	public void usePassiveAbility(int damage , Enemy enemy) {
		System.out.println("Rogue strikes again from the shadows");
		enemy.takeDamage(damage);
	}

	@Override
	public void attack() {
		System.out.println("Your rogue attacks the enemy!");
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
	
	@Override
	public DamageDealers getSecondaryDmgDealer() {
		return secondaryWeapon;
	}

}
