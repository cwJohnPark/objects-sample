package appendixC;

/**
 * 새로운 몬스터를 클래스로 만들지 않고 품종을 이용하여 설계하도록 한다.
 */
public class Breed {
    private String name;
    private int health;
    private String attack;

    public Breed(String name, int health, String attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getAttack() {
        return attack;
    }
}
