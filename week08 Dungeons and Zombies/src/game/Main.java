
package game;

import java.util.Scanner;

import characters.Hero;
import characters.Mage;
import characters.Rogue;
import characters.Warrior;
import damageDealers.Spell;
import damageDealers.Weapon;
import dungeon.Dungeon;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello ,Motherfucker! ");
		System.out.println("Welcome to Dungeons and Zombies!");
		System.out.println("Before we let you into the dungeons you must create your Hero!!!!");
		System.out.print("Enter your name: ");
		String name = scanner.next();
		System.out.print("Title: ");
		String title = scanner.next();
		System.out.print("Health: ");
		int health = scanner.nextInt();
		System.out.print("Mana: ");
		int mana = scanner.nextInt();
		System.out.print("Mana Regen: ");
		int manaRegen = scanner.nextInt();
		System.out.println("Well done " + name);

		System.out.println("In this game you can choose to specialize in 3 different classes: ");
		System.out.println("-Warrior\n-Mage\n-Rogue\n");
		System.out.println("Choose a class (1:Warrior , 2:Mage , 3:Rogue ) : ");
		int choice = scanner.nextInt();
		Hero hero;
		switch (choice) {
		case 1:
			hero = new Warrior(name, title, health, mana, manaRegen);
			break;
		case 2:
			hero = new Mage(name, title, health, mana, manaRegen);
			break;
		case 3:
			hero = new Rogue(name, title, health, mana, manaRegen);
			break;
		default:
			hero = new Warrior(name, title, health, mana, manaRegen);
			break;
		}

		System.out.println("\nTime to choose a starting weapon for your " + hero.getHeroClass() + ": ");
		FileParser.getAvailableWeapons(hero.getHeroClass());
		System.out.println("Enter your choice: ");
		int weaponChoice = scanner.nextInt();
		Weapon weapon = FileParser.readAndEquipWeapon(weaponChoice, hero.getHeroClass());
		hero.equip(weapon);
		System.out.println("\n\nTime to choose your primary spell! ");
		FileParser.getAvailableSpells(hero.getHeroClass());
		int spellChoice = scanner.nextInt();
		Spell spell = FileParser.readAndEquipSpells(spellChoice, hero.getHeroClass());
		hero.learn(spell);

		switch (hero.getHeroClass()) {
		case "Warrior":
			System.out.println(
					"\nYour warrior can also carry one additional weapon which he can swap or throw at enemies!\n");
			break;
		case "Mage":
			System.out.println("\nYour mage can also learn one additional spell during your quest!\n");
			break;
		case "Rogue":
			System.out.println("\nYour rogue can also carry one additional weapon and throw it at enemies!\n");
			break;
		}

		System.out.println(hero.knownAs() + " you are ready!\n");
		System.out.println("Some info about your hero: \n");
		System.out.println(hero.knownAs());
		System.out.println("Class :" + hero.getHeroClass());
		System.out.println("Health :" + hero.getHealth());
		System.out.println("Mana :" + hero.getMana());
		System.out.println("Mana Regen :" + hero.getManaRegen());
		System.out.println("\nPrimary Weapon : ");
		weapon.getWeaponInfo();
		System.out.println("\nPrimary spell : ");
		spell.getSpellInfo();
		if (hero.getHeroClass().equals("Mage")) {
			System.out.println("\nSecondary spell: ");
			System.out.println("Name: Fireball \nDamage:25\nMana Cost: 40 \nCast Range: 3 ");
		} else if (hero.getHeroClass().equals("Warrior")) {
			System.out.println("\nSecondary weapon: ");
			System.out.println("Name: Throwable axe \nDamage: 50");
		} else {
			System.out.println("\nSecondary weapon: ");
			System.out.println("Name: Dagger \nDamage: 15");
		}

		for (int i = 0; i < 4; i++) {
			System.out.println("\nGenerating level " + (i + 1));
			String levelName = "Level" + (i + 1);
			Dungeon dungeon = new Dungeon(levelName, hero);
			dungeon.spawn();
			System.out.println("\n\n");
			System.out.println("Hero has spawned! ");
			dungeon.printMap();

			String movement;

			while (!dungeon.isLevelComplete()) {
				System.out.println("\nMove:");
				movement = scanner.next();
				dungeon.moveHero(movement,scanner);
				dungeon.printMap();

			}

		}

		scanner.close();
	}
}
