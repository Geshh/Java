package pandaSocialNetwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PandaSocialNetwork {

	private Map<Panda, Set<Panda>> network;

	public PandaSocialNetwork() {
		network = new HashMap<>();
	}

	public void addPanda(Panda panda) {
		if (!hasPanda(panda)) {
			network.put(panda, new HashSet<>());
		}
	}

	public boolean hasPanda(Panda panda) {
		return network.containsKey(panda);
	}

	public void makeFriends(Panda panda1, Panda panda2) {
		if (!panda1.equals(panda2)) {
			if (!hasPanda(panda1)) {
				addPanda(panda1);
			}
			if (!hasPanda(panda2)) {
				addPanda(panda2);
			}
			network.get(panda1).add(panda2);
			network.get(panda2).add(panda1);
		}
	}

	public boolean areFriends(Panda panda1, Panda panda2) {
		return network.get(panda1).contains(panda2) && network.get(panda2).contains(panda1);
	}

	public Set<Panda> friendsOf(Panda panda1) {
		try {
			return network.get(panda1);
		} catch (NullPointerException ex) {
			System.out.println("Panda is not existing");
			System.out.println(ex.getStackTrace());
			return null;
		}
	}

	public boolean areConnected(Panda panda1, Panda panda2) {
		return connectionLevel(panda1, panda2) >= 1;
	}

	public int connectionLevel(Panda panda1, Panda panda2) {
		Queue<Panda> bfs = new LinkedList<>();

		if (areFriends(panda1, panda2)) {
			return 1;
		}

		int connectionLevel = 0;
		int friendsCount = 0;

		bfs.add(panda1);

		while (!bfs.isEmpty()) {

			if (bfs.contains(panda2)) {
				return connectionLevel;
			} else {
				connectionLevel += 1;
			}

			friendsCount = bfs.size();

			for (int i = 0; i < friendsCount; i++) {
				bfs.addAll(network.get(bfs.poll()));
			}
		}
		return -1;
	}

	public int howManyGenderInNetwork(int level, Panda panda, String gender) {
		Queue<Panda> bfs = new LinkedList<>();

		int currentLevel = 0;
		int friendsCount = 0;

		bfs.add(panda);

		while (currentLevel < level) {
			friendsCount = bfs.size();
			currentLevel += 1;
			for (int i = 0; i < friendsCount; i++) {
				bfs.addAll(network.get(bfs.poll()));
			}
		}

		int result = 0;
		for (Panda p : bfs) {
			if (p.getGender().equals(gender)) {
				result += 1;
			}
		}

		return result;
	}

}
