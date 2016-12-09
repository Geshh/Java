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
	Weapon weapon;
	Spell spell;

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
		this.weapon = weapon;
	}

	public void learn(Spell spell) {
		this.spell = spell;
	}

	public void getAvailableWeapons(String heroClass) {

		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/";
		FILENAME += heroClass;

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
	public Weapon readAndEquipWeapon(int choice, String heroClass) {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/";
		FILENAME += heroClass;

		BufferedReader br = null;
		FileReader fr = null;

		String sCurrentLine="";
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);


			br = new BufferedReader(new FileReader(FILENAME));
			int counter = 1;
			while ((sCurrentLine = br.readLine()) != null && counter!=choice) {
				counter++;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(sCurrentLine);
		
		String[] parts = sCurrentLine.split(",Damage:");
		parts[0] = parts[0].trim();
		parts[1] = parts[1].trim();
		for(int i=0;i<parts.length;i++) {
			System.out.println(parts[i]);
		}
		int weaponDamage = Integer.parseInt(parts[1]);
		
		Weapon weapon = new Weapon(parts[0] , weaponDamage);
		
		return weapon;
	}
	
	public abstract String getHeroClass();
	
	public abstract void usePassiveAbility(Enemy enemy);

}
