package characters;

import damageDealers.DamageDealers;
import damageDealers.Weapon;

public class Warrior extends Hero {

	private Weapon secondaryWeapon;

	public Warrior(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
		secondaryWeapon = new Weapon("Throwable axe", 50);
	}

	@Override
	public void usePassiveAbility(int damage, Enemy enemy) {
		System.out.println("Warrior got bloodthirsty , healing himself with half of the damage dealt");
		this.takeHealing(damage / 2);
	}

	@Override
	public void attack() {
		System.out.println("Your warrior attacks the enemy!");
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

	@Override
	public DamageDealers getSecondaryDmgDealer() {
		return secondaryWeapon;
	}

}
