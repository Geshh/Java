package fight;

import characters.Enemy;
import characters.Hero;

public class Fight {

	public static void automaticFight(Hero hero, Enemy enemy) {
		if (hero.getHeroClass().equals("Mage")) {
			int weaponDmg = hero.getPrimaryWeaponDamage();
			int spellDmg = hero.getPrimarySpellDamage();

			while (hero.getHealth() <= 0 || enemy.getHealth() <= 0) {
				
			}

		}
	}

	public static void manualFight(Hero hero, Enemy enemy) {

	}
}
