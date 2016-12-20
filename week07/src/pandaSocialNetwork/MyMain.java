package pandaSocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class MyMain {
	public static void main(String[] args) {

		PandaSocialNetwork network = new PandaSocialNetwork();
		Panda ivo = new Panda("Ivo", "ivo@pandamail.com", "male");
		Panda rado = new Panda("Rado", "rado@pandamail.com", "male");
		Panda tony = new Panda("Tony", "tony@pandamail.com", "female");
		Panda geshh = new Panda("Geshh", "geshh@gmail.com", "male");
		
		network.addPanda(geshh);
		network.addPanda(ivo);
		network.addPanda(rado);
		network.addPanda(tony);

		network.makeFriends(ivo, rado);
		network.makeFriends(rado, tony);
		network.makeFriends(ivo, geshh);

		System.out.println(network.areFriends(ivo, rado));
		List<Panda> lst = new ArrayList<>(network.friendsOf(rado));
		
		for(Panda panda : lst) {
			System.out.println(panda);
		}
		
		System.out.println(network.howManyGenderInNetwork(1, rado, "female"));

	}
}
