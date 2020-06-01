package appendixC;

public abstract class MonsterAbstract {
    private int health;

    public MonsterAbstract(int health) {
        this.health = health;
    }

    abstract public String getAttack();
}
