package treasures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import damageDealers.Spell;
import damageDealers.Weapon;

public class Treasures {

	@SuppressWarnings("resource")
	public Spell getRandomSpell() {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/Treasures/";
		FILENAME += "Spells";

		BufferedReader br = null;
		FileReader fr = null;
		String sCurrentLine = "";

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			int count = 1;
			Random random = new Random();
			int randNumber = random.nextInt(9) + 1;

			br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null && count != randNumber) {
				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] parts = sCurrentLine.split("\t");
		parts[0].trim();
		parts[1].trim();

		String[] stats = parts[1].split(" ");
		int spellDamage = Integer.parseInt(stats[0]);
		int spellManaCost = Integer.parseInt(stats[1]);
		int spellRange = Integer.parseInt(stats[2]);

		Spell spell = new Spell(parts[0], spellDamage, spellManaCost, spellRange);

		return spell;
	}

	@SuppressWarnings("resource")
	public Weapon getRandomWeapon() {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/Treasures/";
		FILENAME += "Weapons";

		BufferedReader br = null;
		FileReader fr = null;

		String sCurrentLine = "";

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			int count = 1;
			Random random = new Random();
			int randNumber = random.nextInt(9) + 1;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null && count != randNumber) {
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You chose : " + sCurrentLine);

		String[] parts = sCurrentLine.split(",Damage:");
		parts[0] = parts[0].trim();
		parts[1] = parts[1].trim();

		int weaponDamage = Integer.parseInt(parts[1]);
		
		Weapon weapon = new Weapon(parts[0], weaponDamage);

		return weapon;
	}

}
