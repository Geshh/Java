package characters;

import damageDealers.DamageDealers;
import damageDealers.Spell;

public class Mage extends Hero {

	private Spell secondarySpell;

	public Mage(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
		secondarySpell = new Spell("Fireball", 25, 40, 3);
	}

	@Override
	public void usePassiveAbility(int points, Enemy enemy) {
		System.out.println(
				"Your mage found hidden power in himself , granting him free spells untill the end of the battle");
		this.takeMana(points);
	}

	@Override
	public void attack() {
		System.out.println("Your mage attacks the enemy!");
	}

	public Spell getSpell() {
		return secondarySpell;
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

	@Override
	public DamageDealers getSecondaryDmgDealer() {
		return secondarySpell;
	}

}
