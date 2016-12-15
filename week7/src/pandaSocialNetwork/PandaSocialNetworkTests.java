package pandaSocialNetwork;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PandaSocialNetworkTests {

	private PandaSocialNetwork psn;

	@Before
	public void setUp() {
		psn = new PandaSocialNetwork();
	}

	@Test
	public void isNetworkNotEmptyAfterAddingPanda() {
		Panda panda = new Panda("Geshh", "geshh@gmail.com", "Male");

		psn.addPanda(panda);

		assertNotNull(psn);
	}

	@Test
	public void hasPandaTest() {
		Panda panda = new Panda("Geshh", "geshh@gmail.com", "Male");
		psn.addPanda(panda);
		assertEquals(true, psn.hasPanda(panda));
	}

	@Test(timeout = 1)
	public void isFast() {
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

		for (Panda panda : lst) {
			System.out.println(panda);
		}

		System.out.println(network.howManyGenderInNetwork(1, rado, "female"));
	}

}
