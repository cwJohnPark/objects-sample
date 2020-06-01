package appendixC;

public class Troll extends Monster {

    public Troll(int health) {
        super(health);
    }

    @Override
    public String getAttack() {
        return "트롤은 곤봉으로 때린다.";
    }
}
