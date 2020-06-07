package appendixC;

public class Monster {
    private int health;
    private Breed breed;

    public Monster(Breed breed) {
        this.health = breed.getHealth();
    }
    public Monster(int health) {
        this.health = health;
    }

    public String getAttack() {
        return breed.getAttack();
    }
}
