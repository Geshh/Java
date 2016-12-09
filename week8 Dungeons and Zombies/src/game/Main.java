package game;

import java.util.Scanner;

import characters.Hero;
import characters.Hunter;
import characters.Mage;
import characters.Rogue;
import characters.Warrior;
import damageDealers.Spell;
import damageDealers.Weapon;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello ,player! ");
		System.out.println("Welcome to Dungeons and Zombies!");
		System.out.println("Before we let you into the dungeons you must create your Hero!!!!");
		System.out.println("Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Title: ");
		String title = scanner.nextLine();
		System.out.println("Health: ");
		int health = scanner.nextInt();
		System.out.println("Mana: ");
		int mana = scanner.nextInt();
		System.out.println("Mana Regen: ");
		int manaRegen = scanner.nextInt();
		System.out.println("Well done " + name);

		System.out.println("In this game you can choose to specialize in 4 different classes: ");
		System.out.println("-Warrior\n-Mage\n-Rogue\n-Hunter\n");
		System.out.println("Choose a class (1:Warrior , 2:Mage , 3:Rogue , 4:Hunter) : ");
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
		case 4:
			hero = new Hunter(name, title, health, mana, manaRegen);
			break;
		default:
			hero = new Warrior(name, title, health, mana, manaRegen);
			break;
		}

		System.out.println("Time to choose a starting weapon for your " + hero.getHeroClass() + ": ");
		hero.getAvailableWeapons(hero.getHeroClass());
		System.out.println("Enter your choice: ");
		int weaponChoice = scanner.nextInt();
		Weapon weapon = hero.readAndEquipWeapon(weaponChoice, hero.getHeroClass());
		hero.equip(weapon);
		System.out.println("Time to choose your primary spell! ");
		hero.getAvailableSpells(hero.getHeroClass());
		int spellChoice = scanner.nextInt();
		Spell spell = hero.readAndEquipSpells(spellChoice, hero.getHeroClass());
		hero.learn(spell);
		

		scanner.close();
	}
}
