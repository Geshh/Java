package characters;

public class Warrior extends Hero {

	public Warrior(String name, String title, int health, int mana, int manaRegen) {
		super(name, title, health, mana, manaRegen);
	}

	@Override
	public void usePassiveAbility(Enemy enemy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getHeroClass() {
		return "Warrior";
	}

}
