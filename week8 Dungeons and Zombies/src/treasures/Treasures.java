package treasures;

import java.util.Random;

import damageDealers.Spell;
import damageDealers.Weapon;

public class Treasures {

	private Weapon[] weapons = { new Weapon("fsdfds", 50), new Weapon("Fdsfdfs", 50), new Weapon("fsdfds", 40),
			new Weapon("Executioner of Eternal Glory", 50), new Weapon("Edge of Eternity, Oath of the Night Sky", 50) };
	private Spell[] spells = { new Spell("Remorse", 10, 10, 3), new Spell("Fiery Typhoon", 10, 10, 3),
			new Spell("Shooting Star", 10, 10, 3), new Spell("Meteor", 10, 10, 3) };

	public Spell getRandomSpell() {
		Random randomGen = new Random();
		int randomNumber = randomGen.nextInt(spells.length);
		return spells[randomNumber];
	}

	public Weapon getRandomWeapon() {
		Random randomGen = new Random();
		int randomNumber = randomGen.nextInt(weapons.length);
		return weapons[randomNumber];
	}

}
