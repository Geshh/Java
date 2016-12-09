package characters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import damageDealers.Spell;
import damageDealers.Weapon;

public abstract class Hero extends Unit {

	private String name;
	private String title;
	private int manaRegen;
	Weapon primaryWeapon;
	Spell primarySpell;

	public Hero(String name, String title, int health, int mana, int manaRegen) {
		super(health, mana);
		this.name = name;
		this.title = title;
		this.manaRegen = manaRegen;
	}

	public String knownAs() {
		return this.name + " the " + this.title;
	}

	public int getManaRegen() {
		return manaRegen;
	}

	public void equip(Weapon weapon) {
		this.primaryWeapon = weapon;
	}

	public void learn(Spell spell) {
		this.primarySpell = spell;
	}

	public void getAvailableSpells(String heroClass) {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/";
		FILENAME += heroClass;
		FILENAME += "Spells";

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));
			int counter = 1;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(counter++ + "-" + sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getAvailableWeapons(String heroClass) {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/";
		FILENAME += heroClass;
		FILENAME += "Weapons";

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));
			int counter = 1;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(counter++ + "-" + sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public Spell readAndEquipSpells(int choice, String heroClass) {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/";
		FILENAME += heroClass;
		FILENAME += "Spells";

		BufferedReader br = null;
		FileReader fr = null;

		String sCurrentLine = "";

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			br = new BufferedReader(new FileReader(FILENAME));
			int counter = 1;
			while ((sCurrentLine = br.readLine()) != null && counter != choice) {
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You chose : " + sCurrentLine);

		String[] parts = sCurrentLine.split("\t");
		parts[0].trim();
		parts[1].trim();

		String[] stats = parts[1].split(" ");
		int spellDamage = Integer.parseInt(stats[0]);
		int spellManaCost = Integer.parseInt(stats[1]);
		int spellRange = Integer.parseInt(stats[2]);
		
		return new Spell(parts[0], spellDamage, spellManaCost, spellRange);
	}

	@SuppressWarnings("resource")
	public Weapon readAndEquipWeapon(int choice, String heroClass) {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/";
		FILENAME += heroClass;
		FILENAME += "Weapons";

		BufferedReader br = null;
		FileReader fr = null;

		String sCurrentLine = "";

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			br = new BufferedReader(new FileReader(FILENAME));
			int counter = 1;
			while ((sCurrentLine = br.readLine()) != null && counter != choice) {
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You chose : " + sCurrentLine);

		String[] parts = sCurrentLine.split(",Damage:");
		parts[0] = parts[0].trim();
		parts[1] = parts[1].trim();

		int weaponDamage = Integer.parseInt(parts[1]);

		return new Weapon(parts[0], weaponDamage);
	}

	public abstract void getAvailableMoves();

	public abstract String getHeroClass();

	public abstract void usePassiveAbility();

}
