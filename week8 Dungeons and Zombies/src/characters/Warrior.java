package characters;

import damageDealers.Weapon;

public class Warrior extends Hero {

	Weapon secondaryWeapon;

	public Warrior(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
		secondaryWeapon = new Weapon("Throwable axe", 50);
	}
	
	@Override
	public void usePassiveAbility(Enemy enemy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getHeroClass() {
		return "Warrior";
	}

	@Override
	public void getAvailableMoves() {
		if(this.secondaryWeapon!=null) {
			System.out.println("-Throw axe at enemy.");
		}
		if(this.getMana()>=this.primarySpell.getManaCost()) {
			System.out.println("-Use primary spell.");
		}
		System.out.println("-Smash with primary weapon.");
		System.out.println("-Step back.");
		System.out.println("-Use potion.");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
