package characters;

public class Enemy extends Unit {

	private int damage;

	public Enemy(int health, int mana, int damage) {
		super(health, mana);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}
	

	@Override
	public void attack() {
		//DJASLFDSJLFKDSFJKLDSFJKLDSFJKLDSFJDSKL
		if (damage > 1) {
			damage += 1;
		}
	}

}
