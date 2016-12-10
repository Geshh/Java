package dungeon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Dungeon {

	private String[][] map;
	private Position curHeroPosition;

	public Dungeon() {
		generateMap();
	}

	public void moveHero(String direction) {

		switch (direction) {
		case "left":
			if (curHeroPosition.getY() - 1 < 0) {
				System.out.println("Cannot step outside the map");
			} else {
				String destination = map[curHeroPosition.getX()][curHeroPosition.getY() - 1];
				if (destination.equals("E")) {
					System.out.println("ENEMY");
					// START FIGHT
				} else if (destination.equals("T")) {
					System.out.println("TREASURE");
					// OPEN TREASURE
				} else if (destination.equals("G")) {
					System.out.println("LEVEL COMPLETED");
					// LEVEL COMPLETE
				} else if (destination.equals("#")) {
					System.out.println("Obstacle encountered , move other direction ");
					break;
				}
				map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
				curHeroPosition.setY(curHeroPosition.getY() - 1);
				map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
			}
			break;
		case "right":
			if (curHeroPosition.getY() + 1 >= map[curHeroPosition.getX()].length) {
				System.out.println("Cannot step outside the map");
			} else {
				String destination = map[curHeroPosition.getX()][curHeroPosition.getY() + 1];
				if (destination.equals("E")) {
					System.out.println("ENEMY");
					// START FIGHT
				} else if (destination.equals("T")) {
					System.out.println("TREASURE");
					// OPEN TREASURE
				} else if (destination.equals("G")) {
					System.out.println("LEVEL COMPLETED");
					// LEVEL COMPLETE
				} else if (destination.equals("#")) {
					System.out.println("Obstacle encountered , move other direction ");
					break;
				}
				map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
				curHeroPosition.setY(curHeroPosition.getY() + 1);
				map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
			}
			break;
		case "up":
			if (curHeroPosition.getX() - 1 < 0) {
				System.out.println("Cannot step outside the map");
			} else {
				String destination = map[curHeroPosition.getX() - 1][curHeroPosition.getY()];
				if (destination.equals("E")) {
					System.out.println("ENEMY");
					// START FIGHT
				} else if (destination.equals("T")) {
					System.out.println("TREASURE");
					// OPEN TREASURE
				} else if (destination.equals("G")) {
					System.out.println("LEVEL COMPLETED");
					// LEVEL COMPLETE
				} else if (destination.equals("#")) {
					System.out.println("Obstacle encountered , move other direction ");
					break;
				}
				map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
				curHeroPosition.setX(curHeroPosition.getX() - 1);
				map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
			}
			break;
		case "down":
			if (curHeroPosition.getX() + 1 >= map.length) {
				System.out.println("Cannot step outside the map");
			} else {
				String destination = map[curHeroPosition.getX() + 1][curHeroPosition.getY()];
				if (destination.equals("E")) {
					System.out.println("ENEMY");
					// START FIGHT
				} else if (destination.equals("T")) {
					System.out.println("TRESURE");
					// OPEN TREASURE
				} else if (destination.equals("G")) {
					System.out.println("LEVEL COMPLETED");
					// LEVEL COMPLETE
				} else if (destination.equals("#")) {
					System.out.println("Obstacle encountered , move other direction ");
					break;
				}
				map[curHeroPosition.getX()][curHeroPosition.getY()] = ".";
				curHeroPosition.setX(curHeroPosition.getX() + 1);
				map[curHeroPosition.getX()][curHeroPosition.getY()] = "H";
			}
			break;
		}
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

	private void generateMap() {
		String FILENAME = "/home/geshh/code/101java/week8 Dungeons and Zombies/Levels/Level1";

		Queue<String> levels = new LinkedList<>();

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				levels.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		map = new String[levels.size()][];
		for (int i = 0; i < map.length; i++) {
			String line = levels.poll();
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
