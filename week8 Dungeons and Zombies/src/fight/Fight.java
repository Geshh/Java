package fight;

import characters.Enemy;
import characters.Hero;
import damageDealers.Spell;
import damageDealers.Weapon;

public class Fight {

	public static boolean automaticFight(Hero hero, Enemy enemy) {
		if (hero.getHeroClass().equals("Warrior") || hero.getHeroClass().equals("Rogue")) {
			int startingHealth = hero.getHealth();

			int maxDmg = Math.max(hero.getPrimaryWeapon().getDamage(), hero.getSecondaryDmgDealer().getDamage());
			while (true) {
				hero.attack();

				if (hero.getHealth() <= startingHealth / 2) {
					hero.usePassiveAbility(maxDmg, enemy);
				}

				enemy.takeDamage(maxDmg);
				System.out.println(maxDmg + " damage dealt");

				if (!enemy.isAlive()) {
					System.out.println("You Won!");
					return true;
				}

				System.out.println("Enemy attacks with " + enemy.getDamage() + " damage");
				hero.takeDamage(enemy.getDamage());
				if (!hero.isAlive()) {
					System.out.println("You Lost!");
					return false;
				}

				System.out.println("Your health: " + hero.getHealth());
				System.out.println("Enemy health: " + enemy.getHealth());
			}
		} else {
			int startingHealth = hero.getHealth();

			Spell spellToUse;
			Weapon wepInCase = hero.getPrimaryWeapon();
			if (hero.getPrimarySpell().getDamage() > hero.getSecondaryDmgDealer().getDamage()) {
				spellToUse = hero.getPrimarySpell();
			} else {
				spellToUse = (Spell) hero.getSecondaryDmgDealer();
			}

			boolean isPassiveOn = false;

			while (true) {
				hero.attack();

				if (hero.getHealth() <= startingHealth / 2) {
					if (!isPassiveOn) {
						hero.usePassiveAbility(spellToUse.getManaCost(), enemy);
						isPassiveOn = true;
					}
				}

				if (hero.getMana() >= spellToUse.getManaCost()) {
					enemy.takeDamage(spellToUse.getDamage());
					hero.useMana(spellToUse.getManaCost());
				} else {
					enemy.takeDamage(wepInCase.getDamage());
				}
				if (!enemy.isAlive()) {
					System.out.println("You Won!");
					return true;
				}

				System.out.println("Enemy  attacks");
				hero.takeDamage(enemy.getDamage());
				if (!hero.isAlive()) {
					System.out.println("You Lost!");
					return false;
				}
			}
		}
	}

	public static boolean manualFight(Hero hero, Enemy enemy) {

		return true;
	}
}
