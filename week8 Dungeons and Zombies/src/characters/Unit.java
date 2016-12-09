package characters;

public abstract class Unit {

	private int health;
	private int currentHealth;
	private int mana;
	private int currentMana;

	public Unit(int health, int mana) {
		this.health = health;
		this.mana = mana;
		currentHealth = health;
		currentMana = mana;
	}

	public boolean isAlive() {
		return currentHealth > 0;
	}

	public boolean canCast() {
		return currentMana > 0;
	}

	public int getHealth() {
		return currentHealth;
	}

	public int getMana() {
		return currentMana;
	}

	public void takeDamage(int damage) {
		if (damage > currentHealth) {
			currentHealth = 0;
		} else {
			currentHealth -= damage;
		}
	}

	public void takeHealing(int heal) {
		if (currentHealth + heal > health) {
			currentHealth = health;
		} else {
			currentHealth += heal;
		}
	}

	public void takeMana(int mana) {
		if (currentMana + mana > this.mana) {
			currentMana = this.mana;
		} else {
			currentMana += mana;
		}
	}

	public abstract void attack();

}