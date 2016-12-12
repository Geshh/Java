package dungeon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import characters.Enemy;
import characters.Hero;
import damageDealers.Spell;
import damageDealers.Weapon;
import fight.Fight;
import treasures.Treasures;

public class Dungeon {

	private String[][] map;
	private Position curHeroPosition;
	private boolean isLevelComplete;
	private Hero hero;

	public Dungeon(String levelName, Hero hero) {
		generateMap(levelName);
		isLevelComplete = false;
		this.hero = hero;
	}

	@SuppressWarnings("resource")
	private void pickTreasure(int choice) {
		Scanner scanner = new Scanner(System.in);
		String answer;
		switch (choice) {
		case 0:
			System.out.println("Sorry treasure is empty\n");
			break;
		case 1:
			Spell spell = Treasures.getRandomSpell();
			spell.getSpellInfo();
			System.out.println("Do you with to learn new spell and replace it with your current primary spell?");
			System.out.println("Yes/No:");
			answer = scanner.nextLine();
			if (answer.equals("Yes")) {
				System.out.println("New spell learned!");
				hero.learn(spell);
			}
			break;
		case 2:
			Weapon weapon = Treasures.getRandomWeapon();
			System.out.println("You found ");
			weapon.getWeaponInfo();
			System.out.println("Do you with to equip new weapon and replace it with your current primary weapon?");
			answer = scanner.nextLine();
			if (answer.equals("Yes")) {
				System.out.println("New weapon equiped");
				hero.equip(weapon);
			}
			break;
		case 3:
			System.out.println("Your hero found a potion , Max health and mana! \n");
			hero.takeHealing(50);
			hero.takeMana(25);
			break;
		}
	}

	public boolean isLevelComplete() {
		return isLevelComplete;
	}

	public void moveHero(String direction, Scanner scanner) {

		String destination = "";
		int newX = curHeroPosition.getX();
		int newY = curHeroPosition.getY();

		switch (direction) {
		case "left":
			if (curHeroPosition.getY() - 1 < 0) {
				System.out.println("Cannot step outside the map");
			} else {
				destination = map[curHeroPosition.getX()][curHeroPosition.getY() - 1];
				newX = curHeroPosition.getX();
				newY = curHeroPosition.getY() - 1;
			}
			break;
		case "right":
			if (curHeroPosition.getY() + 1 >= map[curHeroPosition.getX()].length) {
				System.out.println("Cannot step outside the map");
			} else {
				destination = map[curHeroPosition.getX()][curHeroPosition.getY() + 1];
				newX = curHeroPosition.getX();
				newY = curHeroPosition.getY() + 1;
			}
			break;
		case "up":
			if (curHeroPosition.getX() - 1 < 0) {
				System.out.println("Cannot step outside the map");
			} else {
				destination = map[curHeroPosition.getX() - 1][curHeroPosition.getY()];
				newX = curHeroPosition.getX() - 1;
				newY = curHeroPosition.getY();
			}
			break;
		case "down":
			if (curHeroPosition.getX() + 1 >= map.length) {
				System.out.println("Cannot step outside the map");
			} else {
				destination = map[curHeroPosition.getX() + 1][curHeroPosition.getY()];
				newX = curHeroPosition.getX() + 1;
				newY = curHeroPosition.getY();
			}
			break;
		}

		if (destination.equals("#")) {
			System.out.println("Your hero hit a wall , be careful!");

		} else if (!destination.equals("")) {

			if (destination.equals("E")) {
				System.out.println("Enemy has approached!\nYou have to fight it!!");
				System.out.println(
						"You want to take care of it by yourself or let the game automatically play the battle? :");
				System.out.println("1: Manual fight");
				System.out.println("2: Automatic fight");
				int choice = scanner.nextInt();

				//Generate enemy
				int temp = hero.getHealth() / 2;
				Random rand = new Random();
				int enemyHealth = rand.nextInt(temp) + temp;
				temp = hero.getMana() / 2;
				int enemyMana = rand.nextInt(temp) + temp;

				Enemy enemy = new Enemy(enemyHealth, enemyMana, 25);

				switch (choice) {
				case 1:
					System.out.println("You chose to fight the enemy alone!Good Luck!");
					Fight.manualFight(hero, enemy);
					break;
				case 2:
					System.out.println("Lay back and enjoy the fight!");
					break;
				}

			} else if (destination.equals("T")) {
				System.out.println("Treasure found!!!");
				Random randomGen = new Random();
				int randomNumber = randomGen.nextInt(4);
				pickTreasure(randomNumber);

			} else if (destination.equals("G")) {
				System.out.println("Level Completed!!");
				isLevelComplete = true;
			}
			hero.takeDamage(hero.getManaRegen());
			map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
			curHeroPosition.setX(newX);
			curHeroPosition.setY(newY);
			map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
		}

		// switch (direction) {
		// case "left":
		// if (curHeroPosition.getY() - 1 < 0) {
		// System.out.println("Cannot step outside the map");
		// } else {
		// String destination =
		// map[curHeroPosition.getX()][curHeroPosition.getY() - 1];
		// if (destination.equals("E")) {
		// System.out.println("ENEMY");
		// System.out.println("1: Manual fight");
		// System.out.println("2: Automatic fight");
		// // START FIGHT
		// } else if (destination.equals("T")) {
		// System.out.println("TREASURE");
		// Random randomGen = new Random();
		// int randomNumber = randomGen.nextInt(4);
		// pickTreasure(randomNumber);
		// // OPEN TREASURE
		// } else if (destination.equals("G")) {
		// System.out.println("LEVEL COMPLETED");
		// isLevelComplete = true;
		// // LEVEL COMPLETE
		// } else if (destination.equals("#")) {
		// System.out.println("Obstacle encountered , move other direction ");
		// break;
		// }
		// hero.takeMana(hero.getManaRegen());
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
		// curHeroPosition.setY(curHeroPosition.getY() - 1);
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
		// }
		// break;
		// case "right":
		// if (curHeroPosition.getY() + 1 >= map[curHeroPosition.getX()].length)
		// {
		// System.out.println("Cannot step outside the map");
		// } else {
		// String destination =
		// map[curHeroPosition.getX()][curHeroPosition.getY() + 1];
		// if (destination.equals("E")) {
		// System.out.println("ENEMY");
		// System.out.println("1: Manual fight");
		// System.out.println("2: Automatic fight");
		// // START FIGHT
		// } else if (destination.equals("T")) {
		// System.out.println("TREASURE");
		// Random randomGen = new Random();
		// int randomNumber = randomGen.nextInt(4);
		// pickTreasure(randomNumber);
		// // OPEN TREASURE
		// } else if (destination.equals("G")) {
		// System.out.println("LEVEL COMPLETED");
		// isLevelComplete = true;
		// // LEVEL COMPLETE
		// } else if (destination.equals("#")) {
		// System.out.println("Obstacle encountered , move other direction ");
		// break;
		// }
		// hero.takeMana(hero.getManaRegen());
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
		// curHeroPosition.setY(curHeroPosition.getY() + 1);
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
		// }
		// break;
		// case "up":
		// if (curHeroPosition.getX() - 1 < 0) {
		// System.out.println("Cannot step outside the map");
		// } else {
		// String destination = map[curHeroPosition.getX() -
		// 1][curHeroPosition.getY()];
		// if (destination.equals("E")) {
		// System.out.println("ENEMY");
		// System.out.println("1: Manual fight");
		// System.out.println("2: Automatic fight");
		// // START FIGHT
		// } else if (destination.equals("T")) {
		// System.out.println("TREASURE");
		// Random randomGen = new Random();
		// int randomNumber = randomGen.nextInt(4);
		// pickTreasure(randomNumber);
		// // OPEN TREASURE
		// } else if (destination.equals("G")) {
		// System.out.println("LEVEL COMPLETED");
		// isLevelComplete = true;
		// // LEVEL COMPLETE
		// } else if (destination.equals("#")) {
		// System.out.println("Obstacle encountered , move other direction ");
		// break;
		// }
		// hero.takeMana(hero.getManaRegen());
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
		// curHeroPosition.setX(curHeroPosition.getX() - 1);
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
		// }
		// break;
		// case "down":
		// if (curHeroPosition.getX() + 1 >= map.length) {
		// System.out.println("Cannot step outside the map");
		// } else {
		// String destination = map[curHeroPosition.getX() +
		// 1][curHeroPosition.getY()];
		// if (destination.equals("E")) {
		// System.out.println("ENEMY");
		// System.out.println("1: Manual fight");
		// System.out.println("2: Automatic fight");
		// // START FIGHT
		// } else if (destination.equals("T")) {
		// System.out.println("TRESURE");
		// Random randomGen = new Random();
		// int randomNumber = randomGen.nextInt(4);
		// pickTreasure(randomNumber);
		// // OPEN TREASURE
		// } else if (destination.equals("G")) {
		// System.out.println("LEVEL COMPLETED");
		// isLevelComplete = true;
		// // LEVEL COMPLETE
		// } else if (destination.equals("#")) {
		// System.out.println("Obstacle encountered , move other direction ");
		//
		// break;
		// }
		// hero.takeMana(hero.getManaRegen());
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
		// curHeroPosition.setX(curHeroPosition.getX() + 1);
		// map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
		// }
		// break;
		// }
	}

	public void spawn() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j].equals("S")) {
					map[i][j] = "H";
					curHeroPosition = new Position(i, j);
				}
			}
		}
	}

	public void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private void generateMap(String levelName) {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/Levels/";
		FILENAME += levelName;

		Queue<String> rows = new LinkedList<>();

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null && !sCurrentLine.equals("")) {
				rows.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		map = new String[rows.size()][];
		for (int i = 0; i < map.length; i++) {
			String line = rows.poll();
			map[i] = new String[line.length()];

			for (int j = 0; j < line.length(); j++) {
				map[i][j] = String.valueOf(line.charAt(j));
			}
		}

		// PRINT MAP
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}
	}
}
