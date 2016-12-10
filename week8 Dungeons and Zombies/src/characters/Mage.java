package characters;

import damageDealers.Spell;

public class Mage extends Hero {

	Spell secondarySpell;

	public Mage(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
		secondarySpell = new Spell("Fireball", 25, 40, 3);
	}

	@Override
	public void usePassiveAbility() {
		System.out.println("Freeze");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	}

	@Override
	public String getHeroClass() {
		return "Mage";
	}

	@Override
	public void getAvailableMoves() {
		if (this.secondarySpell != null) {
			System.out.println("-Use secondary spell.");
		}
		if (this.getMana() >= this.primarySpell.getManaCost()) {
			System.out.println("-Use primary spell.");
		}
		System.out.println("-Smash with primary weapon.");
		System.out.println("-Use potion.");
	}

}
